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
        ┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈
        ┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈
        ┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈
        ┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈
        ┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈
        ┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈
         */


        print("TicTacoToe");
        print("---------------------");
        print("Created by Cor Pruijs");

    }

    private void print(String x) {
        System.out.println(x);
    }
}