import java.util.Scanner;

public class Input {

    // this is all taken from the library simulation code :)

    private static Scanner scn = new Scanner(System.in);

    public static void waitForUserToPressEnter(String prompt)
    {
        System.out.print(prompt);
        scn.nextLine();
    }

    public static String getUserString(String prompt)
    {
        System.out.print(prompt);
        return scn.nextLine();
    }


    public static int getUserInt(String prompt)
    {
        String userStr;
        int userInt = 0; // meaningless initialization

        boolean validInt = false;
        while (!validInt)
        {
            userStr = getUserString(prompt);

            try
            {
                userInt = Integer.parseInt(userStr);
                validInt = true; // we only set 'validInt = true' if userStr was successfully parsed as an int
            }
            catch (NumberFormatException e)
            {
                System.out.println("'" + userStr + "' is not a valid integer. Try again.");
            }
        }

        return userInt;
    }


}
