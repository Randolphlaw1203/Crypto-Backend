package coingecko.coingecko.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import coingecko.coingecko.controller.CoinsOperation;
import coingecko.coingecko.model.CoinsResp;
import coingecko.coingecko.model.Mapper;
import coingecko.coingecko.service.CoinsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoinsController implements CoinsOperation {

  @Autowired
  private CoinsService coinsService;

  @Autowired
  private Mapper mapper;

  @Override
  public List<CoinsResp> getCoins(String currency, String order,
      String per_page, String page, String sparkline,
      String price_change_percentage) {
    List<CoinsResp> coins = coinsService
        .getCoins(currency, order, per_page, page, sparkline,
            price_change_percentage)
        .stream()//
        .map(e -> mapper.map(e))//
        .collect(Collectors.toList());

    return coins;
  }


}


