package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.UNDERLYING_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.VALUES_KEY;

public class TechnicalIndicatorResults {
    @JsonProperty(UNDERLYING_KEY)
    private UnderlyingObject underlying;
    @JsonProperty(VALUES_KEY)
    private Collection<IndicatorValue> values;

    public TechnicalIndicatorResults() {}

    private TechnicalIndicatorResults(Builder builder) {
        this.underlying = builder.underlying;
        this.values = builder.values;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UnderlyingObject getUnderlying() {
        return underlying;
    }

    public Collection<IndicatorValue> getValues() {
        return values;
    }

    public static class Builder {
        private UnderlyingObject underlying;
        private Collection<IndicatorValue> values;

        public Builder withUnderlying(UnderlyingObject underlying) {
            this.underlying = underlying;
            return this;
        }

        public Builder withValues(Collection<IndicatorValue> values) {
            this.values = values;
            return this;
        }

        public TechnicalIndicatorResults build() {
            return new TechnicalIndicatorResults(this);
        }
    }
}
