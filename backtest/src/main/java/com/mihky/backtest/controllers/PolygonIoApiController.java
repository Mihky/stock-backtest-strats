package com.mihky.backtest.controllers;

import com.mihky.backtest.data.PolygonStockResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.mihky.backtest.utils.PolygonApiConstants.GET_AGGREGATE_ENDPOINT;
import static com.mihky.backtest.utils.PolygonApiConstants.GET_GROUPED_DAILY_ENDPOINT;
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
            @RequestParam(value = "multiplier") String multiplier,
            @RequestParam(value = "timespan") String timespan,
            @RequestParam(value = "from") String from,
            @RequestParam(value = "to") String to,
            @RequestParam(value = "apiKey") String apiKey) {
        String apiUrl = POLYGON_BASE_URL + String.format(
                GET_AGGREGATE_ENDPOINT, stocksTicker, multiplier, timespan, from, to, apiKey);
        PolygonStockResponse response = restTemplate.getForObject(apiUrl, PolygonStockResponse.class);
        return response;
    }

    // https://api.polygon.io/v2/aggs/grouped/locale/us/market/stocks/{date}
    @GetMapping("/grouped")
    public PolygonStockResponse getGrouped(@RequestParam(value = "date") String date) {
        String apiUrl = POLYGON_BASE_URL + String.format(GET_GROUPED_DAILY_ENDPOINT, date);
        PolygonStockResponse response = restTemplate.getForObject(apiUrl, PolygonStockResponse.class);
        return response;
    }
}
