package finnhub.finnhub.service;

import finnhub.finnhub.model.Quote;

public interface QuoteService {

  public Quote getQuote(String symbol);

}
