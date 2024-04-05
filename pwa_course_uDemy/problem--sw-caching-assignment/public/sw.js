const STATIC_CACHE_VERSION = 'static_v4';
const DYNAMIC_CACHE_VERSION = 'dynamic_v2';
const APPSHELL = [
    '/',
    '/index.html',
    '/src/js/main.js',
    '/src/js/material.min.js',
    '/src/css/app.css',
    '/src/css/dynamic.css',
    '/src/css/main.css',
    'https://fonts.googleapis.com/css?family=Roboto:400,700',
    'https://fonts.googleapis.com/icon?family=Material+Icons',
    'https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.3.0/material.indigo-pink.min.css',
    'https://fonts.gstatic.com/s/materialicons/v141/flUhRq6tzZclQEJ-Vdg-IuiaDsNcIhQ8tQ.woff2'

];

self.addEventListener('install', event => {
    console.log('[Service Worker] Installing Service Worker...');
    event.waitUntil(caches.open(STATIC_CACHE_VERSION)
        .then(cache => {
            console.log('[Service Worker] Precaching APPSHELL');
            cache.addAll(APPSHELL);
        })
    );
});

self.addEventListener('activate', event => {
    console.log('[Service Worker] Activating Service Worker ...', event);
    event.waitUntil(
        caches.keys()
            .then((keyList) => {
                return Promise.all(keyList.map((key) => {           // Promise.all() takes an array of promises and waits until all are returned
                    console.log("[Service Worker: Activate: Finding old Caches")
                    if (key !== STATIC_CACHE_VERSION && key !== DYNAMIC_CACHE_VERSION) {
                        console.log('[Service Worker] Removing old cache.', key);
                        return caches.delete(key);
                    }
                }))
            })
    )
    return self.clients.claim();
});

self.addEventListener('fetch', event => {
    console.log(event);
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
                    });
                }
            })
    )
    console.log(caches);
})