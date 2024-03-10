package com.mihky.backtest.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.mihky.backtest.utils.PolygonApiConstants.HISTOGRAM_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.SIGNAL_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.TIMESTAMP_TI_KEY;
import static com.mihky.backtest.utils.PolygonApiConstants.VALUE_KEY;

public class IndicatorValue {
    @JsonProperty(TIMESTAMP_TI_KEY)
    private Long timestamp;
    @JsonProperty(VALUE_KEY)
    private Double value;
    @JsonProperty(HISTOGRAM_KEY)
    private Double histogram;
    @JsonProperty(SIGNAL_KEY)
    private Double signal;

    public IndicatorValue() {}

    private IndicatorValue(Builder builder) {
        this.timestamp = builder.timestamp;
        this.value = builder.value;
        this.histogram = builder.histogram;
        this.signal = builder.signal;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Double getValue() {
        return value;
    }

    public Double getHistogram() {
        return histogram;
    }

    public Double getSignal() {
        return signal;
    }

    public static class Builder {
        private Long timestamp;
        private Double value;
        private Double histogram;
        private Double signal;

        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public Builder withHistogram(Double histogram) {
            this.histogram = histogram;
            return this;
        }

        public Builder withSignal(Double signal) {
            this.signal = signal;
            return this;
        }

        public IndicatorValue build() {
            return new IndicatorValue(this);
        }
    }
}
