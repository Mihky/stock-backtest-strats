package com.mihky.backtest;

// TODO: I should move this to a common library
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
