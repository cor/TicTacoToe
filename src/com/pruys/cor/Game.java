package com.pruys.cor;

import java.util.Scanner;

/**
 * TicTacoToe game object
 *
 * Created by cor on 25-02-14.
 */
public class Game {

    public String gameStatus = "STARTSCREEN";
    private String lastUserInput;
    private int[] level = new int[9];

    Scanner scanIn = new Scanner(System.in);


    public Game () {
        clearScreen();
        clearLevel();
        runGame();
    }


    private void runGame() {


        while(!"SHUTDOWN".equals(gameStatus)){

            if("STARTSCREEN".equals(gameStatus)) {
                printIntro();
                scanInput();
                clearScreen();

                gameStatus = "TUTORIAL";
            }


            else if("TUTORIAL".equals(gameStatus)) {

                printLevel();
                println("");
                println("TicTicoToe is played by two players on the same PC, one X and the other O");
                println("To win the game, you'll need to be the first to get a line of three characters (X or O) in a row");
                println("the line can be diagonal, vertical or horizontal, as long as it is three in a row.");
                println("");
                println("To choose a spot, you'll need to type the representative number and hit return");
                println("Example: If one wants to choose the spot in the middle, he shall enter 5");
                println("");
                println("Good Luck!             (Press enter to continue)" );
                scanInput();
                clearScreen();

                gameStatus = "TURN_X";
            }

            else if("TURN_X".equals(gameStatus)) {
                printLevel();
                println("What field do you choose, X?");
                scanInput();
                if( lastUserInputIsAField() && fieldIsEmpty(lastUserInputToInt() - 1)) {
                    setField(1, lastUserInputToInt());
                    clearScreen();
                    println("Field " + lastUserInputToInt() + " changed to X");
                    gameStatus = "TURN_O";

                    if (gameWon(1)) gameStatus = "VICTORY_X";
                    else gameStatus = "TURN_O";
                }
                else {
                    clearScreen();
                    println("RTFM");
                }

            }

            else if("TURN_O".equals(gameStatus)) {
                printLevel();
                println("What field do you choose, O?");
                scanInput();
                if( lastUserInputIsAField() && fieldIsEmpty(lastUserInputToInt() - 1)) {
                    setField(2, lastUserInputToInt());
                    clearScreen();
                    println("Field " + lastUserInputToInt() + " changed to O");

                    if (gameWon(2)) gameStatus = "VICTORY_O";
                    else gameStatus = "TURN_X";
                }
                else {
                    clearScreen();
                    println("RTFM");
                }
            }

            else if ("VICTORY_X".equals(gameStatus)) {
                clearScreen();
                printLevel();
                println("X HAS WON!");
                println("Press enter to play again");
                scanInput();

            }

            else if ("VICTORY_O".equals(gameStatus)) {
                clearScreen();
                printLevel();
                println("O HAS WON!");
                println("Press enter to play again");
                scanInput();
            }

            else gameStatus = "SHUTDOWN";
        }
    }

    private void printLevel(){

        System.out.println("-------------"); //Top

        //first
        System.out.print("| ");
        System.out.print(getCharacter(0));
        System.out.print(" | ");
        System.out.print(getCharacter(1));
        System.out.print(" | ");
        System.out.print(getCharacter(2));
        System.out.println(" |");

        System.out.println("-------------"); //Mid 1

        //second
        System.out.print("| ");
        System.out.print(getCharacter(3));
        System.out.print(" | ");
        System.out.print(getCharacter(4));
        System.out.print(" | ");
        System.out.print(getCharacter(5));
        System.out.println(" |");

        System.out.println("-------------"); //Mid 2

        //third
        System.out.print("| ");
        System.out.print(getCharacter(6));
        System.out.print(" | ");
        System.out.print(getCharacter(7));
        System.out.print(" | ");
        System.out.print(getCharacter(8));
        System.out.println(" |");


        System.out.println("-------------"); //Bot

    }

    /**
     *
     * used by the printlevel class
     *
     * @param i the field you want to acces ( 0 - 8 )
     * @return the character that needs to be placed here
     */
    private String getCharacter(int i){

        if( level[i] == 0) return("" + (i + 1));
        else if( level[i] == 1) return("X");
        else if( level[i] == 2) return("O");
        else return("E");

    }

    /**
     * Set a field in the level
     *
     * @param value 0 (empty), 1 (x) or 2 (o)
     * @param position the field of the level you want to set.
     */
    private void setField(int value, int position) {
        position--;
        level[position] = value;
    }

    private void clearLevel(){

        for(int i = 0; i < 9; i++) {
            level[i] = 0;
        }

    }

    /**
     * Prints a lot of empty lines to create the illusion of an "empty" console
     */
    private void clearScreen(){

        for(int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    /**
     * Checks if a player has won
     *
     * @param playerToCheck the player to check for victory
     * @return if the playerToCheck has won, true. else false
     */
    private boolean gameWon(int playerToCheck) {
        //horizontal
        if (level[0] == playerToCheck && level[1] == playerToCheck && level[2] == playerToCheck) return true;
        if (level[3] == playerToCheck && level[4] == playerToCheck && level[5] == playerToCheck) return true;
        if (level[6] == playerToCheck && level[7] == playerToCheck && level[8] == playerToCheck) return true;
        //diagonal
        if (level[0] == playerToCheck && level[4] == playerToCheck && level[8] == playerToCheck) return true;
        if (level[2] == playerToCheck && level[4] == playerToCheck && level[6] == playerToCheck) return true;
        //vertical
        if (level[0] == playerToCheck && level[3] == playerToCheck && level[6] == playerToCheck) return true;
        if (level[1] == playerToCheck && level[4] == playerToCheck && level[7] == playerToCheck) return true;
        if (level[2] == playerToCheck && level[5] == playerToCheck && level[8] == playerToCheck) return true;
        return false;
    }

    /**
     * Prints the start screen
     */
    private void printIntro(){

        /*
         _______ _         ╭╯╭╯╭╯    _______
        |__   __(_)       ╱▔▔▔▔▔╲▔╲ |__   __|
           | |   _  ___  ╱ ╭╮ ╭╮ ╲╮╲   | | ___   ___
           | |  | |/ __| ▏ ▂▂▂▂▂ ▕╮▕   | |/ _ \ / _ \
           | |  | | (__  ▏ ╲▂▂▂╱ ▕╮▕   | | (_) |  __/
           |_|  |_|\___| ╲▂▂▂▂▂▂▂▂╲╱   |_|\___/ \___|
         */

        println(" _______ _         ╭╯╭╯╭╯    _______");
        println("|__   __(_)       ╱▔▔▔▔▔╲▔╲ |__   __|");
        println("   | |   _  ___  ╱ ╭╮ ╭╮ ╲╮╲   | | ___   ___");
        println("   | |  | |/ __| ▏ ▂▂▂▂▂ ▕╮▕   | |/ _ \\ / _ \\");
        println("   | |  | | (__  ▏ ╲▂▂▂╱ ▕╮▕   | | (_) |  __/");
        println("   |_|  |_|\\___| ╲▂▂▂▂▂▂▂▂╲╱   |_|\\___/ \\ ___|");
        println("");
        println("TicTacoToe");
        println("---------------------");
        println("Created by Cor Pruijs");
        println("");
        println("Press enter to begin");
    }

    /**
     * A shorter version of System.out.println() because this program uses a lot of console printing
     * @param x the string to print
     */
    private void println(String x) {
        System.out.println(x);
    }


    private void scanInput() {

        String userInput;

        try {
        userInput = scanIn.nextLine();
        lastUserInput = "" + userInput;

        }
        catch ( java.util.NoSuchElementException x) {
            lastUserInput = "";

        }

    }
    /**
     * Checks if the lastUserInput is a field
     */
    private boolean lastUserInputIsAField() {
        for (int i = 1; i <= 9; i++) {
            if (lastUserInput.equals("" + i)) return true;
        }
        return false;
    }

    /**
     * Checks if a field is empty
     * @param zeroBasedFieldIndexToCheck the field (zerobased) you want to check
     * @return true if it is empty, false if it is occupied
     */
    private boolean fieldIsEmpty(int zeroBasedFieldIndexToCheck) {
        return level[zeroBasedFieldIndexToCheck] == 0;
    }

    /**
     *
     * @return the last user input, converted to an int
     */
    private int lastUserInputToInt () {
        return Integer.parseInt(lastUserInput);
    }

}