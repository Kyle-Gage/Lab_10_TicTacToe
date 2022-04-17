import java.util.Scanner;


/**
 * @author Kyle Gage Gageka@mail.uc.edu
 */
public class SafeInput {

    /**
     * @param pipe   - A scanner opened to read from system.in
     * @param prompt - Prompt for the user
     * @return - Return a string response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }


    /**
     * @param pipe   - A scanner opened to read from system.in
     * @param prompt - Prompt for the user
     * @return - Return the integer a user inputs
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        boolean correctInput = false;
        String trash = "";

        do {
            System.out.print("\n" + prompt);

            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                correctInput = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid number and not " + trash);
            }

        } while (!correctInput);

        return retInt;
    }

    /**
     * @param pipe   - A scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @return - Return the double a user inputs
     */

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean correctInput = false;
        String trash = "";

        do {
            System.out.print("\n" + prompt);

            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                correctInput = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid number and not " + trash);
            }

        } while (!correctInput);

        return retDouble;
    }

    /**
     * @param pipe   - A scanner opened to read from System.in
     * @param prompt - A prompt for the user
     * @param low    - The low int of the range
     * @param high   - The high int of the range
     * @return - Return the user entered integer within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retRangeInt = 0;
        boolean intInRange = false;
        String trash = "";


        do {
            System.out.print("\n" + prompt);

            if (pipe.hasNextInt()) {
                retRangeInt = pipe.nextInt();
                pipe.nextLine();
                if (retRangeInt >= low && retRangeInt <= high) {
                    intInRange = true;
                } else {
                    System.out.println("You entered " + retRangeInt);
                    System.out.println("Please enter a valid integer within [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid integer not " + trash);
            }
        } while (!intInRange);

        return retRangeInt;
    }

    /**
     * @param pipe   - A scanner opened to read from System.in
     * @param prompt - A prompt for the user
     * @param low    - The low double of the range
     * @param high   - The high double of the range
     * @return - Return the user entered double within the range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retRangeDouble = 0;
        boolean doubleInRange = false;
        String trash = "";

        do {
            System.out.print("\n" + prompt);

            if (pipe.hasNextDouble()) {
                retRangeDouble = pipe.nextDouble();
                pipe.nextLine();

                if (retRangeDouble >= low && retRangeDouble <= high) {
                    doubleInRange = true;
                } else {
                    System.out.println("You Entered " + retRangeDouble);
                    System.out.println(" Please enter a valid double within [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid double and not " + trash);
            }
        } while (!doubleInRange);

        return retRangeDouble;
    }

    /**
     * @param pipe   - A scanner opened to read from System.in
     * @param prompt - A prompt for the user
     * @return - Return true for yes and false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String userRespnonse;
        boolean retYNConfirm = false;
        boolean correctIput = false;

        do {
            System.out.print("\n" + prompt);
            userRespnonse = pipe.nextLine();

            if (userRespnonse.equalsIgnoreCase("Y")) {
                System.out.println("True!");
                correctIput = true;
                retYNConfirm = true;
            } else if (userRespnonse.equalsIgnoreCase("N")) {
                System.out.println("False!");
                correctIput = true;
                retYNConfirm = false;

            } else {
                System.out.println("Please enter a valid input [Y/N]: ");
                correctIput = false;
            }


        } while (!correctIput);

        return retYNConfirm;
    }

    /**
     * @param pipe   - A scanner opened to read from System.in
     * @param prompt - A prompt for the user
     * @param regEx  - A pattern in java String format to use for matching
     * @return - Return a user entered string that matches the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean done = false;
        String trash = "";
        String retVal = "";

        do {
            System.out.print("\n" + prompt + " " + regEx + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Enter a matching pattern not: " + retVal);
            }
        } while (!done);

        return retVal;
    }

    public static void prettyHeader(String msg) {
        int whiteSpace = (53 - msg.length()) / 2;

        for (int x = 0; x <= 59; x++) {
            System.out.print("*");
        }
        System.out.print("\n***");

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int x = 0; x <= 59; x++) {
            System.out.print("*");
        }
    }

    public static double getAverage(int values[])
    {
        int sum = 0;
        double average = 0;


        for (int i : values)
        {
            sum += i;
        }
        average = (double) sum / values.length;
        return average;
    }
}
