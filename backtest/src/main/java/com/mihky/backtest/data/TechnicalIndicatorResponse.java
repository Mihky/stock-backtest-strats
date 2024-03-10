package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.mihky.backtest.utils.PolygonApiConstants.NEXT_URL_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.REQUEST_ID_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.RESULTS_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.STATUS_KEY;

public class TechnicalIndicatorResponse {
    @JsonProperty(NEXT_URL_KEY)
    private String nextUrl;
    @JsonProperty(REQUEST_ID_KEY)
    private String requestId;
    @JsonProperty(RESULTS_KEY)
    private TechnicalIndicatorResults results;
    @JsonProperty(STATUS_KEY)
    private String status;

    public TechnicalIndicatorResponse() {}

    private TechnicalIndicatorResponse(Builder builder) {
        this.nextUrl = builder.nextUrl;
        this.requestId = builder.requestId;
        this.results = builder.results;
        this.status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public TechnicalIndicatorResults getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private String nextUrl;
        private String requestId;
        private TechnicalIndicatorResults results;
        private String status;

        public Builder withNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public Builder withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withResults(TechnicalIndicatorResults results) {
            this.results = results;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public TechnicalIndicatorResponse build() {
            return new TechnicalIndicatorResponse(this);
        }
    }
}
