// a service worker does not have DOM access

importScripts('/src/js/idb.js');
importScripts('/src/js/utility.js');

// use version no.'s with cache's because it will cause the service worker to update the cache files
const STATIC_CACHE_VERSION = 'static_v15';
const DYNAMIC_CACHE_VERSION = 'dynamic_v4';
const APPSHELL = [
    '/', 
    '/index.html',
    '/offline.html', 
    '/src/js/app.js', 
    '/src/js/feed.js',
    '/src/js/idb.js', 
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


// function trimCache(cacheName, maxItems) {                   // this could be implemented in many different locations, common ones are on install and on activate, because they do not happen as often, but I will implement mine in our fetch request, look up cache limits for browsers
//     caches.open(cacheName)
//         .then(cache => {
//             return cache.keys()
//                 .then(trimCache(cacheName, maxItems));
//         })
//         .then(keys => {
//             if (keys.length > maxItems) {
//                 cache.delete(keys[0])
//             }
//         })
// }

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
    let url = 'https://pwagram-f2320-default-rtdb.firebaseio.com/posts.json';
    // console.log(`requesting ${url}: ${event.request.url.indexOf(url)}`);
    // console.log('[Navigator Status] onLine = ', navigator.onLine);
    if (event.request.url.indexOf(url) > -1 && navigator.onLine) {                              // this IF statement will only run for a regular page reload...not the full resource reload
        console.log('about to fetch posts from DB');
        event.respondWith(
            // caches.open(DYNAMIC_CACHE_VERSION)
            //     .then(cache => {
            fetch(event.request)
                .then(res => {
                //     trimCache(DYNAMIC_CACHE_VERSION, 8);
                //     cache.put(event.request, res.clone());
                    let clonedRes = res.clone();
                    clearAllData('posts')
                        .then(() => {
                            console.log('[IndexedDB] Data cleared');
                            return clonedRes.json()
                        })
                        .then((data) => {
                            for (let key in data) {
                                console.log(`[IndexedDB] Writing to database... \n${JSON.stringify(data[key])}`);
                                writeData('posts', data[key])
                                    // .then(() => {
                                    //     console.log("[IndexedDB] deleting \n", key);
                                    //     deleteItemFromData('posts', key);
                                    // });
                                // dbPromise
                                //     .then((db) => {
                                //         let tx = db.transaction('posts', 'readwrite');
                                //         let store = tx.objectStore('posts');
                                //         store.put(data[key]);
                                //         console.log(`Object placed in IndexedDB:\n\t\t${data[key]}`);
                                //         return tx.complete;      // lets the program know that the transaction is complete
                                //     })
                            }
                        })
                    return res;
                })
                // })
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

self.addEventListener('sync', (event) => {
    console.log('[Service Worker] Background syncing', event);
    if (event.tag === 'sync-new-posts') {
        console.log('[Service Worker] Syncing new Posts');
        event.waitUntil(
            readAllData('sync-posts')
                .then((data) => {
                    let url = 'https://pwagram-f2320-default-rtdb.firebaseio.com/posts.json';
                    for (let dt of data) {
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'applicaiton/json',
                                'Accept': 'application/json'
                            },
                            body: JSON.stringify({
                                id: dt.id,
                                title: dt.title,
                                location: dt.location,
                                image: 'https://firebasestorage.googleapis.com/v0/b/pwagram-f2320.appspot.com/o/sf-boat.jpg?alt=media&token=d1f2569b-5d1e-4e0a-996b-44d5909a661b'
                            })
                        })
                        .then((res) => {
                            console.log('Sent data', res);
                            if (res.ok) {
                                deleteItemFromData('sync-posts', dt.id);
                            }
                        })
                        .catch((err) => {
                            console.log('Error while sending data', err);
                        })
                    }
                })
        )
    }
})


