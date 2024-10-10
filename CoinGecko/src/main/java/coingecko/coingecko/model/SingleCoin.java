package coingecko.coingecko.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SingleCoin {
  private String id;
  private String symbol;
  private String name;
  private Image image;
  @JsonProperty("market_cap_rank")
  private int marketCapRank;
  private Description description;
  @JsonProperty("market_data")
  private MarketData marketData;

  @Getter
  @Setter
  @Builder
  public static class Description {
    private String en;
    private String de;
  }

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
    @JsonProperty("current_price")
    private CurrentPrice currentPrice;
    @JsonProperty("market_cap")
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

}
