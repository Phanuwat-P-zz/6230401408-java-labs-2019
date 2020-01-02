/**
* Write a Java program called NumberGuessingGame that simulates a 
* guessing game of which a user guesses number from 1 to 10. 
* The answer is randomly generated then a user enter a number via the console. 
* Each time a number is entered, one of the following three possible outputs will be displayed. 
* 1. "Congratulations!": if a number entered is the same as the answer, 
* 2. "Try a lower number!": if the number entered is higher than the answer, 
* and 3. "Try a higher number!": if the number entered is smaller than the answer.  
* The game ends when user guess the answer correctly or the user guess the number incorrectly five times.
*
* Author: Phanuwat Phoowichai
* ID: 623040140-8
* Sec: 2
* Date: January 2, 2020
*
**/

package phoowichai.phanuwat.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    static Scanner number = new Scanner(System.in);

    public static void main(String[] args) {
        // int min = 1
        // int max = 10
        int round = 0;
        int falsex = 1;
        int random_nmber = (int) (Math.random() * ((10 - 1) + 1)) + 1;
        System.out.println("Welcome to a number guessing game!");
        while (round != 5) {
            System.out.print("Enter an integer between 1 and 10:");
            int number_input = number.nextInt();
            if (number_input == random_nmber) {
                round++; // เพิ่มจำนวนรอบ
                System.out.println("Congratulations!");
                System.out.println("You have tried " + String.valueOf(round) + " times");
                falsex = 0;
                break;
            } else if (number_input < random_nmber) {
                round++; 
                System.out.println("Try a higher number!");
            } else if (number_input > random_nmber) {
                round++;
                System.out.println("Try a Lower number!");
            }
            if (round == 5 && falsex == 1) {
                System.out.println("You have tried " + String.valueOf(round) + " times. You ran out of guesses");
                System.out.println("The answer is " + String.valueOf(random_nmber));
            }
        }
    }
}