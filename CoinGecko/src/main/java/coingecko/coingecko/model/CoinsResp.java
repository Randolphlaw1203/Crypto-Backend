package coingecko.coingecko.model;

import java.time.LocalDateTime;
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
public class CoinsResp {

  private String id;
  private String symbol;
  private String name;
  private String image;
  private double currentPrice;
  private long marketCap;
  private int marketCapRank;
  private long fullyDilutedValuation;
  private long totalVolume;
  private double high24h;
  private double low24h;
  private double priceChange24h;
  private double priceChangePercentage24h;
  private long marketCapChange24h;
  private double marketCapChangePercentage24h;
  private double circulatingSupply;
  private double totalSupply;
  private Object maxSupply;
  private double ath;
  private double athChangePercentage;
  private LocalDateTime athDate;
  private double atl;
  private double atlChangePercentage;
  private LocalDateTime atlDate;
  private Roi roi;
  private LocalDateTime lastUpdated;

  @Builder
  @Getter
  @Setter
  public static class Roi {
    private double times;
    private String currency;
    private double percentage;
  }
}

