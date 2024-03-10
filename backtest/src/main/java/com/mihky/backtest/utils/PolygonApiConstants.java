package com.mihky.backtest.utils;

public class PolygonApiConstants {
    public static final String POLYGON_BASE_URL = "https://api.polygon.io/";

    // Technical Indicator Endpoints
    public static String GET_TECHNICAL_INDICATOR_ENDPOINT = "/v1/indicators/%s/%s?timespan=%s&window=%s&series_type=%s&limit=%s&apiKey=%s";

    // Market Data Endpoints
    /**
     * Fetches aggregated stock data within a timeseries. (1 stock, broken by time windows)
     *
     * Template: /v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}?apiKey={apiKey}
     * API Doc: https://polygon.io/docs/stocks/get_v2_aggs_ticker__stocksticker__range__multiplier___timespan___from___to
     *
     * @param stocksTicker Specify a case-sensitive ticker symbol. (i.e.: AAPL==Apple Inc.)
     * @param multiplier The size of the timespan multiplier. (i.e.: 1 day, 5 minute, 6 hour)
     * @param timespan The size of the time window. (i.e.: day)
     * @param from The start of the aggregate time window. Either a date with the format YYYY-MM-DD or a millisecond timestamp.
     * @param to The end of the aggregate time window. Either a date with the format YYYY-MM-DD or a millisecond timestamp.
     * @param apiKey API Key associated with the auth user using Polygon.io
     * */
    public static String GET_AGGREGATE_ENDPOINT = "/v2/aggs/ticker/%s/range/%s/%s/%s/%s?apiKey=%s";

    /**
     * Fetches grouped daily stock data for a specific day. (all stocks, 1 day)
     *
     * Template: /v2/aggs/grouped/locale/us/market/stocks/{date}
     * API Doc: https://polygon.io/docs/stocks/get_v2_aggs_grouped_locale_us_market_stocks__date
     *
     * @param date The beginning date for the aggregate window. A date with the format YYYY-MM-DD.
     * @param apiKey API Key associated with the auth user using Polygon.io
     * */
    public static String GET_GROUPED_DAILY_ENDPOINT = "/v2/aggs/grouped/locale/us/market/stocks/%s?apiKey=%s";

    /**
     * Fetches all assets information.
     *
     * Template: /v3/reference/tickers?type={type}&market={market}&exchange={ISO_code}&limit={limit}&apiKey={apiKey}
     * API Doc: https://polygon.io/docs/stocks/get_v3_reference_tickers
     *
     * @param type Asset type. We will only be studying Common Stocks (CS) as default.
     * @param market Market type. We will only be studying 'stocks' as default. ('crypto' for bitcoin would be interesting)
     * @param exchange Market Identifier Code. Stick to XNYS (NYSE) and XNAS (NASDAQ)
     * @param limit Max count of response entries each response can hold.
     * @param apiKey API Key associated with the auth user using Polygon.io
     * */
    public static String GET_TICKERS_ENDPOINT = "/v3/reference/tickers?type=%s&market=%s&exchange=%s&limit=%s&apiKey=%s";
    // {next_url}&apiKey={apiKey}
    public static String PAGINATION_TEMPLATE = "%s&apiKey=%s";

    // Response Attributes
    public static final String ACTIVE_KEY = "active";
    public static final String ADJUSTED_KEY = "adjusted";
    public static final String AGGREGATES_KEY = "aggregates";
    public static final String CIK_KEY = "cik";
    public static final String CLOSE_PRICE_KEY = "c";
    public static final String COMPOSITE_FIGI_KEY = "composite_figi";
    public static final String COUNT_KEY = "count";
    public static final String CURRENCY_NAME_KEY = "currency_name";
    public static final String DELISTED_UTC_KEY = "delisted_utc";
    public static final String HIGH_PRICE_KEY = "h";
    public static final String HISTOGRAM_KEY = "histogram";
    public static final String LAST_UPDATED_KEY = "last_updated_utc";
    public static final String LOCALE_KEY = "locale";
    public static final String LOW_PRICE_KEY = "l";
    public static final String MARKET_KEY = "market";
    public static final String NAME_KEY = "NAME";
    public static final String NEXT_URL_KEY = "next_url";
    public static final String NUM_TRANSACTIONS_KEY = "n";
    public static final String OPEN_PRICE_KEY = "o";
    public static final String OTC_TICKER_KEY = "otc";
    public static final String PRIMARY_EXCHANGE_KEY = "primary_exchange";
    public static final String QUERY_COUNT_KEY = "queryCount";
    public static final String REQUEST_ID_KEY = "request_id";
    public static final String RESULTS_COUNT_KEY = "resultsCount";
    public static final String RESULTS_KEY = "results";
    public static final String SHARE_CLASS_FIGI_KEY = "share_class_figi";
    public static final String SIGNAL_KEY = "signal";
    public static final String STATUS_KEY = "status";
    public static final String TICKER_KEY = "ticker";
    public static final String TIMESTAMP_KEY = "t";
    public static final String TIMESTAMP_TI_KEY = "timestamp";
    public static final String TRADING_VOLUME_KEY = "v";
    public static final String TYPE_KEY = "type";
    public static final String UNDERLYING_KEY = "underlying";
    public static final String URL_KEY = "url";
    public static final String VALUES_KEY = "values";
    public static final String VALUE_KEY = "value";
    public static final String VOLUME_WEIGHTED_AVERAGE_PRICE_KEY = "vw";

    // Default endpoint values
    public static final String DEFAULT_ASSET_TYPE = "CS";
    public static final String DEFAULT_MARKET_TYPE = "stocks";
    public static final String DEFAULT_LIMIT_COUNT = "1000";
    public static final String DEFAULT_INDICATOR_LIMIT_COUNT = "5000";

    public static String addAdditionalParameter(String endpoint, String key, String value) {
        return String.format("%s&%s=%s", endpoint, key, value);
    }
}
