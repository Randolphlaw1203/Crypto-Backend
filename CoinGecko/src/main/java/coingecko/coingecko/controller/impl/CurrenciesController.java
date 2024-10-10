package coingecko.coingecko.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import coingecko.coingecko.controller.CurrenciesOperation;
import coingecko.coingecko.model.Currencies;
import coingecko.coingecko.service.CurrenciesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CurrenciesController implements CurrenciesOperation {

  @Autowired
  private CurrenciesService currenciesService;

  @Override
  public List<Currencies> getCurrencies() {

    return currenciesService.getCurrencies();
  }
}
