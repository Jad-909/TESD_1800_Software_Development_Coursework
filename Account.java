/*
* Author: Jared Dan
* Date: 10/15/2025
*/
import java.util.Date;
import java.util.Scanner;

public class Account {

    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        while (true) {
            System.out.print("Enter an id (0–9): ");
            int id = input.nextInt();

            while (id < 0 || id > 9) {
                System.out.print("Invalid ID. Please enter a correct id (0–9): ");
                id = input.nextInt();
            }

            int choice = 0;
            while (choice != 4) {
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("The balance is $%.2f%n", accounts[id].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        accounts[id].withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        double depositAmount = input.nextDouble();
                        accounts[id].deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Exiting to main screen...\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}