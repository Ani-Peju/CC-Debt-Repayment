package main.java.com.finance.strategy;
import main.java.com.finance.model.CreditCard;


public class FixedPrincipalStrategy implements PaymentStrategy {

    @Override
    public void simulate(CreditCard card, int months) {
        double balance = card.getBalance();
        double monthlyRate = card.getMonthlyRate();

        double basePayment = balance / months;

        double totalInterest = 0;
        double totalPaid = 0;

        System.out.printf("\n[Fixed Principal Strategy]\n");
        System.out.printf("Base Monthly Payment (principal): $%.2f\n\n", basePayment);

        for (int i = 1; i <= months; i++) {
            double interest = balance * monthlyRate;
            double payment = basePayment + interest;

            balance += interest;
            balance -= basePayment;

            if (balance < 0) balance = 0;

            totalInterest += interest;
            totalPaid += payment;

            System.out.printf(
                    "Month %d: Payment = $%.2f | Interest = $%.2f | Balance = $%.2f\n",
                    i, payment, interest, balance
            );

            if (balance <= 0) break;
        }

        System.out.printf("\nTotal Interest Paid: $%.2f\n", totalInterest);
        System.out.printf("Total Paid: $%.2f\n", totalPaid);
    }
}
