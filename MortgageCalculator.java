package com.jovision.mix.event.api.constant;

//import java.util.Scanner;
//
//public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Enter the principal
        System.out.print(" Please enter the total loan amount (principal）: ");
        double principal = scanner.nextDouble();

        //  Enter the APR
        System.out.print(" Please enter an annual percentage rate (e.g. 7.625 is denoted as0.07625）: ");
        double interestRate = scanner.nextDouble();

        //  Enter the loan term (years)
        System.out.print(" Please enter the loan term (years): ");
        int loanLengthYears = scanner.nextInt();

        //  Convert to months
        int loanLengthMonths = loanLengthYears * 12;

        //  Calculate the monthly interest rate
        double monthlyInterestRate = interestRate / 12 / 100;

        //  Use the compound interest formula to calculate the monthly repayment
        double monthlyPayment = calculateMonthlyPayment(principal, monthlyInterestRate, loanLengthMonths);

        //  Calculate the total interest
        double totalInterestPaid = calculateTotalInterestPaid(monthlyPayment, principal, loanLengthMonths);

        // Display the results
        System.out.printf(" Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf(" Total interest: %.2f\n", totalInterestPaid);

        scanner.close();
    }

    //  Calculate your monthly payments
    private static double calculateMonthlyPayment(double principal, double monthlyInterestRate, int loanLengthMonths) {
        double monthlyPayment = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -loanLengthMonths));
        return Math.round(monthlyPayment * 100) / 100; //  Keep two decimal places
    }

    //  Calculate the total interest
    private static double calculateTotalInterestPaid(double monthlyPayment, double principal, int loanLengthMonths) {
        double totalInterestPaid = monthlyPayment * loanLengthMonths - principal;
        return Math.round(totalInterestPaid * 100) / 100; //  Keep two decimal places
    }
}