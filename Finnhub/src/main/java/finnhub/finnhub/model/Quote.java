package finnhub.finnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Quote {

  private double c;
  private double d;
  private double dp;
  private double h;
  private double l;
  private double o;
  private double pc;
  private long t;


}
