package coingecko.coingecko.service;

import java.util.List;
import coingecko.coingecko.model.Currencies;

public interface CurrenciesService {
  List<Currencies> getCurrencies();
}
