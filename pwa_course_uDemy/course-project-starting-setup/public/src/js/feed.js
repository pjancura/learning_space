var shareImageButton = document.querySelector('#share-image-button');
var createPostArea = document.querySelector('#create-post');
var closeCreatePostModalButton = document.querySelector('#close-create-post-modal-btn');
var sharedMomentsArea = document.querySelector('#shared-moments');

function openCreatePostModal() {
  // createPostArea.style.display = 'block';
  setTimeout(() => createPostArea.style.transform = 'translateY(0)',
    30);
  
  if (deferredPrompt) {
    deferredPrompt.prompt();

    deferredPrompt.userChoice.then(function(choiceResult) {
      console.log(choiceResult.outcome);

      if (choiceResult.outcome === 'dismissed') {
        console.log('User cancelled installation');
      } else {
        console.log('User added to home screen');
      }
    });

    deferredPrompt = null;
  }
  // this bit of code will unregister the service worker and is an example of how to do so in other places
  // if ('serviceWorker' in navigator) {
  //   navigator.serviceWorker.getRegistrations()
  //     .then(registrations => {
  //       for (let i = 0; i < registrations.length; i++) {
  //         registrations[i].unregister();
  //       }
  //     })
  // }
}

function closeCreatePostModal() {
  // createPostArea.style.display = 'none';
  createPostArea.style.transform = 'translateY(100vh)';
}

shareImageButton.addEventListener('click', openCreatePostModal);

closeCreatePostModalButton.addEventListener('click', closeCreatePostModal);


// currently not in use...allows user to save content in cache
// function onSaveButtonClicked(event) {
//   console.log('clicked');
//   if ('caches' in window) {
//     caches.open('userRequested')
//       .then((cache) => {
//         cache.add('https://httpbin.org/get');
//         cache.add('/src/images/sf-boat.jpg');
//       });
//   }
// }

// clearCards() clears the sharedMomentsArea 
function clearCards() {
  while (sharedMomentsArea.hasChildNodes()) {
    sharedMomentsArea.removeChild(sharedMomentsArea.lastChild);
  }
}

function createCard(data) {
  var cardWrapper = document.createElement('div');
  cardWrapper.className = 'shared-moment-card mdl-card mdl-shadow--2dp';
  var cardTitle = document.createElement('div');
  cardTitle.className = 'mdl-card__title';
  cardTitle.style.backgroundImage = `url('${data.image}')`;
  // cardTitle.style.backgroundImage = 'url(' + data.image + ')';        // i believe this line and the one above are the same, just different syntaxes
  cardTitle.style.backgroundSize = 'cover';
  cardWrapper.appendChild(cardTitle);
  var cardTitleTextElement = document.createElement('h2');
  cardTitleTextElement.style.color = 'white';
  cardTitleTextElement.className = 'mdl-card__title-text';
  cardTitleTextElement.textContent = data.title;
  cardTitle.appendChild(cardTitleTextElement);
  var cardSupportingText = document.createElement('div');
  cardSupportingText.className = 'mdl-card__supporting-text';
  cardSupportingText.textContent = data.location;
  cardSupportingText.style.textAlign = 'center';
  // ------  Code was used to demonstrate how the user interactions could save items to the cache
  // let cardSaveButton = document.createElement('button');
  // cardSaveButton.textContent = "SAVE";
  // cardSupportingText.appendChild(cardSaveButton);
  // cardSaveButton.addEventListener('click', onSaveButtonClicked);
  cardWrapper.appendChild(cardSupportingText);
  componentHandler.upgradeElement(cardWrapper);
  sharedMomentsArea.appendChild(cardWrapper);
}


function updateUI(data) {
  clearCards();
  for (let i = 0; i < data.length; i++) {
    createCard(data[i]);
  }
}



let url = 'https://pwagram-f2320-default-rtdb.firebaseio.com/posts.json';
let networkDataReceived = false;

fetch(url, 
  // {
//   method: 'POST',               // POST doesn't work with a cache only approach
//   headers: {
//     'Content-Type': 'application/json',
//     'Accept': 'application/json'
//   },
//   body: JSON.stringify({
//     message: 'Some message'
//   })
// }
)
  .then(function(res) {
    return res.json();
  })
  .then(function(data) {
    networkDataReceived = true;
    console.log('From web', data);
    let dataArray = [];
    for (let key in data) {
      dataArray.push(data[key]);
    }
    updateUI(dataArray);
});

if ('indexedDB' in window) {
  readAllData('posts')              // pull data from indexedDB
    .then( (data) => {
      if(!networkDataReceived) {
        console.log('From cache', data);
        updateUI(data);
      }
    })
  // caches.match(url)
  //   .then(response => {
  //     if (response) {
  //       return response.json();
  //     }
  //   })
  //   .then(data => {
  //     console.log('From cache ', data);
  //     if (!networkDataReceived) {
  //       let dataArray = [];
  //       for (let key in data) {
  //         dataArray.push(data[key]);
  //       }
  //       updateUI(dataArray);
  //     }
  //   })
}
