import java.io.*;

public class Exercise17_03 {

    public static void main(String[] args) {
        try {
            writeIntsToFile();
            int sum = sumIntsInFile();
            System.out.println("Sum of integers in file: " + sum);
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public static void writeIntsToFile() throws IOException {
        File file = new File("Exercise17_03.dat");

        DataOutputStream output = 
                new DataOutputStream(new FileOutputStream(file, true));

        for (int i = 0; i < 100; i++) {
            int num = (int)(Math.random() * 100);
            output.writeInt(num);
        }

        output.close();
    }

    public static int sumIntsInFile() throws IOException {
        File file = new File("Exercise17_03.dat");

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return 0;
        }

        int sum = 0;

        DataInputStream input =
                new DataInputStream(new FileInputStream(file));

        try {
            while (true) {
                sum += input.readInt();
            }
        }
        catch (EOFException ex) {
        }

        input.close();
        return sum;
    }
}
