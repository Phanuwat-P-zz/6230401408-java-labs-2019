/**
* Write a program called NumberGuessingConfigurableGame which is 
*an improved version of the previous program NumberGuessingMethodGame.  
*The main of the program should be as shown.
*In method configure(), 
*   The program lets you choose the minimum value of the guessing number, 
*   the maximum value of the guessing number, and the number of maximum number of tries.  
*In method playGames(),
*   Method playGame() that was implemented in problem 2 is called
*   The minimum and maximum values need to be updated at the prompt accepting 
*In method genAnswer() 
*   This is a static void subroutine that will generate the answer and then 
*   store the value in the variable answer.
*
* Author: Phanuwat Phoowichai
* ID: 623040140-8
* Sec: 2
* Date: January 2, 2020
*
**/

package phoowichai.phanuwat.lab3;

import java.util.*;

public class NumberGuessingConfigurableGame {
    static int realanswer, min, max, numTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    public static void configure() { // method configure (input min,max,numTries)
        System.out.print("Enter the min value:");
        min = input.nextInt(); // input min
        System.out.print("Enter the max value:");
        max = input.nextInt(); // input max
        System.out.print("Enter the maximum number of tries:");
        numTries = input.nextInt(); // input round tries
    }

    public static void genAnswer() { // method genAnswer (random answer)
        Random random = new Random();
        realanswer = random.nextInt((max - min) + 1) + min;
    }

    public static void playGame() { // method playGame (play game)
        System.out.println("Welcome to a number guessing game!");
        int answer;
        int tried = 0;
        String playagain;
        do {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            answer = input.nextInt();
            if (answer < min) { // check min answer (between min-max)
                System.out.println("The number must be between " + min + " and " + max);
            } else if (answer > max) { // check max answer (between min-max)
                System.out.println("The number must be between " + min + " and " + max);
            } else {
                tried++;
                if (answer < realanswer) { // output answer lower
                    System.out.println("Try a lower number!");
                } else if (answer > realanswer) { // output answer higher
                    System.out.println("Try a higher!");
                }
                if (answer == realanswer) { // check correct answer
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + tried + " times");
                    break;
                } else if (tried == numTries) { // check tried
                    System.out.println("You have tried " + tried + " times. You ran out of guesses!");
                    System.out.println("The answer is " + realanswer);
                    break;
                }
            }
        } while (answer != realanswer);
        System.out.print("Want to play again (Y or y):"); // play again
        playagain = input.next();
        if (playagain.equals("Y") || playagain.equals("y")) {
            playGame();
        } else {
            System.out.print("Thank you for playing our games. Bye!");
        }
    }
}