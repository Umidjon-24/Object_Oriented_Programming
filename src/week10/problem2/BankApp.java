public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        System.out.println("Balance: $" + String.format("%.2f", account.getBalance()));
        try {
            account.withdraw(200);
            System.out.println("Withdrew $200.00. Remaining balance: $" + String.format("%.2f", account.getBalance()));
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(400);
            System.out.println("Withdrew $400.00. Remaining balance: $" + String.format("%.2f", account.getBalance()));
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(100);
            System.out.println("Withdrew $100.00. Remaining balance: $" + String.format("%.2f", account.getBalance()));
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
