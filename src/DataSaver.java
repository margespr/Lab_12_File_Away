import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> records =
                new ArrayList<>();

        boolean more = true;

        while(more)
        {
            String first =
                    SafeInput.getNonZeroLenString(
                            in,
                            "First Name");

            String last =
                    SafeInput.getNonZeroLenString(
                            in,
                            "Last Name");

            int id =
                    SafeInput.getRangedInt(
                            in,
                            "ID Number",
                            1,
                            999999);

            String idString =
                    String.format("%06d", id);

            String email =
                    SafeInput.getNonZeroLenString(
                            in,
                            "Email");

            int year =
                    SafeInput.getRangedInt(
                            in,
                            "Birth Year",
                            1900,
                            2025);

            records.add(
                    first + "," +
                            last + "," +
                            idString + "," +
                            email + "," +
                            year);

            more =
                    SafeInput.getYNConfirm(
                            in,
                            "Add another record");
        }

        String fileName =
                SafeInput.getNonZeroLenString(
                        in,
                        "File Name");

        try
        {
            FileWriter writer =
                    new FileWriter(
                            "src/" +
                                    fileName +
                                    ".csv");

            for(String record : records)
            {
                writer.write(record + "\n");
            }

            writer.close();

            System.out.println(
                    "File saved!");
        }
        catch(IOException e)
        {
            System.out.println(
                    "Error saving file.");
        }
    }
}