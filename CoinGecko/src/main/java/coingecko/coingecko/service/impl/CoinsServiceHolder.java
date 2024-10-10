package coingecko.coingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import coingecko.coingecko.infra.BcUtil;
import coingecko.coingecko.infra.Scheme;
import coingecko.coingecko.model.Coins;
import coingecko.coingecko.service.CoinsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CoinsServiceHolder implements CoinsService {

  @Value("${api.coingecko.domain}")
  private String domain;

  @Value("${api.coingecko.version}")
  private String version;

  @Value("${api.coingecko.endpoints.markets}")
  private String markets;

  @Value("${api.coingecko.endpoints.currency}")
  private String currency;

  @Value("${api.coingecko.endpoints.order}")
  private String order;

  @Value("${api.coingecko.endpoints.per_page}")
  private String per_page;

  @Value("${api.coingecko.endpoints.page}")
  private String page;

  @Value("${api.coingecko.endpoints.sparkline}")
  private String sparkline;

  @Value("${api.coingecko.endpoints.price_change_percentage}")
  private String price_change_percentage;

  @Value("${api.coingecko.endpoints.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coins> getCoins(String currency, String order, String per_page,
      String page, String sparkline, String price_change_percentage)
      throws RestClientException {

    String url = BcUtil.getUrl(Scheme.HTTPS, domain, version, markets, currency,
        order, per_page, page, sparkline, price_change_percentage, key);
    // System.out.println("getCoins : " + url);
    Coins[] coins = restTemplate.getForObject(url, Coins[].class);

    // array -> list
    return Arrays.stream(coins).collect(Collectors.toList());
  }



}

