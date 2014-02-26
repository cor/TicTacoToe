package com.pruys.cor;

/**
 * Created by cor on 25-02-14.
 */
public class Game {

    private String gameStatus;




    public Game () {
        clearScreen();
        printIntro();
        runGame();

        gameStatus = "TUTORIAL";

    }


    private void runGame() {
        //TODO create main game loop
        while(!"SHUTDOWN".equals(gameStatus)){


            if("TUTORIAL".equals(gameStatus)) {
                System.out.println("wow, much tutorial");
                //TODO create tutorial
                gameStatus = "SHUTDOWN";
            }




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

    }

    private void print(String x) {
        System.out.println(x);
    }
}