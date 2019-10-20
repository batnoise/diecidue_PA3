public class Application extends SavingsAccount{
    public static void main(String[] arg){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        double annualInterestRate = modifyInterestRate(.04);

        //calculate monthly interest for 12 months
        final int MONTHS = 12;

        for (int i = 0; i < MONTHS; i++){
            //calculate the monthly interest for saver1 and saver2
        }

        //print the new balances
        //how do I print out the balance,

        annualInterestRate = modifyInterestRate(.05);
        //calculate one more month of interest
    }



}
