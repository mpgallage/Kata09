package com.malakagallage;

import com.malakagallage.logic.CheckOut;
import com.malakagallage.repository.DatabasePricingRuleLoader;
import com.malakagallage.repository.PricingRuleLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class PricingRuleTest {

    @Test
    public void testPricingRuleSequence() {
        PricingRuleLoader pricingRuleLoader = new DatabasePricingRuleLoader();
        CheckOut co = new CheckOut(pricingRuleLoader);

        // SKU sequences
        assertEquals(0.0, co.price(""));
        assertEquals(50.0, co.price("A"));
        assertEquals(80.0, co.price("AB"));
        assertEquals(115.0, co.price("CDBA"));

        assertEquals(100.0, co.price("AA"));
        assertEquals(130.0, co.price("AAA"));
        assertEquals(180.0, co.price("AAAA"));
        assertEquals(230.0, co.price("AAAAA"));
        assertEquals(260.0, co.price("AAAAAA"));

        assertEquals(160.0, co.price("AAAB"));
        assertEquals(175.0, co.price("AAABB"));
        assertEquals(190.0, co.price("AAABBD"));
        assertEquals(190.0, co.price("DABABA"));
    }

    @Test
    public void testPricingRuleIncremental() {
        PricingRuleLoader pricingRuleLoader = new DatabasePricingRuleLoader();
        CheckOut co = new CheckOut(pricingRuleLoader);

        assertEquals(50.0, co.scan('A'));
        assertEquals(80.0, co.scan('B'));
        assertEquals(130.0, co.scan('A'));
        assertEquals(160.0, co.scan('A'));
        assertEquals(175.0, co.scan('B'));
    }

    @Test
    public void testPricingRuleError() {
        PricingRuleLoader pricingRuleLoader = new DatabasePricingRuleLoader();
        CheckOut co = new CheckOut(pricingRuleLoader);

        assertThrows(IllegalArgumentException.class, () -> {
            co.price("DAMABA");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            co.scan('D');
            co.scan('Z');
            co.scan('A');
        });
    }
}
