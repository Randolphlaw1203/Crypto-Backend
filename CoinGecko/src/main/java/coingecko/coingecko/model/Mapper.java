package coingecko.coingecko.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

  public CoinsResp map(Coins coins) {

    CoinsResp builder = CoinsResp.builder()//
        .id(coins.getId())//
        .symbol(coins.getSymbol())//
        .name(coins.getName())//
        .image(coins.getImage())//
        .currentPrice(coins.getCurrentPrice())//
        .marketCap(coins.getMarketCap())//
        .marketCapRank(coins.getMarketCapRank())//
        .fullyDilutedValuation(coins.getFullyDilutedValuation())//
        .totalVolume(coins.getTotalVolume())//
        .high24h(coins.getHigh24h())//
        .low24h(coins.getLow24h())//
        .priceChange24h(coins.getPriceChange24h())//
        .priceChangePercentage24h(coins.getPriceChangePercentage24h())//
        .marketCapChange24h(coins.getMarketCapChange24h())//
        .marketCapChangePercentage24h(coins.getMarketCapChangePercentage24h())//
        .circulatingSupply(coins.getCirculatingSupply())//
        .totalSupply(coins.getTotalSupply())//
        .maxSupply(coins.getMaxSupply())//
        .ath(coins.getAth())//
        .athChangePercentage(coins.getAthChangePercentage())//
        .athDate(coins.getAthDate())//
        .atl(coins.getAtl())//
        .atlChangePercentage(coins.getAtlChangePercentage())//
        .atlDate(coins.getAtlDate())//
        .lastUpdated(coins.getLastUpdated())//
        .build();

    if (coins.getRoi() != null) {
      builder.setRoi(this.map(coins.getRoi()));
    }

    return builder;
  }

  public CoinsResp.Roi map(Coins.Roi roi) {
    return CoinsResp.Roi.builder()//
        .times(roi.getTimes())//
        .currency(roi.getCurrency())//
        .percentage(roi.getPercentage())//
        .build();
  }

  public SingleCoinResp map(SingleCoin singleCoin) {
    SingleCoinResp builder = SingleCoinResp.builder()//
        .id(singleCoin.getId())//
        .symbol(singleCoin.getSymbol())//
        .name(singleCoin.getName())//
        .image(this.map(singleCoin.getImage()))//
        .description(this.map(singleCoin.getDescription()))//
        .marketCapRank(singleCoin.getMarketCapRank())//
        .marketData(this.map(singleCoin.getMarketData()))//
        .build();
    return builder;
  }

  public SingleCoinResp.Image map(SingleCoin.Image image) {
    return SingleCoinResp.Image.builder()//
        .large(image.getLarge())//
        .thumb(image.getThumb())//
        .small(image.getSmall())//
        .build();
  }

  public SingleCoinResp.Description map(SingleCoin.Description description) {
    return SingleCoinResp.Description.builder()//
        .en(description.getEn())//
        .de(description.getDe())//
        .build();
  }

  public SingleCoinResp.MarketData map(SingleCoin.MarketData marketData) {
    return SingleCoinResp.MarketData.builder()//
        .currentPrice(SingleCoinResp.MarketData.CurrentPrice.builder()//
            .usd(marketData.getCurrentPrice().getUsd())
            .hkd(marketData.getCurrentPrice().getHkd())//
            .build())//
        .marketCap(SingleCoinResp.MarketData.MarketCap.builder()
            .usd(marketData.getMarketCap().getUsd())
            .hkd(marketData.getMarketCap().getHkd())//
            .build())
        .build();
  }

  public List<HistoricalChartResp> map(HistoricalChart historicalChart) {
    List<HistoricalChartResp> historicalChartResp = new ArrayList<>();

    for (List<Double> priceData : historicalChart.getPrices()) {
      HistoricalChartResp price = HistoricalChartResp.builder()//
          .timeStamp(BigDecimal.valueOf(priceData.get(0)))//
          .price(priceData.get(1))//
          .build();
      historicalChartResp.add(price);
    }
    return historicalChartResp;
  }
}


