package main.java.com.finance.service;

import main.java.com.finance.model.CreditCard;
import main.java.com.finance.strategy.*;

public class PayoffCalculator {
    private PaymentStrategy strategy;

    public PayoffCalculator(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void run(CreditCard card, int months) {
        strategy.simulate(card, months);
    }
}

