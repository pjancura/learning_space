// a service worker does not have DOM access

const STATIC_CACHE_VERSION = 'static_v9';
const DYNAMIC_CACHE_VERSION = 'dynamic_v4';
const APPSHELL = [
    '/', 
    '/index.html',
    '/offline.html', 
    '/src/js/app.js', 
    '/src/js/feed.js', 
    '/src/js/promise.js', 
    '/src/js/fetch.js', 
    '/src/js/material.min.js',
    '/src/css/app.css',
    '/src/css/feed.css',
    'src/images/main-image.jpg',
    'https://fonts.googleapis.com/css?family=Roboto:400,700',
    'https://fonts.googleapis.com/icon?family=Material+Icons',
    'https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.3.0/material.indigo-pink.min.css'
];

function trimCache(cacheName, maxItems) {                   // this could be implemented in many different locations, common ones are on install and on activate, because they do not happen as often, but I will implement mine in our fetch request, look up cache limits for browsers
    caches.open(cacheName)
        .then(cache => {
            return cache.keys()
                .then(trimCache(cacheName, maxItems));
        })
        .then(keys => {
            if (keys.length > maxItems) {
                cache.delete(keys[0])
            }
        })
}

// install and activate are triggered by the browser
// Initialize deferredPrompt for use later to show browser install prompt.
self.addEventListener('install', function(event) {
    console.log('[Service Worker] Installing Service Worker ...', event);
    event.waitUntil(caches.open(STATIC_CACHE_VERSION)         // waitUntil() keeps the script from progressing until the function is completed, the cache needs to have a name as well
        .then((cache) => {
            console.log(cache);
            console.log('[Service Worker] Precaching APPSHELL');
            // think of this as caching requests ...not paths
            // cache.add('/');
            // cache.add('/index.html');
            // cache.add('/src/js/app.js');
            cache.addAll(APPSHELL);
        })
    )
})

self.addEventListener('activate', function(event) {
    console.log('[Service Worker] Activating Service Worker ...', event);
    event.waitUntil(
        caches.keys()
            .then((keyList) => {
                return Promise.all(keyList.map((key) => {           // Promise.all() takes an array of promises and waits until all are returned
                    if (key !== STATIC_CACHE_VERSION && key !== DYNAMIC_CACHE_VERSION) {
                        console.log('[Service Worker] Removing old cache.', key);
                        return caches.delete(key);
                    }
                }))
            })
    )
    return self.clients.claim();
});

// fetch is triggered by the application
// self.addEventListener('fetch', function(event) {
//     // console.log('[Service Worker] Fetching Something ...', event);
//     event.respondWith(fetch(event.request));
// })


// checks if url is in our APPSHELL array
function isInArray(string, array) {
    var cachePath;
    if (string.indexOf(self.origin) === 0) { // request targets domain where we serve the page from (i.e. NOT a CDN)
      console.log('matched ', string);
      cachePath = string.substring(self.origin.length); // take the part of the URL AFTER the domain (e.g. after localhost:8080)
    } else {
      cachePath = string; // store the full request (for CDNs)
    }
    return array.indexOf(cachePath) > -1;
  }

self.addEventListener('fetch', (event) => {
    let url = 'https://httpbin.org/get';
    
    if (event.request.url.indexOf(url) > -1) {
        event.respondWith(
            caches.open(DYNAMIC_CACHE_VERSION)
                .then(cache => {
                    return fetch(event.request)
                        .then(res => {
                            jtrimCache(DYNAMIC_CACHE_VERSION, 8);
                            cache.put(event.request, res.clone());
                            return res;
                        })
                })
        )
        // the following else if block is an example of a cache only strategy
        //      this is really only useful for your APPSHELL
    // } else if (new RegExp('//b' + APPSHELL.join('//b//b') + '//b').test(event.requst.url)) {       
    } else if (isInArray(event.request.url, APPSHELL)) {
        event.respondWith(
            caches.match(event.request)
        )
    } else {
        event.respondWith(
            caches.match(event.request)
                .then((response) => {
                    if (response) {
                        return response;
                    } else {
                        console.log("[Service Worker] Unable to find file in cache");
                        return fetch(event.request)
                        .then((res) => {
                            caches.open(DYNAMIC_CACHE_VERSION)
                                .then((cache) => {
                                    cache.put(event.request.url, res.clone());  
                                    return res;
                                });
                        })
                        .catch(err => {
                            console.log(`ERROR: ${err}`);
    
                            return caches.open(STATIC_CACHE_VERSION)            // this allows us to show something meaningful if a page wasn't cached and redirect the user
                                .then(cache => {
                                    if (event.request.headers.get('accept').includes('text/html')) {        // more inclusive way to implement fallback cache items
                                        return cache.match('/offline.html');
                                    }
                                })
                        });
                    }
                })
        )
    }
    // console.log(event);
    // console.log(caches);
})

