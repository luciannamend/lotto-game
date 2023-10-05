package exercise2;

import javax.swing.*;
import java.util.Random;

public class Lotto {

    //one array instance variable to hold three random integer values (from 1 to 9)
    private final Integer[] randomNumbers = new Integer[3];

    //constructor that randomly populates the array for a lotto object
    public Lotto() {
        int lowerBound = 1;
        int upperBound = 9;
        int count = 0;

        Random randomNum = new Random();
        //TODO: ajustar random below.
        while (count < 3) {
            randomNumbers[count] = 1 + randomNum.nextInt(upperBound);
            count++;
        }
    }

    //a method to return the array
    public Integer[] getRandomNumbers() {
        return randomNumbers;
    }

    //The user runs the lotto up to 5 times and each time the sum of lotto numbers is calculated.
    public void runLotto() {
        int userNumber = getUserNumber();
        if (userNumber == -1) {
            return;
        }
        int run = 0;
        int sum = 0;

        while (run < 5) {
            JOptionPane.showMessageDialog(null, "Running for the " + (run + 1) + " time");

            //create a random index
            Random randomNum = new Random();
            int randomIndex = randomNum.nextInt(3);

            //choose number inside the random array based on the random index
            int lottoNumber = randomNumbers[randomIndex];
            JOptionPane.showMessageDialog(null, "Number is: " + lottoNumber);

            //adds the number to the sum
            sum += lottoNumber;
            JOptionPane.showMessageDialog(null, "Sum is: " + sum);

            //If the number chosen by the user matches the sum, the user wins and the game ends.
            if (userNumber == sum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won!");
                return;
            }
            run++;
        }
        //If the number does not match the sum within five rolls, the computer wins.
        JOptionPane.showMessageDialog(null, "Sorry, you did not win this time. Try again!");
    }

    //Use methods of JOptionPane class to interact with the user.
    private int getUserNumber() {
        int userNumber = -1;
        //user chooses a number between 3 and 27
        String userInput = JOptionPane.showInputDialog(null, "Welcome to Lotto Game! Enter a number between 3 and 27: ", "Lotto", JOptionPane.QUESTION_MESSAGE);
        if (userInput == null) {
            return userNumber;
        }

        try {
            //Parse String to Integer:
            userNumber = Integer.parseInt(userInput);
            if (userNumber < 3 || userNumber > 27) {
                JOptionPane.showMessageDialog(null, "Number out of range. Please, try again.");
                getUserNumber();
            }

        } catch (NumberFormatException e) {
            // if not a valid Integer, then:
            JOptionPane.showMessageDialog(null, "Invalid input. Please, try again.");
            getUserNumber();
        }
        return userNumber;
    }
}
