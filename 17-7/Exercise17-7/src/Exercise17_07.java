import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) {

        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (
                ObjectOutputStream output =
                        new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }

    public static void outputData() {
        File file = new File("Exercise17_07.dat");

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        double total = 0;

        try (
                ObjectInputStream input =
                        new ObjectInputStream(new FileInputStream(file));
        ) {
            while (true) {
                Loan loan = (Loan) input.readObject();
                total += loan.getLoanAmount();
            }
        }
        catch (EOFException ex) {
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total loan amount from file: " + total);
    }
}
