package coingecko.coingecko.model;

import java.time.LocalDateTime;
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
public class Coins {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private double currentPrice;
  @JsonProperty("market_cap")
  private long marketCap;
  @JsonProperty("market_cap_rank")
  private int marketCapRank;
  @JsonProperty("fully_diluted_valuation")
  private long fullyDilutedValuation;
  @JsonProperty("total_volume")
  private long totalVolume;
  @JsonProperty("high_24h")
  private double high24h;
  @JsonProperty("low_24h")
  private double low24h;
  @JsonProperty("price_change_24h")
  private double priceChange24h;
  @JsonProperty("price_change_percentage_24h")
  private double priceChangePercentage24h;
  @JsonProperty("market_cap_change_24h")
  private long marketCapChange24h;
  @JsonProperty("market_cap_change_percentage_24h")
  private double marketCapChangePercentage24h;
  @JsonProperty("circulating_supply")
  private double circulatingSupply;
  @JsonProperty("total_supply")
  private double totalSupply;
  @JsonProperty("max_supply")
  private Object maxSupply;
  private double ath;
  @JsonProperty("ath_change_percentage")
  private double athChangePercentage;
  @JsonProperty("ath_date")
  private LocalDateTime athDate;
  private double atl;
  @JsonProperty("atl_change_percentage")
  private double atlChangePercentage;
  @JsonProperty("atl_date")
  private LocalDateTime atlDate;
  private Roi roi;
  @JsonProperty("last_updated")
  private LocalDateTime lastUpdated;

  @Getter
  @Setter
  @Builder
  public static class Roi {
    private double times;
    private String currency;
    private double percentage;
  }

}
