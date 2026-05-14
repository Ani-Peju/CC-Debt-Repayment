package main.java.com.finance.strategy;
import main.java.com.finance.model.CreditCard;

public interface PaymentStrategy {
    void simulate(CreditCard card, int months);
}