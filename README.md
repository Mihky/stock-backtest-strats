# stock-backtest-strats

Backtesting different technical indicator trading strategies on popular/trending top traded NASDAQ/NYSE US common stocks.

Polygon.io provides API to read historical/real-time market data.
Strategies:
- Simple Moving Average (SMA). Generally good for longer term trend predictions (i.e.: 200 SMA)
- Exponential Moving Average (EMA). Generally good for shorter term trend predictions
- Source: https://www.quantifiedstrategies.com/simple-moving-average/#:~:text=Short%20vs.,56%25).
- MACD?
- RSI?

Need to study more and figure out best ways to test historical data to find best trends per stock.

This tool will be helpful for the data-driven, pessimistic, nooby, non-traders who want to invest in individual stocks, but don't want to invest time to learn to become dedicated day/swing traders.

MVP: backtest SMA trends on some popular stocks, maybe calculate some '% Effectiveness' or some '% Profit' numbers helpful for investing

Ideal world: Have a lot of backtested strategies that will provide users with a robo-investor bot that tells you:

"This 'X' strategy is Y% effective based on the previous Z years of historical data."

Everytime our systems run into market trends to buy, send notification: "Buy now expect to sell in A days for Y% yield"

Similar to when trends to sell, send notification: "Sell now (if you bought), stock price is trending down"
