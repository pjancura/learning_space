// enums restrict the choices of a user or a program
enum SeatChoice {
  AISLE = 10, // numbers can be assigned to the enum, the rest of the options will adjust their number value
  MIDDLE = "middle", // when a string value is given, all values of the enum must then have a value
  WINDOW = "window",
}

const pjSeat = SeatChoice.AISLE;

export {};
