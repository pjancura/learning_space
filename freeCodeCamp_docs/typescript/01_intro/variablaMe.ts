let greetings: string = "Hello Paul";

greetings.toLowerCase();

console.log(greetings);

// number
let userId: number = 334455;

// boolean
let isLoggedIn: boolean = false;

// for primitives the type of a variable can be inferred
// you do not need to do the : type notation
// b/c this is considered obvious
// since the value is given near where the variable is declared

// any

let hero: string;

function getHero() {
  return "thor";
}

hero = getHero();

export {};
