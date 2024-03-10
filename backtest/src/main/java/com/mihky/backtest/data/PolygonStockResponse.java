package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.ADJUSTED_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.NEXT_URL_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.QUERY_COUNT_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.REQUEST_ID_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.RESULTS_COUNT_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.RESULTS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.STATUS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TICKER_KEY;

public class PolygonStockResponse {
    @JsonProperty(TICKER_KEY)
    private String ticker;
    @JsonProperty(ADJUSTED_KEY)
    private boolean adjusted;
    @JsonProperty(QUERY_COUNT_KEY)
    private int queryCount;
    @JsonProperty(REQUEST_ID_KEY)
    private String requestId;
    @JsonProperty(RESULTS_COUNT_KEY)
    private int resultsCount;
    @JsonProperty(STATUS_KEY)
    private String status;
    @JsonProperty(RESULTS_KEY)
    private Collection<PolygonStockData> results;
    @JsonProperty(NEXT_URL_KEY)
    private String nextUrl;

    public PolygonStockResponse() {}

    private PolygonStockResponse(Builder builder) {
        this.ticker = builder.ticker;
        this.adjusted = builder.adjusted;
        this.queryCount = builder.queryCount;
        this.requestId = builder.requestId;
        this.resultsCount = builder.resultsCount;
        this.status = builder.status;
        this.results = builder.results;
        this.nextUrl = builder.nextUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTicker() {
        return ticker;
    }

    public boolean getAdjusted() {
        return adjusted;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public String getRequestId() {
        return requestId;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public String getStatus() {
        return status;
    }

    public Collection<PolygonStockData> getResults() {
        return results;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public static class Builder {
        private String ticker;
        private boolean adjusted;
        private int queryCount;
        private String requestId;
        private int resultsCount;
        private String status;
        private Collection<PolygonStockData> results;
        private String nextUrl;

        public Builder withTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public Builder withAdjusted(boolean adjusted) {
            this.adjusted = adjusted;
            return this;
        }

        public Builder withQueryCount(int queryCount) {
            this.queryCount = queryCount;
            return this;
        }

        public Builder withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withResultsCount(int resultsCount) {
            this.resultsCount = resultsCount;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withResults(Collection<PolygonStockData> results) {
            this.results = results;
            return this;
        }

        public Builder withNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public PolygonStockResponse build() {
            return new PolygonStockResponse(this);
        }
    }
}
