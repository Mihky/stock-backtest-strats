package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.ACTIVE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.CIK_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.COMPOSITE_FIGI_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.COUNT_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.CURRENCY_NAME_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.DELISTED_UTC_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.LAST_UPDATED_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.LOCALE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.MARKET_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.NAME_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.NEXT_URL_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.PRIMARY_EXCHANGE_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.REQUEST_ID_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.RESULTS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.SHARE_CLASS_FIGI_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TICKER_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TYPE_KEY;

public class PolygonTickerInfo {
    @JsonProperty(ACTIVE_KEY)
    private Boolean isActive;
    @JsonProperty(CIK_KEY)
    private String cik;
    @JsonProperty(COMPOSITE_FIGI_KEY)
    private String compositeFigi;
    @JsonProperty(CURRENCY_NAME_KEY)
    private String currencyName;
    @JsonProperty(DELISTED_UTC_KEY)
    private String delistedUtc;
    @JsonProperty(LAST_UPDATED_KEY)
    private String lastUpdatedUtc;
    @JsonProperty(LOCALE_KEY)
    private String locale;
    @JsonProperty(MARKET_KEY)
    private String market;
    @JsonProperty(NAME_KEY)
    private String name;
    @JsonProperty(PRIMARY_EXCHANGE_KEY)
    private String primaryExchange;
    @JsonProperty(SHARE_CLASS_FIGI_KEY)
    private String shareClassFigi;
    @JsonProperty(TICKER_KEY)
    private String ticker;
    @JsonProperty(TYPE_KEY)
    private String type;

    public PolygonTickerInfo() {}

    private PolygonTickerInfo(Builder builder) {
        this.isActive = builder.isActive;
        this.cik = builder.cik;
        this.compositeFigi = builder.compositeFigi;
        this.currencyName = builder.currencyName;
        this.delistedUtc = builder.delistedUtc;
        this.lastUpdatedUtc = builder.lastUpdatedUtc;
        this.locale = builder.locale;
        this.market = builder.market;
        this.name = builder.name;
        this.primaryExchange = builder.primaryExchange;
        this.shareClassFigi = builder.shareClassFigi;
        this.ticker = builder.ticker;
        this.type = builder.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getCik() {
        return cik;
    }

    public String getCompositeFigi() {
        return compositeFigi;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getDelistedUtc() {
        return delistedUtc;
    }

    public String getLastUpdatedUtc() {
        return lastUpdatedUtc;
    }

    public String getLocale() {
        return locale;
    }

    public String getMarket() {
        return market;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public String getShareClassFigi() {
        return shareClassFigi;
    }

    public String getTicker() {
        return ticker;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private Boolean isActive;
        private String cik;
        private String compositeFigi;
        private String currencyName;
        private String delistedUtc;
        private String lastUpdatedUtc;
        private String locale;
        private String market;
        private String name;
        private String primaryExchange;
        private String shareClassFigi;
        private String ticker;
        private String type;

        public Builder withClosePrice(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder withCik(String cik) {
            this.cik = cik;
            return this;
        }

        public Builder withCompositeFigi(String compositeFigi) {
            this.compositeFigi = compositeFigi;
            return this;
        }

        public Builder withCurrencyName(String currencyName) {
            this.currencyName = currencyName;
            return this;
        }

        public Builder withDelistedUtc(String delistedUtc) {
            this.delistedUtc = delistedUtc;
            return this;
        }

        public Builder withLastUpdatedUtc(String lastUpdatedUtc) {
            this.lastUpdatedUtc = lastUpdatedUtc;
            return this;
        }

        public Builder withLocale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder withMarket(String market) {
            this.market = market;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrimaryExchange(String primaryExchange) {
            this.primaryExchange = primaryExchange;
            return this;
        }

        public Builder withShareClassFigi(String shareClassFigi) {
            this.shareClassFigi = shareClassFigi;
            return this;
        }

        public Builder withTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public PolygonTickerInfo build() {
            return new PolygonTickerInfo(this);
        }
    }
}
