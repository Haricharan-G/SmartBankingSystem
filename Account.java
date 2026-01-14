import java.util.ArrayList;

public abstract class Account {

    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) throws InvalidAmountException {
        if (amount <= 0 || amount > balance) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    public abstract void displayAccountType();
}
