import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- Smart Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();

                    Account acc = new SavingsAccount(accNo, name);
                    bank.addAccount(acc);

                } else if (choice == 2) {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    Account acc = bank.findAccount(accNo);

                    if (acc != null) {
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        acc.deposit(amount);
                        System.out.println("Deposit successful");
                    } else {
                        System.out.println("Account not found");
                    }

                } else if (choice == 3) {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    Account acc = bank.findAccount(accNo);

                    if (acc != null) {
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        acc.withdraw(amount);
                        System.out.println("Withdrawal successful");
                    } else {
                        System.out.println("Account not found");
                    }

                } else if (choice == 4) {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    Account acc = bank.findAccount(accNo);

                    if (acc != null) {
                        acc.displayAccountType();
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }

                } else if (choice == 5) {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    Account acc = bank.findAccount(accNo);

                    if (acc != null) {
                        acc.showTransactions();
                    } else {
                        System.out.println("Account not found");
                    }

                } else if (choice == 6) {
                    System.out.println("Thank you for using Smart Banking System");
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
