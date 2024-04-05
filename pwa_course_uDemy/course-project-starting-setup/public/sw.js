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



self.addEventListener('fetch', (event) => {
    let url = 'https://httpbin.org/get';
    
    if (event.request.url.indexOf(url) > -1) {
        event.respondWith(
            caches.open(DYNAMIC_CACHE_VERSION)
                .then(cache => {
                    return fetch(event.request)
                        .then(res => {
                            cache.put(event.request, res.clone());
                            return res;
                        })
                })
        )
        // the following else if block is an example of a cache only strategy
        //      this is really only useful for your APPSHELL
    } else if (new RegExp('//b' + APPSHELL.join('//b//b') + '//b').test(event.requst.url)) {       
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
                                    if (event.request.url.indexOf('/help')) {
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

