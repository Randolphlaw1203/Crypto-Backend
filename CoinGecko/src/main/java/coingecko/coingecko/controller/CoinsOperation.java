package coingecko.coingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import coingecko.coingecko.model.CoinsResp;

public interface CoinsOperation {
  @GetMapping(value = "/coins")
  List<CoinsResp> getCoins(
      @RequestParam(value = "currency", required = true) String currency,
      @RequestParam(value = "order", required = false) String order,
      @RequestParam(value = "per_page", required = false) String per_page,
      @RequestParam(value = "page", required = false) String page,
      @RequestParam(value = "sparkline", required = false) String sparkline,
      @RequestParam(value = "price_change_percentage",
          required = false) String price_change_percentage);

}
