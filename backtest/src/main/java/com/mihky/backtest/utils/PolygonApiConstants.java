package com.mihky.backtest.utils;

public class PolygonApiConstants {
    public static final String POLYGON_BASE_URL = "https://api.polygon.io/";
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

    // Response Attributes
    /**
     * JSON Object Response
     * - ticker* (String): The exchange symbol that this item is traded under.
     * - adjusted* (boolean): Whether this response was adjusted for splits.
     * - queryCount* (int): The number of aggregates (minute or day) used to generate the response.
     * - request_id* (String): A request id assigned by the server.
     * - resultsCount* (int): The total number of results for this request.
     * - status* (String): The status of this request's response.
     * - results (array):
     *      - c* (number): The close price for the symbol in the given time period.
     *      - h* (number): The highest price for the symbol in the given time period.
     *      - l* (number): The lowest price for the symbol in the given time period.
     *      - n (integer): The number of transactions in the aggregate window.
     *      - o* (number): The open price for the symbol in the given time period.
     *      - otc (boolean): Indicates whether this aggregate is for an OTC ticker. This field will be omitted if false.
     *      - t* (integer): The Unix Msec timestamp for the start of the aggregate window.
     *      - v* (number): The trading volume of the symbol in the given time period.
     *      - vw (number): The volume weighted average price.
     * - next_url (String): If present, this value can be used to fetch the next page of data.
     * */
    public static final String TICKER_KEY = "ticker";
    public static final String ADJUSTED_KEY = "adjusted";
    public static final String QUERY_COUNT_KEY = "queryCount";
    public static final String REQUEST_ID_KEY = "request_id";
    public static final String RESULTS_COUNT_KEY = "resultsCount";
    public static final String STATUS_KEY = "status";
    public static final String RESULTS_KEY = "results";
    public static final String CLOSE_PRICE_KEY = "c";
    public static final String HIGH_PRICE_KEY = "h";
    public static final String LOW_PRICE_KEY = "l";
    public static final String NUM_TRANSACTIONS_KEY = "n";
    public static final String OPEN_PRICE_KEY = "o";
    public static final String OTC_TICKER_KEY = "otc";
    public static final String TIMESTAMP_KEY = "t";
    public static final String TRADING_VOLUME_KEY = "v";
    public static final String VOLUME_WEIGHTED_AVERAGE_PRICE_KEY = "vw";
    public static final String NEXT_URL_KEY = "next_url";
}
