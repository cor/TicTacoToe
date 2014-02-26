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
                gameStatus = "SHUTDOWN";
            }


            else gameStatus = "SHUTDOWN";
        }
    }

    private void renderScreen(){


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

    private void clearLevel(){

        for(int i = 0; i < 9; i++) {
            level[i] = 0;
        }

    }

    private void clearScreen(){

        for(int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

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
}