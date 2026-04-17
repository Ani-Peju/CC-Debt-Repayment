import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Credit Card Limit: $");
        double cc_limit = scan.nextDouble();

        System.out.print("Credit Card Balance: $");
        double balance = scan.nextDouble();

        double utilization = (balance / cc_limit) * 100;

        String creditScore;
        if (utilization >= 80) {
            creditScore = "Poor";
        } else if (utilization >= 50) {
            creditScore = "Fair";
        } else if (utilization >= 30) {
            creditScore = "Good";
        } else {
            creditScore = "Excellent";
        }

        System.out.printf("Current Utilization: %.2f%% (%s)\n", utilization, creditScore);

        System.out.print("APR (%): ");
        double APR = scan.nextDouble();

        System.out.print("Target utilization (%): ");
        double targetUtilization = scan.nextDouble();

        System.out.print("Months to reach target: ");
        int months = scan.nextInt();

        double targetBalance = cc_limit * (targetUtilization / 100);

        if (balance <= targetBalance) {
            System.out.println("You're already at or below your target utilization.");
            return;
        }

        double amountToPayOff = balance - targetBalance;
        double monthlyRate = (APR / 100) / 12;

        double monthlyPayment = amountToPayOff / months;

        System.out.printf("\nTarget Utilization: %.2f%%\n", targetUtilization);
        System.out.printf("Estimated Monthly Payment: $%.2f\n\n", monthlyPayment);

        // Simulation loop
        for (int i = 1; i <= months; i++) {
            double interest = balance * monthlyRate;

            // Step 2: recalculate payment needed to hit target
            double payment = monthlyPayment + interest;

            balance -= payment;

            if (balance < targetBalance) {
                balance = targetBalance;
            }

            System.out.printf(
                    "Month %d: Payment = $%.2f | Interest = $%.2f | Balance = $%.2f\n",
                    i, payment, interest, balance
            );

            if (balance <= targetBalance) break;
        }
    }
}