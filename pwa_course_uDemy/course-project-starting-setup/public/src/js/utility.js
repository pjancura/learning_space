
// opens database and creates a new object store when needed
let dbPromise = idb.open('posts-store', 1, (db) => {
    if (!db.objectStoreNames.contains('posts')) {
        db.createObjectStore('posts', {keyPath: 'id'});
    }
});

function writeData(store, data) {
    return dbPromise
        .then((db) => {
            console.log('writeData() store: ', store);
            let tx = db.transaction(store, 'readwrite');
            let objectStore = tx.objectStore(store);
            objectStore.put(data);
            return tx.complete;
        })
}

function readAllData(store) {
    // console.log("readAllData() before .then() store: ", store);
    return dbPromise
        .then((db) => {
            console.log('readAllData() store: ', store);
            let tx = db.transaction(store, 'readonly');
            let objectStore = tx.objectStore(store);
            return objectStore.getAll();
        })
}

function clearAllData(st) {
    return dbPromise
      .then(db => {
        var tx = db.transaction(st, 'readwrite');
        var store = tx.objectStore(st);
        store.clear();
        return tx.complete;             // must return complete here to ensure database integrity
      });
  }

  function deleteItemFromData(st, id) {
    return dbPromise
        .then(db => {
            let tx = db.transaction(st, 'readwrite');
            let store = tx.objectStore(st);
            store.delete(id);
            return tx.complete;
        })
        .then(() => {
            console.log('Item Deleted');
        })
  }