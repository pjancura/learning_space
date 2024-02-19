let cohort15 = ["Paul","Eugene","Ira","Russell","Antonio","Loomis","Todd","Chandler","Amber"]


function team_randomizer(l){

    console.log("\n\n****************************************************");
    //console.log(`${l}`);
    let team1 = [];
    let team2 = [];
    let counter = 0;            //maintains the length of what is left to assign to a team
    let runPicker = true;
    let counter2 = 0;
    while (runPicker){
        //console.log(`${l}`);   //////////////
        counter2++;
        if (counter < l.length){
            counter += 1;
        }
        //console.log(`\nl - counter ${l.length - counter}\ncounter ${counter}`)       
        randInt = Math.floor(Math.random() * (l.length - counter));
        //console.log(`randInt ${randInt}`)
        item = l.splice(randInt, 1);
        popped = item.join();
        //console.log(popped);   //////////////////
        randInt2 = Math.ceil(Math.random() * 2);
        if (l.length == (team1.length + team2.length)){                 //this accounts for an odd numbered list
            team1.push(` ${popped}`);
            l.push("Tie breaker");
        } else if ((randInt2 == 1) && (team1.length < Math.floor((l.length/2)))){       //this makes sure that teams are equal in size
            team1.push(` ${popped}`);
            l.push("team1")
        } else if ((randInt2 == 2) && (team2.length < (Math.floor((l.length/2))))){
            team2.push(` ${popped}`);
            l.push("team2");
        } else {
            l.unshift(popped);
            counter--;
            //console.log("put it back, try again   " + l);
        }
        //console.log(`l.length ${l.length}\nteam1 + team2 ${team1.length + team2.length}`)
        //console.log(`original l ${l}`)
        if (l.length == team1.length + team2.length){
            console.log(`\nEnding team_randomizer()\nI ran ${counter2} times to assign the teams.`);
            break;
        }
        if (counter2 == 100){
            console.log("\nI ran 100 times boss\n");
            runPicker = False;
        }
    }
    console.log(`\n********** TEAMS *********\n`);
    console.log(`Here is Team 1: \n\t${team1}\n`);
    console.log(`Here is Team 2: \n\t${team2}\n`);
    console.log(`**********       **********\n`);
}

team_randomizer(cohort15)

