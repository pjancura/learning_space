// const User = {
//   name: "paul",
//   email: "paul@paul.com",
//   isActive: true,
// };

// function createUser({ name: string, isPaid: boolean }) {}

// let newUser = {
//   name: "paul",
//   isPaid: false,
//   email: "paul@PublicKeyCredential.com",
// };

// createUser(newUser);

// function createCourse(): { name: string; price: number } {
//   return { name: "react", price: 399 };
// }

// type User = {
//   name: string;
//   email: string;
//   isActive: boolean;
// };

// function createUser(user: User): User {
//   return { name: "", email: "", isActive: true };
// }

// createUser({ name: "", email: "", isActive: true });

type User = {
  readonly _id: string; // for when a property can be readonly
  name: string;
  email: string;
  isActive: boolean;
  credcardDetails?: number; // ? for when a property is optional
};

type cardNumber = {
  cardnumber: string;
};

type cardDate = {
  cardDate: string;
};

// this is a way to create a composite object
type cardDetails = cardNumber &
  cardDate & {
    cvv: number;
  };

let myUser: User = {
  _id: "12345",
  name: "h",
  email: "h@h.com",
  isActive: false,
};

myUser.email = "p@p.com";
// myUser._id = "123"

export {};
