package finnhub.finnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import finnhub.finnhub.model.Profile2;

public interface Profile2Operation {
  @GetMapping(value = "/profile2")
  Profile2 getProfile2Response(
      @RequestParam(value = "symbol", required = false) String symbol);
}
