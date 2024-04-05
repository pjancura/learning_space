
var CACHE_STATIC_NAME = 'static-v26';
var CACHE_DYNAMIC_NAME = 'dynamic-v4';
let APPSHELL = [
  '/',
  '/index.html',
  '/offline.html',
  '/src/css/app.css',
  '/src/css/main.css',
  '/src/js/main.js',
  '/src/js/material.min.js',
  'https://fonts.googleapis.com/css?family=Roboto:400,700',
  'https://fonts.googleapis.com/icon?family=Material+Icons',
  'https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.3.0/material.indigo-pink.min.css'
]



self.addEventListener('install', function(event) {
  event.waitUntil(
    caches.open(CACHE_STATIC_NAME)
      .then(function(cache) {
        cache.addAll(APPSHELL);
      })
  )
});

self.addEventListener('activate', function(event) {
  event.waitUntil(
    caches.keys()
      .then(function(keyList) {
        return Promise.all(keyList.map(function(key) {
          if (key !== CACHE_STATIC_NAME) {
            return caches.delete(key);
          }
        }));
      })
  );
});

// --------------              NETWORK-ONLY STRATEGY
// self.addEventListener('fetch', event => {
//   event.respondWith(
//     fetch(event.request)
//   )
// })

// --------------              CACHE-ONLY STRATEGY
// self.addEventListener('fetch', event => {
//   event.respondWith(
//     caches.match(event.request)
//   )
// })


// --------------              NETWORK WITH CACHE FALLBACK STRATEGY
// self.addEventListener('fetch', function(event) {
//   event.respondWith(
//     fetch(event.request)
//       .then( res => {
//         return caches.open(CACHE_DYNAMIC_NAME)
//           .then(cache => {
//             cache.put(event.request.url, res.clone());
//             return res;
//           })
//       })
//       .catch(function(err) {
//         return caches.match(event.request);
//     })
//   );
// });


// --------------              CACHE THEN NETWORK STRATEGY
// self.addEventListener('fetch', event => {
//   console.log(event);
//   event.respondWith(
//     caches.match(event.request)
//       .then(response => {
//         if (response) {
//           return response;
//         } else {
//           return fetch(event.request)
//             .then(res => {
//               console.log(res);
//               return caches.open(CACHE_DYNAMIC_NAME)
//                 .then(cache => {
//                   cache.put(event.request.url, res.clone());
//                   return res;
//                 })
//             })
//           }
//       })
//   )
// });

// --------------              CACHE THEN NETWORK STRATEGY with FALLBACK
// self.addEventListener('fetch', event => {
//   event.respondWith(
//     caches.match(event.request)
//       .then(response => {
//         if (response) {
//           return response;
//         } else {
//           return fetch(event.request)
//             .then(res => {
//               return caches.open(CACHE_DYNAMIC_NAME)
//                 .then(cache => {
//                   cache.put(event.request.url, res.clone());
//                   return res;
//                 })
//             })
//             .catch(err => {
//               return caches.open(CACHE_STATIC_NAME)
//                 .then(cache => {
//                   if (event.request.url.indexOf('/dynamic')) {
//                     return cache.match('/offline.html');
//                   }
//                 })
//             })
//         }
//       })
//   )
// })


// --------------              CACHE THEN NETWORK STRATEGY with 'ROUTING'
// self.addEventListener('fetch', event => {
//   event.respondWith(
//     caches.match(event.request)
//       .then(response => {
//         if (response) {
//           return response;
//         } else {
//           return fetch(event.request)
//             .then(res => {
//               return caches.open(CACHE_DYNAMIC_NAME)
//                 .then(cache => {
//                   cache.put(event.request.url, res.clone());
//                   return res;
//                 })
//             })
//             .catch(err => {
//               return caches.open(CACHE_STATIC_NAME)
//                 .then(cache => {
//                   return cache.match('/offline.html');
//                 })
//             })
//         }
//       })
//   )
// })

// --------------              CACHE PREFERRED with 'ROUTING'
self.addEventListener('fetch', event => {
  // Cache then network for url
  let url = 'https://httpbin.org/ip';
  // console.log("EVENT: " + event.request.url);
  if (event.request.url.indexOf(url) > -1) {
    console.log("indexOf: /ip: " + event.request.url.indexOf(url));
    event.respondWith(
      caches.match(event.request)
        .then(response => {
          if (response) {
            return response;
          } else {
            return fetch(event.request)
              .then(response => {
                return caches.open(CACHE_DYNAMIC_NAME)
                  .then(cache => {
                    cache.put(event.request.url, response.clone());
                    return response;
                  })
              })
          }
        })
        .catch(err => {
          console.log("ERROR /ip: " + err);
        })
    )
  // cache only
  } else if (new RegExp('//b/' + APPSHELL.join('//b//b') + '//b').test(event.request.url)) {
    console.log('ended in else if');
    event.respondWith(caches.match(event.request));
  // cache, with network fallback for dynamic cache
  } else {  
    event.respondWith(
      caches.match(event.request)
      .then(response => {
        if (response) {
          return response;
        } else {
          return fetch(event.request)
          .then(res => {
            console.log("trying to find: " + res);
            return caches.open(CACHE_DYNAMIC_NAME)
            .then(cache => {
              cache.put(event.request.url, res.clone());
              return res;
            })
          })
          .catch(err => {
            console.log("ERROR: ", err);
            return caches.open(CACHE_STATIC_NAME)
            .then(cache => {
              if (event.request.url.indexOf('dynamic')) {
                return cache.match('/offline.html');
              }
            })
            })
        }
      })
    )}
})





