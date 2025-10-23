/*
* Author: Jared Dan
* Date: 10/15/2025
*
*This is an assignment for my class called MyInteger.
*/

public class MyInteger {
    // Data field
    private int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter method
    public int getValue() {
        return value;
    }

    // Non-static methods
    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    // Static methods (with int parameter)
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    // Static methods (with MyInteger parameter)
    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    // Non-static equals methods
    public boolean equals(int otherValue) {
        return this.value == otherValue;
    }

    public boolean equals(MyInteger myInt) {
        return this.value == myInt.value;
    }

    // Static parseInt methods
    public static int parseInt(char[] chars) {
        String s = new String(chars);
        return Integer.parseInt(s);
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    // ===== Test Program (main method) =====
    public static void main(String[] args) {
        MyInteger num1 = new MyInteger(7);
        MyInteger num2 = new MyInteger(24);

        System.out.println("num1 value: " + num1.getValue());
        System.out.println("num1 is even? " + num1.isEven());
        System.out.println("num1 is odd? " + num1.isOdd());
        System.out.println("num1 is prime? " + num1.isPrime());
        System.out.println();

        System.out.println("num2 value: " + num2.getValue());
        System.out.println("num2 is even? " + num2.isEven());
        System.out.println("num2 is odd? " + num2.isOdd());
        System.out.println("num2 is prime? " + num2.isPrime());
        System.out.println();

        System.out.println("Is 23 even? " + MyInteger.isEven(23));
        System.out.println("Is 23 odd? " + MyInteger.isOdd(23));
        System.out.println("Is 23 prime? " + MyInteger.isPrime(23));
        System.out.println();

        System.out.println("Is num1 even? " + MyInteger.isEven(num1));
        System.out.println("Is num1 prime? " + MyInteger.isPrime(num1));
        System.out.println("Is num2 odd? " + MyInteger.isOdd(num2));
        System.out.println();

        System.out.println("num1 equals 7? " + num1.equals(7));
        System.out.println("num1 equals num2? " + num1.equals(num2));
        System.out.println();

        char[] digits = {'1', '2', '3', '4'};
        System.out.println("parseInt(char[]): " + MyInteger.parseInt(digits));
        System.out.println("parseInt(String): " + MyInteger.parseInt("5678"));
    }
}