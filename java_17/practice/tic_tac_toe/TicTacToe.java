package java_17.practice.tic_tac_toe;

import java.util.HashMap;
import java.util.Scanner;

public class TicTacToe {
    private String[][] board;
    private int playerTurn;
    private String move;
    private HashMap<String, Integer> moveMap;
    private boolean isGameWon;
    private int turnCount;

    public TicTacToe() {
        this.board = new String[6][6];
        this.playerTurn = 1;
        this.move = "";
        this.moveMap = new HashMap<>();
        this.isGameWon = false;
        this.turnCount = 0;

        this.setInitialBoard();
        this.setMoveMap();

    }

    private void setInitialBoard() {
        String[][] initialBoard = {
                { " ", "A", " ", "B", " ", "C" },
                { "1", " ", "|", " ", "|", " " },
                { " ", "-", "+", "-", "+", "-" },
                { "2", " ", "|", " ", "|", " " },
                { " ", "-", "+", "-", "+", "-" },
                { "3", " ", "|", " ", "|", " " },
        };
        this.board = initialBoard;

    }

    public String[][] getBoard() {
        return this.board;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public String getMove() {
        return this.move;
    }

    public HashMap<String, Integer> getMoveMap() {
        return this.moveMap;
    }

    public boolean getIsGameWon() {
        return this.isGameWon;
    }

    public int getTurnCount() {
        return this.turnCount;
    }

    public void setBoard(Scanner s) {

        int x = -1;
        int y = -1;

        while (true) {
            try {
                x = this.getMoveMap().get(this.getMove().substring(0, 1).toUpperCase());
                y = this.getMoveMap().get(this.getMove().substring(2, 3));
            } catch (Exception e) {
                if (this.getMove().toLowerCase().equals("q")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                System.out.println("Invalid Input, Try again");
                this.setMove(this.getPlayerInput(s));
                continue;
            }
            if (!this.board[y][x].equals(" ")) {
                System.out.println("Invalid Placement, try again");
                this.setMove(this.getPlayerInput(s));
                continue;
            }
            break;
        }
        this.board[y][x] = this.playerTurn == 1 ? "X" : "O";
    }

    public void setPlayerTurn() {
        this.playerTurn = this.getPlayerTurn() == 1 ? 2 : 1;
    }

    public void setMove(String move) {
        this.move = move.replaceAll("\\s+", "");
    }

    private void setMoveMap() {
        this.moveMap.put("A", 1);
        this.moveMap.put("B", 3);
        this.moveMap.put("C", 5);
        this.moveMap.put("1", 1);
        this.moveMap.put("2", 3);
        this.moveMap.put("3", 5);
    }

    public void setIsGameWon() {
        this.isGameWon = this.getIsGameWon() ? false : true;
    }

    public void setTurnCount(int newTurnCount) {
        this.turnCount = this.getTurnCount() + newTurnCount;
    }

    public void incrementTurnCount() {
        this.setTurnCount(1);
    }

    public static void playGame() {
        TicTacToe game = new TicTacToe();

        Scanner s = new Scanner(System.in);

        game.printInstructions();

        while (true) {
            game.printBoard();
            game.printPlayerTurn();
            game.incrementTurnCount();
            game.setMove(game.getPlayerInput(s));
            if (game.getMove().toLowerCase().equals("q")) {
                System.out.println("Thanks for playing!");
                break;
            }
            game.setBoard(s);
            boolean isWon = game.didWin();
            if (isWon) {
                game.endGame();
                break;
            } else if (!isWon && game.getTurnCount() == 9) {
                game.endGameDraw();
                break;
            }
            game.setPlayerTurn();
        }

        s.close();

    }

    public void printInstructions() {
        System.out.println(
                "\n\nLet's Play Tic-Tac-Toe!\nPlayer One will be X's. Player Two will be O's.\nInput your move in the following format \"x,y\". Type \"q\"/\"Q\" to quit.");
    }

    public void printPlayerTurn() {
        String player = this.getPlayerTurn() == 1 ? "One" : "Two";
        System.out.printf("It is Player %s's turn!\n", player);
    }

    public void printBoard() {
        System.out.println();

        for (String[] row : this.getBoard()) {
            String joinedArr = String.join(" ", row);
            System.out.println(joinedArr);
        }
    }

    public String getPlayerInput(Scanner s) {
        System.out.print("Input Move: ");
        String input = s.nextLine();
        return input;
    }

    public boolean didWin() {
        int row = 0;
        int column = 0;
        int leftToRight = 0;
        int leftToRightCounter = 1;
        int rightToLeft = 0;
        int rightToLeftCounter = 5;

        for (int i = 1; i < this.getBoard().length; i = i + 2) {
            for (int j = 1; j < this.getBoard()[1].length; j = j + 2) {
                if (this.getBoardElement(j, i).equals("X")) {
                    row++;
                    if (i == j) {
                        leftToRight++;
                        leftToRightCounter = leftToRightCounter + 2;
                    }
                    if (rightToLeftCounter == j) {
                        rightToLeft++;
                        rightToLeftCounter = rightToLeftCounter - 2;
                    }
                } else if (this.getBoardElement(j, i).equals("O")) {
                    row--;
                    if (leftToRightCounter == j && leftToRightCounter == i) {
                        leftToRight--;
                        leftToRightCounter = leftToRightCounter + 2;
                    }
                    if (rightToLeftCounter == j) {
                        rightToLeft--;
                        rightToLeftCounter = rightToLeftCounter - 2;
                    }
                }
                if (this.getBoardElement(i, j).equals("X")) {
                    column++;
                } else if (this.getBoardElement(i, j).equals("O")) {
                    column--;
                }
            }
            // System.out.printf("")
            if (Math.abs(row) == 3 || Math.abs(column) == 3 || Math.abs(leftToRight) == 3
                    || Math.abs(rightToLeft) == 3) {
                this.setIsGameWon();
                break;
            }
            row = 0;
            column = 0;
        }
        return this.getIsGameWon();
    }

    private String getBoardElement(int x, int y) {
        return this.getBoard()[y][x];
    }

    private void setBoardElement(int x, int y, String value) {
        this.board[y][x] = value;
    }

    public void endGame() {
        this.printBoard();
        String player = this.getPlayerTurn() == 1 ? "One" : "Two";
        System.out.printf("\nCONGRATULATIONS to \"Player %s\"\n", player);
    }

    public void endGameDraw() {
        this.printBoard();
        System.out.println("\nThe game is a DRAW!\n");
    }

    public static void main(String[] args) {

        TicTacToe.playGame();
    }
}