package coingecko.coingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import coingecko.coingecko.model.Currencies;

public interface CurrenciesOperation {
  @GetMapping(value = "/currencies")
  List<Currencies> getCurrencies();
}

