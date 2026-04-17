    public class PayoffCalculator {
        private final CreditCard card;
        private final int months;

        public PayoffCalculator(CreditCard card, int months) {
            this.card = card;
            this.months = months;
        }

        public void simulate() {
            double balance = card.getBalance();
            double monthlyRate = card.getMonthlyRate();

            double basePayment = balance / months;

            double totalInterest = 0;
            double totalPaid = 0;

            System.out.printf("\nBase Monthly Payment (principal): $%.2f\n\n", basePayment);

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

