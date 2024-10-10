package finnhub.finnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import finnhub.finnhub.controller.QuoteOperation;
import finnhub.finnhub.model.Quote;
import finnhub.finnhub.service.QuoteService;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class QuoteController implements QuoteOperation {

  @Autowired
  private QuoteService quoteService;

  @Override
  public Quote getQuoteResponse(String symbol) {

    return quoteService.getQuote(symbol);
  }
}
