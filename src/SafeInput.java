import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String input;

        do
        {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
        }
        while(input.length() == 0);

        return input;
    }

    public static int getRangedInt(Scanner pipe,
                                   String prompt,
                                   int low,
                                   int high)
    {
        int value;

        while(true)
        {
            System.out.print(prompt + ": ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();

                if(value >= low && value <= high)
                {
                    return value;
                }
            }
            else
            {
                pipe.nextLine();
            }

            System.out.println("Invalid input.");
        }
    }

    public static boolean getYNConfirm(Scanner pipe,
                                       String prompt)
    {
        String response;

        while(true)
        {
            System.out.print(prompt + " [Y/N]: ");

            response =
                    pipe.nextLine().toUpperCase();

            if(response.equals("Y"))
                return true;

            if(response.equals("N"))
                return false;
        }
    }
}