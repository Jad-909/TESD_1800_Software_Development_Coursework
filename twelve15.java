import java.io.*;
import java.util.*;

public class twelve15 {
    public static void main(String[] args) throws Exception {
        File file = new File("Exercise12_15.txt");

        if (!file.exists()) {
            PrintWriter output = new PrintWriter(file);

            for (int i = 0; i < 100; i++) {
                int number = (int)(Math.random() * 100);
                output.print(number + " ");
            }

            output.close();
            System.out.println("Data written to " + file.getName());
        }

        Scanner input = new Scanner(file);

        int[] numbers = new int[100];
        int count = 0;
        while (input.hasNext()) {
            numbers[count] = input.nextInt();
            count++;
        }
        input.close();

        Arrays.sort(numbers);

        System.out.println("Sorted numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}