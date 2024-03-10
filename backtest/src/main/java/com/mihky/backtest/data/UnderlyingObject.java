package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.AGGREGATES_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.URL_KEY;

public class UnderlyingObject {
    @JsonProperty(AGGREGATES_KEY)
    private Collection<PolygonStockData> aggregates;
    @JsonProperty(URL_KEY)
    private String url;

    public UnderlyingObject() {}

    private UnderlyingObject(Builder builder) {
        this.aggregates = builder.aggregates;
        this.url = builder.url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Collection<PolygonStockData> getAggregates() {
        return aggregates;
    }

    public String getUrl() {
        return url;
    }

    public static class Builder {
        private Collection<PolygonStockData> aggregates;
        private String url;

        public Builder withAggregates(Collection<PolygonStockData> aggregates) {
            this.aggregates = aggregates;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public UnderlyingObject build() {
            return new UnderlyingObject(this);
        }
    }
}
