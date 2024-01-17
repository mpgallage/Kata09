package com.malakagallage.model;

public class PricingRule {
    char SKU;
    double unitPrice;
    int discountUnits;
    double discountPrice;

    public PricingRule(char SKU, double unitPrice, int discountUnits, double discountPrice) {
        this.SKU = SKU;
        this.unitPrice = unitPrice;
        this.discountUnits = discountUnits;
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "SKU: " + SKU +
                ", Unit Price: " + unitPrice +
                ", Discount Units: " + discountUnits +
                ", Discount Price: " + discountPrice;
    }
}