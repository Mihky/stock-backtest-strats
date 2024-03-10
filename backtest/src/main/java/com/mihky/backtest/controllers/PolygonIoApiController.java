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
import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_LIMIT_COUNT;
import static com.mihky.backtest.utils.PolygonApiConstants.DEFAULT_MARKET_TYPE;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_AGGREGATE_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_GROUPED_DAILY_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_TICKERS_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.PAGINATION_TEMPLATE;
import static com.mihky.backtest.utils.PolygonApiConstants.POLYGON_BASE_URL;

@RestController
@RequestMapping("/api")
public class PolygonIoApiController {
    private final RestTemplate restTemplate;

    public PolygonIoApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // https://api.polygon.io/v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}?apiKey={apiKey}
    @GetMapping("/aggregates")
    public PolygonStockResponse getAggregates(
            @RequestParam(value = "stocksTicker") String stocksTicker,
            @RequestParam(value = "multiplier") int multiplier,
            @RequestParam(value = "timespan") String granularity,
            @RequestParam(value = "from") String from,
            @RequestParam(value = "to") String to,
            @RequestParam(value = "apiKey") String apiKey) {
        String apiUrl = POLYGON_BASE_URL + String.format(
                GET_AGGREGATE_ENDPOINT, stocksTicker, multiplier, granularity, from, to, apiKey);
        PolygonStockResponse response = restTemplate.getForObject(apiUrl, PolygonStockResponse.class);
        return response;
    }

    // https://api.polygon.io/v2/aggs/grouped/locale/us/market/stocks/{date}?apiKey={apiKey}
    @GetMapping("/grouped")
    public PolygonStockResponse getGrouped(
            @RequestParam(value = "date") String date,
            @RequestParam(value = "apiKey") String apiKey) {
        String apiUrl = POLYGON_BASE_URL + String.format(GET_GROUPED_DAILY_ENDPOINT, date, apiKey);
        PolygonStockResponse response = restTemplate.getForObject(apiUrl, PolygonStockResponse.class);
        return response;
    }

    // https://api.polygon.io/v3/reference/tickers?type={type}&market={market}&exchange={ISO_code}&limit={limit}&apiKey={apiKey}
    @GetMapping("/get_stock_list")
    public Collection<PolygonTickerResponse> getStockList(
            @RequestParam(value = "mic") String mic,
            @RequestParam(value = "apiKey") String apiKey,
            @RequestParam(value = "type", defaultValue = DEFAULT_ASSET_TYPE) String type,
            @RequestParam(value = "market", defaultValue = DEFAULT_MARKET_TYPE) String market,
            @RequestParam(value = "limit", defaultValue = DEFAULT_LIMIT_COUNT) String limit) {
        Collection<PolygonTickerResponse> tickerResponses = new ArrayList<>();
        String apiUrl = POLYGON_BASE_URL + String.format(GET_TICKERS_ENDPOINT, type, market, mic, limit, apiKey);
        PolygonTickerResponse response = restTemplate.getForObject(apiUrl, PolygonTickerResponse.class);
        tickerResponses.add(response);

        // We need to paginate through all the next_url links to fetch the full list of stocks
        while (!StringUtils.isEmpty(response.getNextUrl())) {
            String nextApiUrl = String.format(PAGINATION_TEMPLATE, response.getNextUrl(), apiKey);
            response = restTemplate.getForObject(nextApiUrl, PolygonTickerResponse.class);
            tickerResponses.add(response);
        }

        return tickerResponses;
    }

    @GetMapping("/health_check")
    public String getPing() {
        return "Hi, I'm healthy..";
    }
}
