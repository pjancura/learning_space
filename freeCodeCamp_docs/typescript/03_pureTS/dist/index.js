"use strict";
// using in the CLI    "tsc -w"
// puts the compiler in "watch" mode
// it will watch for changes in your .ts files and write them into your .js files
// the output directory is defined in the tsconfig.json file
// and tsconfig.json is created with "tsc --init"
class User {
    constructor(email, name, userId) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        //   public email: string;
        //   public name: string;
        // private means that it is only accessible inside the class
        this.city = "Seven";
        // remember protected means that it is not accessible outside of a class
        // but it can be inherited unlike private
        this._courseCount = 1;
    }
    deletetoken() {
        console.log("token deleted");
    }
    get getAppleEmail() {
        return `apple${this.email}`;
    }
    get courseCount() {
        return this._courseCount;
    }
    // setters have no return type, this is a common interview question
    // not even :void
    set courseCount(courseNumber) {
        if (courseNumber <= 1) {
            throw new Error("Course count should be more than 1");
        }
        this._courseCount = courseNumber;
    }
}
class SubUser extends User {
    constructor() {
        super(...arguments);
        // remember private things cannot be accessed outside the class
        this.isFamily = true;
    }
    changeCourseCount() {
        this._courseCount = 4;
    }
}
const paul = new User("p@p.com", "paul", "007");
