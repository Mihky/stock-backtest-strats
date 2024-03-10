package data.common.enums;

public enum Granularity {
    SECOND("second"),
    MINUTE("minute"),
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    QUARTER("quarter"),
    YEAR("year");

    private final String name;
    Granularity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
