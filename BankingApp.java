import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String name, double initialBalance) {
        this.accountHolder = name;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display account details
    public void accountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ₹");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);

        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.accountInfo();
                    break;
                case 5:
                    System.out.println("Thank you for using Banking App!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
