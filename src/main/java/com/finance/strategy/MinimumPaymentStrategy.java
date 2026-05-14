package main.java.com.finance.strategy;

import main.java.com.finance.model.CreditCard;
import main.java.com.finance.strategy.*;

public class MinimumPaymentStrategy implements PaymentStrategy {

    @Override
    public void simulate(CreditCard card, int months) {
        double balance = card.getBalance();
        double monthlyRate = card.getMonthlyRate();

        double totalInterest = 0;

        System.out.println("\n[Minimum Payment Strategy]");

        for (int i = 1; i <= months; i++) {
            double interest = balance * monthlyRate;

            // Example: 2% minimum payment
            double payment = Math.max(balance * 0.02, 25);

            balance += interest;
            balance -= payment;

            totalInterest += interest;

            if (balance < 0) balance = 0;

            System.out.printf(
                    "Month %d: Payment = $%.2f | Interest = $%.2f | Balance = $%.2f\n",
                    i, payment, interest, balance
            );

            if (balance <= 0) break;
        }

        System.out.printf("\nTotal Interest Paid: $%.2f\n", totalInterest);
    }
}
