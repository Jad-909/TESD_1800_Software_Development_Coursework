import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise17_01 {
    public static void main(String[] args) {
        File file = new File("Exercise17_01.txt");

        try {
            // Append = true
            PrintWriter output = new PrintWriter(new FileWriter(file, true));

            for (int i = 0; i < 100; i++) {
                int num = (int)(Math.random() * 100);
                output.print(num + " ");
            }

            output.close();
            System.out.println("100 integers written to Exercise17_01.txt");
        }
        catch (IOException ex) {
            System.out.println("Error writing to file.");
        }
    }
}
