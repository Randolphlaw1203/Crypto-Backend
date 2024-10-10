package coingecko.coingecko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class SingleCoinResp {

  private String id;
  private String symbol;
  private String name;
  private Image image;
  private int marketCapRank;
  private Description description;
  private MarketData marketData;

  @Getter
  @Setter
  @Builder
  public static class Image {
    private String thumb;
    private String small;
    private String large;
  }

  @Getter
  @Setter
  @Builder
  public static class MarketData {
    private CurrentPrice currentPrice;
    private MarketCap marketCap;

    @Getter
    @Setter
    @Builder
    public static class CurrentPrice {
      private String usd;
      private String hkd;
    }

    @Getter
    @Setter
    @Builder
    public static class MarketCap {
      private String usd;
      private String hkd;
    }
  }

  @Getter
  @Setter
  @Builder
  public static class Description {
    private String en;
    private String de;
  }

}
