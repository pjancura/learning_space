"use strict";
// generics are used to more narrowly define
// what a function should accept and return
// but this way we don't have to be as specific about what those
// elements are
// we can define what is being passed to the function
// in the <>, the type passed here will carry on
// through the rest of the function
const score = [];
const names = [];
function identityOne(val) {
    return val;
}
function identityTwo(val) {
    return val;
}
function identityThree(val) {
    return val;
}
identityThree(3);
identityThree("three");
identityThree(true);
// this is a shorthand version of identityThree
function identityFour(val) {
    return val;
}
identityFour({ brand: "yopo", type: 446 });
function getSearchProducts(products) {
    // do some database operations
    const myIndex = 3;
    return products[myIndex];
}
// the "<T,>" syntax will not produce an error
// this is show that it is a generic function
// not a .jsx or .tsx function
const getMoreSearchProducts = (products) => {
    // do some database operations
    const myIndex = 3;
    return products[myIndex];
};
// now this function knows that it is using strings
getMoreSearchProducts(["bottle", "tray", "sink", "brush"]);
function anotherFunction(valOne, valTwo) {
    return { valOne, valTwo };
}
function anotherFunctionTwo(valOne, valTwo) {
    return { valOne, valTwo };
}
anotherFunctionTwo("paul", {
    connection: "mysql",
    username: "pjanc",
    password: "globalAccess",
});
// this is an example of a generic class
class Sellable {
    constructor() {
        this.cart = [];
    }
    addToCart(product) {
        this.cart.push(product);
    }
}
