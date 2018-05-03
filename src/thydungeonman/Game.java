/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thydungeonman;

import java.util.Scanner;

/**
 *
 * @author Britt2ney
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dungeonman dude = new Dungeonman();
        
        while(dude.keepPlaying() == 'Y'){
            playGame(dude);
        }
    }
    
    public static void playGame(Dungeonman dude){
        Scanner keyboard = new Scanner(System.in);
        String input;
        dude.setAlive(true);
        dude.openingScreen();
        dude.goMain();
        dude.prompt();
        
        do{
            input = keyboard.nextLine();
            dude.clearScreen();
            switch(input){
                case "main":
                    dude.atMain(input);
                    break;
                case "north":
                    dude.atNorth(input);
                    break;
                case "south":
                    dude.goSouth();
                    dude.atSouth(input);
                    break;
                case "dennis":
                    dude.atDennis(input);
                    break;
                default:
                    System.out.print(dude.badInput());
            }
       
        }while(dude.isAlive());
        
        if(dude.hasLost()){
            dude.wantToKeepPlaying(keyboard.next().charAt(0));
        }
    }
}
