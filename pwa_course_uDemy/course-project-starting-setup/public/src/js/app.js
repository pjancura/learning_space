// service workers only work over https (because of the power they have)
let deferredPrompt;

// the xhr code is synchronous
//  we want ours to be asynchronous
//      that is why we are going to use the fetch API
//          b/c service workers are all about asynchronicity
// let xhr = new XMLHttpRequest();
// xhr.open('GET', 'https://httpbin.org/ip');
// xhr.responseType = 'json';

// xhr.onload = () => {
//     console.log(xhr.response);
// };

// xhr.onerror = () => console.log('Error!');
// xhr.send();

//  POLYFILLS
//      help with legacy browser support

if (!window.Promise) {
    window.Promise = Promise;
}

if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/sw.js')          // scope of the service worker can be restricted by passing an object as an argument
    .then(function(){
        console.log('Service worker registered!');
    })
    .catch((err) => {
        console.log(err);
    })};


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


fetch("https://httpbin.org/ip")
    .then((response) => {
    console.log(response);
    return response.json();
    })
    .then((data) => {
        console.log(data);
    });

fetch("https://httpbin.org/post", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    mode: 'cors',
    body: JSON.stringify({message: 'Does this work?'})})
    .then((response) => {
    console.log(response);
    return response.json();
    })
    .then((data) => {
        console.log(data);
    });

// let promise = new Promise(function(resolve, reject) {
//     setTimeout(function() {
//         // resolve('this is executed ONCE setTimeout() timer runs out');
//         reject({code: 500, message: 'An error occurred!'});
//         // console.log('this is executed ONCE setTimeout() timer runs out');
//     }, 3000);
// });

// promise.then((text) => {
//         return text
//     }).then((newText) => {
//         console.log(newText);
// }).catch((err) => {
//     console.log(err.code, err.message);
// });


console.log('this is executed right after setTimeout()');