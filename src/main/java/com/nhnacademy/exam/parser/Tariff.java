package com.nhnacademy.exam.parser;

public class Tariff {
    private final String index;
    private final String cityName;
    private final String category;
    private final String level;
    private final String startOfInterval;
    private final String endOfInterval;
    private final String feeOfInterval;

    public Tariff(String index, String cityName, String category, String level,
                  String startOfInterval, String endOfInterval, String feeOfInterval) {
        this.index = index;
        this.cityName = cityName;
        this.category = category;
        this.level = level;
        this.startOfInterval = startOfInterval;
        this.endOfInterval = endOfInterval;
        this.feeOfInterval = feeOfInterval;
    }

    public String getIndex() {
        return index;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCategory() {
        return category;
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

    public String getFeeOfInterval() {
        return feeOfInterval;
    }

    @Override
    public String toString() {
        return "Tariff{" +
            "index='" + index + '\'' +
            ", cityName='" + cityName + '\'' +
            ", category='" + category + '\'' +
            ", level='" + level + '\'' +
            ", startOfInterval='" + startOfInterval + '\'' +
            ", endOfInterval='" + endOfInterval + '\'' +
            ", feeOfInterval='" + feeOfInterval + '\'' +
            '}';
    }

    public boolean isUsedWaterOverInterval(int input) {
        return (input > Integer.parseInt(getStartOfInterval()));
    }

    public boolean isUsedWaterUnderInterval(int input) {
        return (input < Integer.parseInt(getStartOfInterval()));
    }
}
