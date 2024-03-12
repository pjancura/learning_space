// service workers only work over https (because of the power they have)
let deferredPrompt;

if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/sw.js')          // scope of the service worker can be restricted by passing an object as an argument
    .then(function(){
        console.log('Service worker registered!');
    });
} else {
    console.log("Service workers not supported");
}


self.addEventListener('beforeinstallprompt', (event) => {
    // Prevent the mini-infobar from appearing on mobile
    event.preventDefault();
    // Stash the event so it can be triggered later.
    deferredPrompt = event;
    // Update UI notify the user they can install the PWA
    // showInstallPromotion();
    // Optionally, send analytics event that PWA install promo was shown.
    console.log(`[Service Worker] 'beforeinstallprompt' event was fired.`);
    return false;
});