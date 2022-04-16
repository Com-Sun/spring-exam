package com.nhnacademy.exam.parser;

public class WaterBill {
    private final String city;
    private final String sector;
    private final String unitPrice;
    private final int billTotal;

    public WaterBill(String city, String sector, String unitPrice, int billTotal) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "\nWaterBill{" +
            "city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice='" + unitPrice + '\'' +
            ", billTotal=" + billTotal +
            "}";
    }
}
