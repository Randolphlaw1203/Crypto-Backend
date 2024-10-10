package coingecko.coingecko.service;

import coingecko.coingecko.model.HistoricalChart;
import coingecko.coingecko.model.SingleCoin;

public interface SingleCoinService {
  SingleCoin getSingleCoin(String id);

  HistoricalChart historicalChart(String id, String currency, String days);
}
