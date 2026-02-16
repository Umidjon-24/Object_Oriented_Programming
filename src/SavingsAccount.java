public class SavingsAccount {
    private static double annualInterestRate=4;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest() {
        for (int i=1; i<=12;i++ ) {
            savingsBalance += savingsBalance * (annualInterestRate/100) / 12;
            System.out.printf("Month %d - %f\n", i, savingsBalance);
        }
        return savingsBalance;
    }
    public void ModifyInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }
}
