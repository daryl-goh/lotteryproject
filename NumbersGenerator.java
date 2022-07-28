package lotteryproject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NumbersGenerator {

    public static void main(String[] args) {

    //Create a list
    List<Integer> winningNumbers = new LinkedList<>();


    //User Random class to instantiate a randomizer 
    Random randomizer = new Random();
    
    //For Loop to generate 7 numbers (6 + 1 additional number)
    for (int i = 0; i < 7; i++)
        while (true){
            //Randomizes number in nextInt between 0 and one less than the number in the bracket. e.g. 49 will randomize between 0 to 48
            //We want random number between 1 to 49, hence this will randomize between (0 to 48) PLUS 1
            int winningNumber = randomizer.nextInt(49) + 1;

            //If List of winningNumbers does not contain the randomize winningNumber, add winningNumber
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber);

                //To break out of the loop after getting 7 numbers
                break;

            }
        }

        //Print Winning Numbers
        System.out.println("The winning numbers are: " + winningNumbers);
    }
}