public class ExerciseOperators {
    public static void main(String[] args) {
//       Finance - Loan Payment Calculator
//       Declare and initialize variables
        double loanAmount = 25000.00;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;
        double monthlyPayment = (loanAmount*(annualInterestRate/100)/12);

//       1. Use Assignment Operators
        loanAmount += 5000.00;
        annualInterestRate -= 1.0;
        loanTermYears++;

//       2. Use Comparison Operators
        boolean isLoanAmountHigh = loanAmount > 30000;
        boolean isMonthlyPaymentHigh = monthlyPayment > 500;

//       3. Use Logical Operators
        boolean isLoanAffordable = monthlyPayment < 500 && loanTermYears > 3;
        boolean isLoanExpensive = monthlyPayment > 700 || annualInterestRate > 6;

//       4. Print all results
        System.out.printf("Current Loan Amount: $%.2f\n", loanAmount);
        System.out.printf("Current Annual Interest Rate: %.1f%%", annualInterestRate);
        System.out.printf("Loan Term: %d years\n", loanTermYears);
        System.out.printf("Total Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.println("Does loan amount exceed $30,000.00: " + isLoanAmountHigh);
        System.out.println("Does monthly payment exceed $500.00: " + isMonthlyPaymentHigh);
        System.out.println("Is the loan affordable: " + isLoanAffordable);
        System.out.println("Is the loan expensive: " + isLoanExpensive);
        
    }
}
