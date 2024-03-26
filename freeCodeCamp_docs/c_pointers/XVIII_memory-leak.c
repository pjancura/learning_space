// demonstration of memory leak
// "Simple Betting Game"
// we will have "Jack" "Queen" "King"
// now computer shuffles cards
// player has to guess the position of queen
// if he wins, he takes 3 * bet
// if he loses, he loses the bet amount
// has $100 initially

// memory leak is the improper use of dynamic memory (the memory) for our program 
// memory leaks are the unreferenced memory blocks in the heap

#include <stdio.h>
#include <stdlib.h>
#include<time.h>


int cash = 100;
void play(int bet);

int main()
{
    printf("\n");

    int bet;
    printf("**Welcome to the casino!**\n");
    printf("You have $%d cash.\n", cash);
    while (cash > 0)
    {
        printf("What's your bet? $");
        scanf("%d", &bet);
        if (bet == 0 || bet > cash) break;
        play(bet);
        
    }

    printf("\n");
    return 0;
}

// the below version of play() is using the stack memory
// memory is being allocated and freed each time play() is called
// so the memory of the program doesn't really increase after initialization
void play(int bet)
{
    char c[3] = {'J', 'Q', 'K'};
    printf("\nShuffling ...\n");
    srand(time(NULL));
    int i;
    for (i = 0; i < 5; i++)
    {
        int x = rand() % 3;
        // printf("x = %d\n", x);
        int y = rand() % 3;
        // printf("y = %d\n", y);
        int temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
    int playersGuess;
    printf("What's the position of queen - 1, 2, or 3? ");
    scanf("%d", &playersGuess);
    printf("You picked the %c.\n", c[playersGuess - 1]);
    if(c[playersGuess - 1] == 'Q'){
        cash += 3 * bet;
        printf("You Win! Result = %c, %c, %c\nTotal Cash = %d\n", c[0], c[1], c[2], cash);
    } else {
        cash -= bet;
        printf("You Lose. Result = %c, %c, %c\nTotal Cash = %d\n", c[0], c[1], c[2], cash);
    }
}

// this will be a similar implementation except
// play will use malloc()
// meaning that each call of playMalloc means a new memory allocation for c
// the amount of memory used by the application will increase
// because c is now stored on the heap
// however this could be fixed with the use of free(c);
void playMalloc(int bet)
{
    char *c = (char*)malloc(3 * sizeof(char));
    c[0] = 'J'; 
    c[1] = 'Q'; 
    c[2] = 'K';
    printf("\nShuffling ...\n");
    srand(time(NULL));
    int i;
    for (i = 0; i < 5; i++)
    {
        int x = rand() % 3;
        // printf("x = %d\n", x);
        int y = rand() % 3;
        // printf("y = %d\n", y);
        int temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
    int playersGuess;
    printf("What's the position of queen - 1, 2, or 3? ");
    scanf("%d", &playersGuess);
    printf("You picked the %c.\n", c[playersGuess - 1]);
    if(c[playersGuess - 1] == 'Q'){
        cash += 3 * bet;
        printf("You Win! Result = %c, %c, %c\nTotal Cash = %d\n", c[0], c[1], c[2], cash);
    } else {
        cash -= bet;
        printf("You Lose. Result = %c, %c, %c\nTotal Cash = %d\n", c[0], c[1], c[2], cash);
    }
}