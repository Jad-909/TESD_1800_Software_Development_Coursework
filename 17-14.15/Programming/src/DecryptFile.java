import java.io.*;
import java.util.Scanner;

public class DecryptFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter encrypted input file name: ");
        String inFile = input.nextLine();

        System.out.print("Enter output file name for decrypted file: ");
        String outFile = input.nextLine();

        try (
                FileInputStream fin = new FileInputStream(inFile);
                FileOutputStream fout = new FileOutputStream(outFile);
        ) {
            int value;
            while ((value = fin.read()) != -1) {
                fout.write(value - 5);
            }
            System.out.println("Decryption complete.");
        }
        catch (IOException ex) {
            System.out.println("Error processing file.");
        }
    }
}
