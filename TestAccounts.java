public class TestAccounts {
    public static void main(String[] args) {

        Account acc = new Account(1001, 5000);
        acc.setAnnualInterestRate(3.5);

        SavingsAccount savings = new SavingsAccount(2001, 3000);
        savings.setAnnualInterestRate(4.0);

        CheckingAccount checking = new CheckingAccount(3001, 2000, 500); // $500 overdraft
        checking.setAnnualInterestRate(2.5);

        System.out.println("Account Info:\n" + acc + "\n");
        System.out.println("Savings Account Info:\n" + savings + "\n");
        System.out.println("Checking Account Info:\n" + checking + "\n");

        System.out.println("Attempting to withdraw $3500 from checking account:");
        checking.withdraw(3500);
        System.out.println("Checking account balance: " + checking.getBalance());

        System.out.println("Attempting to withdraw $3500 from savings account:");
        savings.withdraw(3500);
        System.out.println("Savings account balance: " + savings.getBalance());
    }
}