import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput(final String prompt) {
        String inStr = "";
        System.out.print(prompt);
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    public static int convertInputToNumber(String prompt, String warning, int min, int max) { // throws exception?

        while (true) {
            String n = getInput(prompt);

            try {
                int num = Integer.parseInt(n);

                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println(warning);
                    continue;

                }

            } catch (NumberFormatException ex) {
                System.out.println(warning);

                continue;
            }

        }
    }

}
