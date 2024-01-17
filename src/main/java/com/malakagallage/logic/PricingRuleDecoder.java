package com.malakagallage.logic;

import com.malakagallage.model.PricingRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingRuleDecoder {

    private Map<Character, Double> unitPrices = new HashMap<>();
    private Map<Character, Integer> discountUnits = new HashMap<>();
    private Map<Character, Double> discountPrices = new HashMap<>();

    public PricingRuleDecoder(List<PricingRule> pricingRules) {
        for (PricingRule pricingRule : pricingRules) {
            unitPrices.put(pricingRule.getSKU(), pricingRule.getUnitPrice());
            discountUnits.put(pricingRule.getSKU(), pricingRule.getDiscountUnits());
            discountPrices.put(pricingRule.getSKU(), pricingRule.getDiscountPrice());
        }
    }

    public Map<Character, Double> getUnitPrices() {
        return unitPrices;
    }

    public Map<Character, Integer> getDiscountUnits() {
        return discountUnits;
    }

    public Map<Character, Double> getDiscountPrices() {
        return discountPrices;
    }
}
