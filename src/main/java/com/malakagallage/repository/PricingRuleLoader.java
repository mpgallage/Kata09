package com.malakagallage.repository;

import com.malakagallage.model.PricingRule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PricingRuleLoader {

    private static final String URL = "jdbc:sqlite:checkout.sqlite";
    private static final String QUERY = "SELECT * FROM PricingRules";


    public static List<PricingRule> loadPricingRules() {
        List<PricingRule> pricingRules = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                char SKU = rs.getString("SKU").charAt(0);
                double unitPrice = rs.getDouble("UnitPrice");
                int discountUnits = rs.getInt("DiscountUnits");
                double discountPrice = rs.getDouble("DiscountPrice");

                PricingRule pricingRule = new PricingRule(SKU, unitPrice, discountUnits, discountPrice);
                pricingRules.add(pricingRule);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pricingRules;
    }
}
