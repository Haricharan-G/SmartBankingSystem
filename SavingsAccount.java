public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String holderName) {
        super(accountNumber, holderName);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
