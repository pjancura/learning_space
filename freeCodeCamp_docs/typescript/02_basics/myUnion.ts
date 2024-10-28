let score: number | string = 33;

score = 44;

score = "55";

type User = {
  name: string;
  id: number;
};

type Admin = {
  userName: string;
  id: number;
};

let paul: User | Admin = { name: "paul", id: 445 };

paul = { userName: "paul", id: 445 };

// function getDbId(id: number | string) {
//   console.log(`DB id is: ${id}`);
// }

getDbId(3);
getDbId("3");

function getDbId(id: number | string) {
  // example of type narrowing
  if (typeof id === "string") {
    id.toLowerCase();
  }
  console.log(`DB id is: ${id}`);
}

// array

const data: number[] = [1, 2, 3];
const data2: string[] = ["1", "2", "3"];
const data3: (string | number)[] = ["1", "2", 3];

let seatAllotment: "aisle" | "middle" | "window";

seatAllotment = "aisle";
seatAllotment = "crew";
