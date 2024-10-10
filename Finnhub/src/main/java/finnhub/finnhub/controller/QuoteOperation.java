package finnhub.finnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import finnhub.finnhub.model.Quote;

public interface QuoteOperation {

  @GetMapping(value = "/quote")
  Quote getQuoteResponse(
      @RequestParam(value = "symbol", required = false) String symbol);

}
