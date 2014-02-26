package com.pruys.cor;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by cor on 25-02-14.
 */
public class Game {

    public String gameStatus = "STARTSCREEN";
    private String lastUserInput;

    Scanner scanIn = new Scanner(System.in);


    public Game () {
        clearScreen();
        runGame();
    }


    private void runGame() {


        while(!"SHUTDOWN".equals(gameStatus)){


            if("TUTORIAL".equals(gameStatus)) {
                //TODO create tutorial
                scanInput();
                print(lastUserInput);

                if (lastUserInput.equals("SHUTDOWN")) gameStatus = "SHUTDOWN";
            }

            else if("STARTSCREEN".equals(gameStatus)) {
                printIntro();
                scanInput();
                clearScreen();

                gameStatus = "TUTORIAL";
            }

            else gameStatus = "SHUTDOWN";
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

        print(" _______ _         ╭╯╭╯╭╯    _______");
        print("|__   __(_)       ╱▔▔▔▔▔╲▔╲ |__   __|");
        print("   | |   _  ___  ╱ ╭╮ ╭╮ ╲╮╲   | | ___   ___");
        print("   | |  | |/ __| ▏ ▂▂▂▂▂ ▕╮▕   | |/ _ \\ / _ \\");
        print("   | |  | | (__  ▏ ╲▂▂▂╱ ▕╮▕   | | (_) |  __/");
        print("   |_|  |_|\\___| ╲▂▂▂▂▂▂▂▂╲╱   |_|\\___/ \\ ___|");
        print("");
        print("TicTacoToe");
        print("---------------------");
        print("Created by Cor Pruijs");
        print("");
        print("Press enter to begin");
    }

    private void print(String x) {
        System.out.println(x);
    }

    private void scanInput() {

        String userInput;

        try {
        userInput = scanIn.nextLine();
        lastUserInput = "" + userInput;

        }catch ( java.util.NoSuchElementException x) {
            lastUserInput = "";

        }


    }
}