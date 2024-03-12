// a service worker does not have DOM access



// install and activate are triggered by the browser
// Initialize deferredPrompt for use later to show browser install prompt.
self.addEventListener('install', function(event) {
    console.log('[Service Worker] Installing Service Worker ...', event);
})

self.addEventListener('activate', function(event) {
    console.log('[Service Worker] Activating Service Worker ...', event);
    return self.clients.claim();
})

// fetch is triggered by the application
self.addEventListener('fetch', function(event) {
    console.log('[Service Worker] Fetching Something ...', event);
    event.respondWith(fetch(event.request));
})
