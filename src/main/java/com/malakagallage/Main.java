package com.malakagallage;

import com.malakagallage.repository.PricingRuleLoader;

public class Main {
        public static void main(String[] args) {
            PricingRuleLoader.loadPricingRules().forEach(System.out::println);
        }

}