public class SavingsAccount extends Account {

    public SavingsAccount(int par, int par1) {
        super();
    }

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Cannot withdraw beyond current balance.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (Savings Account)";
    }
}