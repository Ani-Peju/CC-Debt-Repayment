/*
* Credit Card Debit Repayment Calculator
*
* A program that calculates the user's current
* utilization of the card and how much
* the user should pay towards the card
* each month with interest.
*
* TODO: Turn console app into Web app
*   Have an option to have multiple lines of credit with other class (Loans, Car payments)
*   Find a better indicator for credit score in terms of utilization
*
*
*   */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Credit Card Limit: $");
        double limit = scan.nextDouble();

        System.out.print("Credit Card Balance: $");
        double balance = scan.nextDouble();

        System.out.print("APR (%): ");
        double apr = scan.nextDouble();

        System.out.print("Months to pay off: ");
        int months = scan.nextInt();

        CreditCard card = new CreditCard(limit, balance, apr);

        System.out.printf(
                "Current Utilization: %.2f%% (%s)\n",
                card.getUtilization(),
                card.getCreditScoreCategory()
        );

        PayoffCalculator calculator = new PayoffCalculator(card, months);
        calculator.simulate();
    }
}