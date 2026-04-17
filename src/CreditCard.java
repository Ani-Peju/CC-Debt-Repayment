public class CreditCard {
    private final double  limit;
    private final double balance;
    private final double APR;

    public CreditCard(double limit, double balance, double APR) {
        this.limit = limit;
        this.balance = balance;
        this.APR = APR;
    }

    public double getBalance() {
        return balance;
    }

    public double getUtilization() {
        return (balance / limit) * 100;
    }

    //TODO: Find better or more detailed indicator for utilization
    public String getCreditScoreCategory() {
        double utilization = getUtilization();

        if (utilization >= 80) return "Poor";
        else if (utilization >= 50) return "Fair";
        else if (utilization >= 30) return "Good";
        else return "Excellent";

    }

    public double getMonthlyRate() {
        return (APR / 100) / 12;
    }


}