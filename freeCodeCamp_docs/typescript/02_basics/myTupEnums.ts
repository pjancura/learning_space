// const user: (string | number)[] = [1, "pj"];

// below is an example of a tuple
// the order of the array types has been specified
let user: [string, number, boolean];

user = ["pj", 121, true];

let rgb: [number, number, number] = [255, 255, 112];

type User = [number, string];

const newUser: User = [111, "example@google.com"];

newUser[1] = "hc.com";

export {};
