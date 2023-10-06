// var userName1 = "Juan";
// var userName2 = userName1;

// console.log(userName2);

// userName1 = "John";
// userName2 = userName1;
// console.log(userName2);

// let x = 1;
// let y = x--;

// console.log(y);

// let x = 1;
// let y = --x;
// console.log(y);



// let a;
// console.log(a);

// let z = [1, 2, 3, 4];
// console.log(z[5]);

// let color = "red";

//     function whatIsThis() {
//         let color = "blue";
//         console.log(this);
//         console.log(this.color);
//     }
//     whatIsThis();
// function display(name) {
//     var designation = "Your name is ";

//     fullName = function makeDesignation() {
//         return designation + name;
//     };
//     console.log(fullName());
// }

// display("Alex");
// const readline = require('readline').createInterface({
//     input: process.stdin,
//     output: process.stdout,
//   });
  
//   readline.question(`What's your name?`, name => {
//     console.log(`Hi ${name}!`);
//     readline.close();
//   });
// const readline = require('node:readline');
// const { stdin: input, stdout: output } = require('node:process');

// const rl = readline.createInterface({ input, output });

// rl.question('What do you think of Node.js? ', (answer) => {
//   // TODO: Log the answer in a database
//   console.log(`Thank you for your valuable feedback: ${answer}`);

//   rl.close();
// });

// rl.question('Enter a number: ', ([num1, num2]) => {
//     // TODO: Log the answer in a database
//     let sum = parseFloat(num1) + parseFloat(num2);
//     console.log(`This is the answer to ${num1} + ${num2} = ${sum}`);
  
//     rl.close();
//   });

// async function add2Num(){
//     try{
        
    
//     let additive2 = await rl.question("Enter your second integer:", (num2) =>{
//         rl.close();
//         return parseFloat(num2);
//     })
//     await rl.close();
//     let sum = additive1 + additive2;
//     await console.log(`Here is the sum of ${additive1} and ${additive2}: ${sum}`)
// } catch (err){
//  if (err) throw err;
// }}
// add2Num();
// const numbersToAdd= [];
// let tally = 0;


//     rl.question("Enter your first integer:" , (num1) =>{          
//         numbersToAdd.push(parseFloat(num1));
//         console.log(`Your first number was ${num1}`);
//         rl.close();

//         });
    // for(i = 0, i < numbersToAdd.length, i++){
    //     tally += i;
    // };


    // var a = "10", b = 20;
    // console.log( a + b );
    // console.log(b + a);

    // let date = new Date();
    // console.log(date);

    // let getT = date.getTime();
    // console.log(getT);

    // let getTStr = Date.parse("March 20, 2024");
    // console.log(getTStr);

    // let getD = date.getDate();
    // console.log(getD);

    // let getWD = date.getDay();
    // console.log(getWD);

    // let tzOffset = date.getTimezoneOffset();
    // console.log(tzOffset);

    // let utcDate = date.getUTCDate();
    // console.log(utcDate);

    // let utcHours = date.getUTCHours();
    // console.log(utcHours);

    // let dateSet = date.setDate(24);
    // console.log(dateSet);

    // let hoursSet = date.setHours(14, 15,15)
    // console.log(hoursSet);

    let date2 = new Date("April 13, 2023 14:48:00");
    console.log(date2);

    // let hoursSet2 = date2.setHours(2);
    // console.log(date2);

    date2.setHours(1);
    console.log(date2);

    date2.setHours(14, 30);
    console.log(date2);

    date2.toDateString();
    console.log(date2);

    // const obj = {
    //     a: 1,
    //     b: 2,
    //     c: 3,
    //     d: 4
    // }
    
    // for (const key in obj) {
    //     console.log( key )
    // }
    
    // Result: 1, 2, 3, 4

    var dt = new Date(1993, 6, 28, 14, 39, 7);
    console.log( "Formated Date : " + dt.toLocaleString() );

    var dt = new Date(1993, 6, 28, 14, 39, 7);
         console.log( "Formatted Date : " + dt.toDateString());
         console.log(dt.toString());

         dt.setHours(4);
         console.log(dt.toString());
         console.log(dt.toDateString());
         console.log(dt.toLocaleString())

function palindrome(){
    let s = "racecar";
    let revS = "";
    for(i = (s.length-1);i>-1;i--){
        revS += s[i];
    }
    if (s == revS){
        console.log("found palindrome");
    } else {
        console.log("not a palindrome");
    }
}
palindrome();


