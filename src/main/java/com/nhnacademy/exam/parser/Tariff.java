package com.nhnacademy.exam.parser;

/**
 * Tariff_20220331을 파싱하여 객체로 만든 클래스입니다.
 */

public class Tariff {
    private final String index;
    private final String city;
    private final String sector;
    private final String level;
    private final String startOfInterval;
    private final String endOfInterval;
    private final String unitPrice;

    public Tariff(String index, String city, String sector, String level,
                  String startOfInterval, String endOfInterval, String unitPrice) {
        this.index = index;
        this.city = city;
        this.sector = sector;
        this.level = level;
        this.startOfInterval = startOfInterval;
        this.endOfInterval = endOfInterval;
        this.unitPrice = unitPrice;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
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

    public boolean isUsedWaterOverInterval(int input) {
        return (input >= Integer.parseInt(getStartOfInterval()));
    }

    public boolean isUsedWaterUnderInterval(int input) {
        return (input < Integer.parseInt(getEndOfInterval()));
    }
}
