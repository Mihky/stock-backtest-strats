package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.COUNT_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.NEXT_URL_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.REQUEST_ID_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.RESULTS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.STATUS_KEY;

public class PolygonTickerResponse {
    @JsonProperty(COUNT_KEY)
    private Integer count;
    @JsonProperty(NEXT_URL_KEY)
    private String nextUrl;
    @JsonProperty(REQUEST_ID_KEY)
    private String requestId;
    @JsonProperty(RESULTS_KEY)
    private Collection<PolygonTickerInfo> results;
    @JsonProperty(STATUS_KEY)
    private String status;

    public PolygonTickerResponse() {}

    private PolygonTickerResponse(Builder builder) {
        this.count = builder.count;
        this.nextUrl = builder.nextUrl;
        this.requestId = builder.requestId;
        this.results = builder.results;
        this.status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getCount() {
        return count;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public Collection<PolygonTickerInfo> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private Integer count;
        private String nextUrl;
        private String requestId;
        private Collection<PolygonTickerInfo> results;
        private String status;

        public Builder withClosePrice(Integer count) {
            this.count = count;
            return this;
        }

        public Builder withNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public Builder withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withResults(Collection<PolygonTickerInfo> results) {
            this.results = results;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public PolygonTickerResponse build() {
            return new PolygonTickerResponse(this);
        }
    }
}
