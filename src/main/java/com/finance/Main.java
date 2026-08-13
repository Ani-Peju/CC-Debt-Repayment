package main.java.com.finance;/*
* Credit Card Debit Repayment Calculator
*
* A program that calculates the user's current
* utilization of the card and how much
* the user should pay towards the card
* each month with interest.
*
* TODO: Turn console app into Web app
*   Have an option to have multiple lines of credit with other class (Loans, Car payments, etc)
    Include other payment strategies (Snowball and Avalanche)
*   Find a better indicator for credit score in terms of utilization
*
*
*   */
import main.java.com.finance.model.CreditCard;
import main.java.com.finance.service.PayoffCalculator;
import main.java.com.finance.strategy.FixedPrincipalStrategy;
import main.java.com.finance.strategy.MinimumPaymentStrategy;
import main.java.com.finance.strategy.PaymentStrategy;

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

        System.out.print("Months: ");
        int months = scan.nextInt();

        CreditCard card = new CreditCard(limit, balance, apr);

        System.out.printf(
                "Utilization: %.2f%% (%s)\n",
                card.getUtilization(),
                card.getCreditScoreCategory()
        );

        System.out.println("\nChoose Strategy:");
        System.out.println("1. Fixed Principal");
        System.out.println("2. Minimum Payment");

        int choice = scan.nextInt();

        PaymentStrategy strategy;

        if (choice == 2) {
            strategy = new MinimumPaymentStrategy();
        } else {
            strategy = new FixedPrincipalStrategy();
        }

        PayoffCalculator calculator = new PayoffCalculator(strategy);
        calculator.run(card, months);
    }
}