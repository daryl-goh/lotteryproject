package personal.lottery;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {

    //Create a list
    List<Integer> winningNumbers = new LinkedList<>();

    
    //User Random class to instantiate a randomizer 
    Random randomizer = new Random();
    
    //For Loops to generate 6 numbers
    for (int i = 0; i < 6; i++)
        while (true){
            //Randomizes number in nextInt between 0 and one less than the number in the bracket. e.g. 49 will randomize between 0 to 48
            //We want random number between 1 to 49, hence this will randomize between (0 to 48) PLUS 1
            int winningNumber = randomizer.nextInt(49) + 1;

            //If List of winningNumbers does not contain the randomize winningNumber, add winningNumber
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber);

                //To break out of the loop after getting 6 numbers
                break;

            }
        }

        //****COMMENT OUT BELOW SO THAT WINNING NUMBER DOES NOT PRINT!****
        System.out.println(winningNumbers);


        //Prompt user to input numbers
        System.out.println("Please enter your 6 numbers between and inclusive of 1 and 49: ");
        Scanner scanner = new Scanner(System.in);
        //Create List to hold user's input
        List<Integer> guessedNumber = new LinkedList<>();

        //To collect 6 numbers from the user, use the For Loop
        for (int i = 0; i < 6; i++) {
            //Everytime user inputs number, the below prints to show the list of numbers that they have input
            System.out.println("Your current numbers are " + guessedNumber);
            System.out.println("Please enter a number (1-49):");
            //To allow user to retry if they don't enter number between 1 to 49, we use the While True Loop
            //Use Try Catch so that when user enters string or any data type other than integer, program will not show error
            while (true) {
                try{
                    String numberString = scanner.nextLine();
                    //Convert string to integer
                    int number = Integer.parseInt(numberString);
                    if (number >= 1 && number <= 49) {
                        guessedNumber.add(number);
                        break;
                    }
                
                    else {
                        System.out.println("Please input a number between and inclusive of 1 and 49.");
                    }


                }
                catch (NumberFormatException nfe) {
                    //Print the below when user enters anything other than integer
                    System.out.println("That is not a number");
                }
            }           
        }
        //Summary
        System.out.println("The winning numbers were: " + winningNumbers);
        System.out.println("Your numbers are: " + guessedNumber);

        //In guessedNumber list; remove all numbers that are not winningNumbers and leave the winningNumbers
        guessedNumber.retainAll(winningNumbers);
        System.out.println("Your matched numbers are: " + guessedNumber);

        //Compare winning numbers to user inputs

        if (guessedNumber.containsAll(winningNumbers)) {
            System.out.println("Congratulations, you won the lottery!");
        }

        else { 
            System.out.println("Sorry, you did not win the lottery. Try again next time!");
        }

        scanner.close();
    }

    
}


//Odds of Winning the Lottery:
// 1 in 49 * 48 * 47 * 46 * 45 * 44 = 10,068,347,520   (This is odds of winning lottery if numbers are in order. But we don't need the numberes to be in order)
// 6! = 6 * 5 * 4 * 3 * 2 * 1 = 720
// Hence 10,068,347,520 / 720 = 13,983,816 and this is the odds of winning lottery without caring about the ordering of numbers.