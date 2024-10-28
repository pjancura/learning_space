interface AppUser {
  readonly dbId: number;
  email: string;
  userId: number;
  googleId?: string;
  //   startTrial: () => string;
  startTrial(): string; // 2 ways of defining a property should be function that returns something
  getCoupon(couponname: string, value: number): number;
}

// this is an example of re-opening the interface
// it allows you to add more properties to an already existing interface
// this is useful when using 3rd party libraries
interface AppUser {
  githubToken: string;
}

interface AppAdmin extends AppUser {
  role: "admin" | "ta" | "learner";
}

const user1122: AppAdmin = {
  dbId: 22,
  email: "p@p.com",
  userId: 1122,
  role: "learner",
  startTrial: () => {
    return "trial started";
  },
  getCoupon: (name: "paul10", discount: 10) => {
    return 10;
  },
  githubToken: "123123",
};

user1122.email = "h@h.com";
