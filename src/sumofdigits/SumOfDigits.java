/*
 * Andrew Thompson
 * April 17, 2020
 * Recursively finds the sum of the digits of a positive integer.
 */
package sumofdigits;

/**
 *
 * @author tiein
 */
import javax.swing.JOptionPane;

public class SumOfDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean flag = false;
        int number = 0;
        int finalSum;

        //loop until valid input
        while (!flag) {
            try {
                String response = JOptionPane.showInputDialog("Enter a positive integer to find the sum of.");//get input from user
                if (response != null) {//if null, cancel button is clicked
                    number = Integer.parseInt(response);
                    if (number >= 0) {
                        flag = true;
                    } else {//only positive integers are wanted, so continue loop if number is negative
                        System.err.println("Please enter a positive integer.");
                    }
                } else {
                    System.exit(0);//exit if cancel is clicked
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Please enter an integer.");
            }

        }

        finalSum = findSum(number);//find the sum of the digits

        System.out.println("The sum of the digits of " + number + " is: " + finalSum);//output to user
    }

    /**
     * Recursively fins the sum of the digits of an integer
     * @param num - the number to find the sum of the digits of
     * @return - the sum of the digits
     */
    public static int findSum(int num) {
        if (num == 0) {//if the number is 0, the sum is 0
            return 0;
        }
        int sum = 0;
        sum += num % 10;//add the final digit to the sum
        sum += findSum(num / 10);//add the sum of the number without the final digit recursively
        return sum;
    }

}
