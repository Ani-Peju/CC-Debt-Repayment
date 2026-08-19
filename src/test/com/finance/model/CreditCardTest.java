package test.java.com.finance.model;

import main.java.com.finance.model.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    @Test
    void shouldCalculateUtilization() {
        CreditCard card = new CreditCard(1000, 500, 20);

        assertEquals(50.0, card.getUtilization(), 0.001);
    }

    @Test
    void shouldReturnExcellentForLowUtilization() {
        CreditCard card = new CreditCard(1000, 200, 20);

        assertEquals("Excellent", card.getCreditScoreCategory());
    }

    @Test
    void shouldReturnGoodFor30PercentUtilization() {
        CreditCard card = new CreditCard(1000, 300, 20);

        assertEquals("Good", card.getCreditScoreCategory());
    }

    @Test
    void shouldReturnFairFor50PercentUtilization() {
        CreditCard card = new CreditCard(1000, 500, 20);

        assertEquals("Fair", card.getCreditScoreCategory());
    }

    @Test
    void shouldReturnPoorFor80PercentUtilization() {
        CreditCard card = new CreditCard(1000, 800, 20);

        assertEquals("Poor", card.getCreditScoreCategory());
    }

    @Test
    void shouldCalculateMonthlyInterestRate() {
        CreditCard card = new CreditCard(1000, 500, 24);

        assertEquals(0.02, card.getMonthlyRate(), 0.001);
    }
}