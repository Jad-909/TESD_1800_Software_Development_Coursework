import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
           numbers[i] = (int)(Math.random() * 100);

        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");

        try {
            int index = input.nextInt();
            System.out.println("The element at index " + index + " is " +
numbers[index]);
        }
        
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds");
        }
    }
}