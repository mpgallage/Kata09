package com.malakagallage;

import com.malakagallage.logic.CheckOut;
import com.malakagallage.repository.DatabasePricingRuleLoader;
import com.malakagallage.repository.PricingRuleLoader;

public class Main {
        public static void main(String[] args) {
            PricingRuleLoader pricingRuleLoader = new DatabasePricingRuleLoader();
            CheckOut co = new CheckOut(pricingRuleLoader);

            // SKU sequences
            System.out.println(co.price(""));
            System.out.println(co.price("A"));
            System.out.println(co.price("AB"));
            System.out.println(co.price("CDBA"));

            System.out.println(co.price("AA"));
            System.out.println(co.price("AAA"));
            System.out.println(co.price("AAAA"));
            System.out.println(co.price("AAAAA"));
            System.out.println(co.price("AAAAAA"));

            System.out.println(co.price("AAAB"));
            System.out.println(co.price("AAABB"));
            System.out.println(co.price("AAABBD"));
            System.out.println(co.price("DABABA"));

            // Individual SKUs with incrementing total price
            co = new CheckOut(pricingRuleLoader);
            System.out.println(co.scan('A'));
            System.out.println(co.scan('B'));
            System.out.println(co.scan('A'));
            System.out.println(co.scan('A'));
            System.out.println(co.scan('B'));

        }

}