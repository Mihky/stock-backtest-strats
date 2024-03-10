package com.mihky.backtest.controllers;

import com.mihky.backtest.data.PolygonStockResponse;
import com.mihky.backtest.data.PolygonTickerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_ASSET_TYPE;
import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_INDICATOR_LIMIT_COUNT;
import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_LIMIT_COUNT;
import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_MARKET_TYPE;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_AGGREGATE_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_GROUPED_DAILY_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_TECHNICAL_INDICATOR_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_TICKERS_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.PAGINATION_TEMPLATE;
import static com.mihky.backtest.utils.PolygonApiConstants.POLYGON_BASE_URL;
import static com.mihky.backtest.utils.PolygonApiConstants.addAdditionalParameter;

@RestController
@RequestMapping("/api")
public class TechnicalIndicatorController {
    private final RestTemplate restTemplate;

    public TechnicalIndicatorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // https://api.polygon.io/v1/indicators/{indicatorType}/{stockTicker}?timespan={timespan}&window={window}&series_type={seriesType}&limit={limit}&apiKey={apiKey}";
    @GetMapping("/technical_indicator")
    public PolygonStockResponse getAggregates(
            @RequestParam(value = "indicatorType") String indicatorType,
            @RequestParam(value = "stockTicker") String stockTicker,
            @RequestParam(value = "timespan") String granularity,
            @RequestParam(value = "window") int window,
            @RequestParam(value = "seriesType") String seriesType,
            @RequestParam(value = "apiKey") String apiKey,
            @RequestParam(value = "limit", defaultValue = DEFAULT_INDICATOR_LIMIT_COUNT) String limit,
            @RequestParam(value = "timestamp", defaultValue = "") String timestamp,
            @RequestParam(value = "shortWindow", defaultValue = "") String shortWindow,
            @RequestParam(value = "longWindow", defaultValue = "") String longWindow,
            @RequestParam(value = "signalWindow", defaultValue = "") String signalWindow) {
        String apiUrl = POLYGON_BASE_URL + String.format(
                GET_TECHNICAL_INDICATOR_ENDPOINT, indicatorType, stockTicker, granularity, window, seriesType, limit, apiKey);

        if (!StringUtils.isEmpty(timestamp)) {
            apiUrl = addAdditionalParameter(apiUrl, "timestamp", timestamp);
        }
        if (!StringUtils.isEmpty(shortWindow)) {
            apiUrl = addAdditionalParameter(apiUrl, "short_window", shortWindow);
        }
        if (!StringUtils.isEmpty(longWindow)) {
            apiUrl = addAdditionalParameter(apiUrl, "long_window", longWindow);
        }
        if (!StringUtils.isEmpty(signalWindow)) {
            apiUrl = addAdditionalParameter(apiUrl, "signal_window", signalWindow);
        }

        PolygonStockResponse response = restTemplate.getForObject(apiUrl, PolygonStockResponse.class);
        return response;
    }
}
