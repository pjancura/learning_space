function addTwo(num: number): number {
  return num + 2;
}

function getUpper(val: string) {
  return val.toUpperCase();
}

function signUpUser(
  name: string,
  email: string,
  password: string,
  isPaid: boolean
) {}

let loginUser = (nmae: string, email: string, isPaid: boolean = false) => {};

addTwo(5);
getUpper("george");
signUpUser("george", "george@email.com", "password123", true);
loginUser("P", "p@p.p");

// getValue need to return a "union" of types
// function getValue(myVal: number) {
//   if (myVal > 5) {
//     return true;
//   }
//   return "200 OK";
// }

const getHello = (s: string): string => {
  return "";
};

const heros = ["thor", "spiderman", "ironman"];
// const heros = [1, 2, 3];

heros.map((hero: string): string => {
  return `hero is ${hero}`;
});

function consoleError(errmsg: string): void {
  console.log(errmsg);
}

// never type represents values which are never observed. In a return type,
// this means that the function throws an exception or terminates execution
// of the program.
function handleError(errmsg: string): never {
  throw new Error(errmsg);
}

export {};
