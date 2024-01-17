package com.malakagallage.model;

public class PricingRule {
    private char SKU;
    private double unitPrice;
    private int discountUnits;
    private double discountPrice;

    public PricingRule(char SKU, double unitPrice, int discountUnits, double discountPrice) {
        this.SKU = SKU;
        this.unitPrice = unitPrice;
        this.discountUnits = discountUnits;
        this.discountPrice = discountPrice;
    }

    public char getSKU() {
        return SKU;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getDiscountUnits() {
        return discountUnits;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "SKU: " + SKU +
                ", Unit Price: " + unitPrice +
                ", Discount Units: " + discountUnits +
                ", Discount Price: " + discountPrice;
    }
}