// generics are used to more narrowly define
// what a function should accept and return
// but this way we don't have to be as specific about what those
// elements are
// we can define what is being passed to the function
// in the <>, the type passed here will carry on
// through the rest of the function

const score: Array<number> = [];

const names: Array<string> = [];

function identityOne(val: boolean | number): boolean | number {
  return val;
}

function identityTwo(val: any): any {
  return val;
}

function identityThree<Type>(val: Type): Type {
  return val;
}

identityThree(3);

identityThree("three");

identityThree(true);

// this is a shorthand version of identityThree
function identityFour<T>(val: T): T {
  return val;
}

interface Bottle {
  brand: string;
  type: number;
}

identityFour<Bottle>({ brand: "yopo", type: 446 });

function getSearchProducts<T>(products: T[]): T {
  // do some database operations
  const myIndex = 3;
  return products[myIndex];
}

// the "<T,>" syntax will not produce an error
// this is show that it is a generic function
// not a .jsx or .tsx function
const getMoreSearchProducts = <T>(products: Array<T>): T => {
  // do some database operations
  const myIndex = 3;
  return products[myIndex];
};

// now this function knows that it is using strings
getMoreSearchProducts<string>(["bottle", "tray", "sink", "brush"]);

function anotherFunction<T, U extends number>(valOne: T, valTwo: U): object {
  return { valOne, valTwo };
}

// now this function throws and error, because U should of type number
// anotherFunction(3, "4");

interface Database {
  connection: string;
  username: string;
  password: string;
}

function anotherFunctionTwo<T, U extends Database>(
  valOne: T,
  valTwo: U
): object {
  return { valOne, valTwo };
}

anotherFunctionTwo("paul", {
  connection: "mysql",
  username: "pjanc",
  password: "globalAccess",
});

// using classes with generics
interface Quiz {
  name: string;
  type: string;
}

interface Course {
  name: string;
  author: string;
  subject: string;
}

// this is an example of a generic class
class Sellable<T> {
  public cart: T[] = [];

  addToCart(product: T) {
    this.cart.push(product);
  }
}
