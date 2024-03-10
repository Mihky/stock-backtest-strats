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
    /**
     * JSON Object Response
     *
     * V2 Endpoints
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

    /**
     * JSON Object Response
     *
     * V3 Endpoints
     *
     * Fields (some are already defined above):
     * - count (Integer): The total number of results for this request.
     * - next_url (String): If present, this value can be used to fetch the next page of data.
     * - request_id (String): A request id assigned by the server.
     * - results (Array): An array of tickers that match your query.
     *      - active (Boolean): Whether the asset is actively traded. False means the asset has been delisted.
     *      - cik (String): The CIK number for this ticker.
     *      - composite_figi (String): The composite OpenFIGI number for this ticker.
     *      - currency_name (String): The name of the currency that this asset is traded with.
     *      - delisted_utc (String): The last date that the asset was traded.
     *      - last_updated_utc (String): The information is accurate up to this time.
     *      - locale* (String): The locale of the asset. Possible values: [us, global]
     *      - market* (String): The market type of the asset. Possible values: [stocks, crypto, fx, otc, indices]
     *      - name* (String): The name of the asset.
     *      - primary_exchange (String): The ISO code of the primary listing exchange for this asset.
     *      - share_class_figi (String): The share Class OpenFIGI number for this ticker.
     *      - ticker (String): The exchange symbol that this item is traded under.
     *      - type (String): The type of the asset.
     * - status (String): The status of this request's response.
     */
    public static final String COUNT_KEY = "count";
    public static final String ACTIVE_KEY = "active";
    public static final String CIK_KEY = "cik";
    public static final String COMPOSITE_FIGI_KEY = "composite_figi";
    public static final String CURRENCY_NAME_KEY = "currency_name";
    public static final String DELISTED_UTC_KEY = "delisted_utc";
    public static final String LAST_UPDATED_KEY = "last_updated_utc";
    public static final String LOCALE_KEY = "locale";
    public static final String MARKET_KEY = "market";
    public static final String NAME_KEY = "NAME";
    public static final String PRIMARY_EXCHANGE_KEY = "primary_exchange";
    public static final String SHARE_CLASS_FIGI_KEY = "share_class_figi";
    public static final String TYPE_KEY = "type";


    // Default endpoint values
    public static final String DEFAULT_ASSET_TYPE = "CS";
    public static final String DEFAULT_MARKET_TYPE = "stocks";
    public static final String DEFAULT_LIMIT_COUNT = "1000";
}
