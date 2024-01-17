package com.malakagallage.logic;

import com.malakagallage.repository.PricingRuleLoader;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

    private Map<Character, Integer> currentUnits = new HashMap<>();
    private Map<Character, Double> currentPrices = new HashMap<>();

    private PricingRuleDecoder pricingRuleDecoder;

    public CheckOut(PricingRuleLoader pricingRuleLoader) {
        pricingRuleDecoder = new PricingRuleDecoder(pricingRuleLoader.loadPricingRules());
    }

    public double scan(char SKU) {
        if (!pricingRuleDecoder.getUnitPrices().containsKey(SKU)) {
            throw new IllegalArgumentException("Invalid SKU: " + SKU);
        }

        double unitPrice = pricingRuleDecoder.getUnitPrices().get(SKU);
        int discountUnits = pricingRuleDecoder.getDiscountUnits().get(SKU);
        double discountPrice = pricingRuleDecoder.getDiscountPrices().get(SKU);

        if(!currentUnits.containsKey(SKU)) {
            currentUnits.put(SKU, 1);
            currentPrices.put(SKU, unitPrice);

        } else {
            int unitCount = currentUnits.get(SKU) + 1;
            currentUnits.put(SKU, unitCount);

            if (discountUnits == 0) {
                double price = unitCount * unitPrice;
                currentPrices.put(SKU, price);

            } else {
                int eligibleDiscountUnits = unitCount / discountUnits;
                int remainderUnits = currentUnits.get(SKU) % discountUnits;

                double price = eligibleDiscountUnits * discountPrice + remainderUnits * unitPrice;
                currentPrices.put(SKU, price);
            }
        }

        return currentPrices.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double price(String SKUs) {
        // reset current units and prices
        this.currentUnits = new HashMap<>();
        this.currentPrices = new HashMap<>();

        double total = 0;
        for (char SKU : SKUs.toCharArray()) {
            total = scan(SKU);
        }
        return total;
    }
}
