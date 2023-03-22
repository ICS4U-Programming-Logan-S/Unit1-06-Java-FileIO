import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* This program reads a text file and outputs
* to it.
*
* @author  Logan S
* @version 1.0
* @since   2023-03-08
*/

public final class FileIo {
    /**
    * This is for the linter.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private FileIo() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Parameters.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {
        try {
            // A file to get input.
            final File input = new File("Unit1-06-input.txt");

            
            final Scanner scanner = new Scanner(input);
            // A file to get output.
            final FileWriter output = new FileWriter("Unit1-06-output.txt");
            while (scanner.hasNextLine()) {
                // Error checking variable.
                boolean error = false;

                // Loop variables.
                int sum = 0;
                int counter = 0;

                // Split new line.
                final String[] fromFile = scanner.nextLine().split(" ");
                while (counter < fromFile.length) {
                    try {
                        // Convert strings to ints and add them up.
                        sum += Integer.parseInt(fromFile[counter]);
                    } catch (NumberFormatException err) {
                        // Check for empty line.
                        if (fromFile[counter].isEmpty()) {
                            output.write("Invalid: found an empty line.\n");
                        } else {
                            // When a non-integer is on the line.
                            output.write("Invalid: \"" + fromFile[counter]
                                        + "\" is not a valid integer.\n");
                        }
                        // Error indication variable.
                        error = true;
                        // Stop adding to line if
                        // an error has occurred.
                        break;
                    }
                    // Add to counter by one.
                    counter++;
                }
                // If an error has not occurred.
                if (!error) {
                    // Sum of all ints on the line output to the file.
                    output.write(sum + "\n");
                }
            }
            // Close writer
            output.close();
            scanner.close();

        } catch (IOException err) {
            // When no input is found.
            System.err.println("Error: " + err.getMessage());
        }
    }
}
