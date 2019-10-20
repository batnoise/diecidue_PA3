public class SavingsAccount {
    private static double annualInterestRate;
    private static double savingsBalance;

    //make default
    public SavingsAccount(){
        this.savingsBalance = 0;
    }

    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest(double savingsBalance, double annualInterestRate){
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance = savingsBalance + monthlyInterest;

        return savingsBalance;
    }

    public static double modifyInterestRate(double annualInterestRate){
        //set annualInterestRate to new value?

        return annualInterestRate;
    }
}
