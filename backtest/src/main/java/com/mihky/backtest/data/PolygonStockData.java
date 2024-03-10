package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.mihky.backtest.utils.PolygonApiConstants.CLOSE_PRICE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.HIGH_PRICE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.LOW_PRICE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.NUM_TRANSACTIONS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.OPEN_PRICE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.OTC_TICKER_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TIMESTAMP_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TRADING_VOLUME_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.VOLUME_WEIGHTED_AVERAGE_PRICE_KEY;

public class PolygonStockData {
    @JsonProperty(CLOSE_PRICE_KEY)
    private double closePrice;
    @JsonProperty(HIGH_PRICE_KEY)
    private double highPrice;
    @JsonProperty(LOW_PRICE_KEY)
    private double lowPrice;
    @JsonProperty(NUM_TRANSACTIONS_KEY)
    private Integer numTransactions;
    @JsonProperty(OPEN_PRICE_KEY)
    private double openPrice;
    @JsonProperty(OTC_TICKER_KEY)
    private Boolean isOTC;
    @JsonProperty(TIMESTAMP_KEY)
    private long timestamp;
    @JsonProperty(TRADING_VOLUME_KEY)
    private double tradingVolume;
    @JsonProperty(VOLUME_WEIGHTED_AVERAGE_PRICE_KEY)
    private Double volumeWeightedAvgPrice;

    public PolygonStockData() {}

    private PolygonStockData(Builder builder) {
        this.closePrice = builder.closePrice;
        this.highPrice = builder.highPrice;
        this.lowPrice = builder.lowPrice;
        this.numTransactions = builder.numTransactions;
        this.openPrice = builder.openPrice;
        this.isOTC = builder.isOTC;
        this.timestamp = builder.timestamp;
        this.tradingVolume = builder.tradingVolume;
        this.volumeWeightedAvgPrice = builder.volumeWeightedAvgPrice;
    }

    public static Builder builder() {
        return new Builder();
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public Integer getNumTransactions() {
        return numTransactions;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public Boolean getIsOTC() {
        return isOTC;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public Double getVolumeWeightedAvgPrice() {
        return volumeWeightedAvgPrice;
    }

    public static class Builder {
        private double closePrice;
        private double highPrice;
        private double lowPrice;
        private Integer numTransactions;
        private double openPrice;
        private Boolean isOTC;
        private long timestamp;
        private double tradingVolume;
        private Double volumeWeightedAvgPrice;

        public Builder withClosePrice(double closePrice) {
            this.closePrice = closePrice;
            return this;
        }

        public Builder withHighPrice(double highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public Builder withLowPrice(double lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        public Builder withNumTransactions(Integer numTransactions) {
            this.numTransactions = numTransactions;
            return this;
        }

        public Builder withOpenPrice(double openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        public Builder withIsOTC(Boolean isOTC) {
            this.isOTC = isOTC;
            return this;
        }

        public Builder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withTradingVolume(double tradingVolume) {
            this.tradingVolume = tradingVolume;
            return this;
        }

        public Builder withVolumeWeightedAvgPrice(Double volumeWeightedAvgPrice) {
            this.volumeWeightedAvgPrice = volumeWeightedAvgPrice;
            return this;
        }

        public PolygonStockData build() {
            return new PolygonStockData(this);
        }
    }
}
