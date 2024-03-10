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
public class HealthCheckController {
    @GetMapping("/health_check")
    public String getPing() {
        return "Hi, I'm healthy..";
    }
}
