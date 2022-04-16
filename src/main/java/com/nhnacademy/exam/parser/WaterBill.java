package com.nhnacademy.exam.parser;

public class WaterBill {
    private final String index;
    private final String city;
    private final String sector;
    private final String level;
    private final String startOfInterval;
    private final String endOfInterval;
    private final String unitPrice;

    public WaterBill(String index, String city, String sector, String level,
                     String startOfInterval, String endOfInterval, String unitPrice) {
        this.index = index;
        this.city = city;
        this.sector = sector;
        this.level = level;
        this.startOfInterval = startOfInterval;
        this.endOfInterval = endOfInterval;
        this.unitPrice = unitPrice;
    }

    public String getIndex() {
        return index;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public String getLevel() {
        return level;
    }

    public String getStartOfInterval() {
        return startOfInterval;
    }

    public String getEndOfInterval() {
        return endOfInterval;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "\nWaterBill{" +
            "city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice='" + unitPrice + '\'' +
            "}";
    }

    public boolean isUsedWaterOverInterval(int input) {
        return (input >= Integer.parseInt(getStartOfInterval()));
    }

    public boolean isUsedWaterUnderInterval(int input) {
        return (input < Integer.parseInt(getEndOfInterval()));
    }
}
