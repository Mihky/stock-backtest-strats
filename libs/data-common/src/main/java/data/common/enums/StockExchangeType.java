package data.common.enums;

/**
 * Background: https://carpenterwellington.com/post/nyse-nasdaq-key-similarities-differences/#:~:text=The%20NYSE%20is%20known%20for,companies%20listed%20on%20the%20NYSE.
 * "The NYSE is known for listing the stock of traditional blue chip and industrial companies.
 * The NASDAQ is home to a number of Internet, biotechnology, and other companies in growth-oriented sectors.
 * As a result, stocks on the NASDAQ have higher volatility.
 * Currently, there are around 2,800 companies listed on the NYSE.
 * There are around 3,300 companies listed on NASDAQ."
 * */
public enum StockExchangeType {
    NASDAQ("NASDAQ", "XNAS"),
    NYSE("NYSE", "XNYS");

    private final String name;
    private final String mic;

    StockExchangeType(String name, String mic) {
        this.name = name;
        this.mic = mic;
    }

    public String getName() {
        return this.name;
    }

    public String getMic() {
        return this.mic;
    }
}
