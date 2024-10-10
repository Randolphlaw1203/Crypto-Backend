package coingecko.coingecko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import coingecko.coingecko.infra.BcUtil;
import coingecko.coingecko.infra.Scheme;
import coingecko.coingecko.model.HistoricalChart;
import coingecko.coingecko.model.SingleCoin;
import coingecko.coingecko.service.SingleCoinService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SingleCoinServiceHolder implements SingleCoinService {

  @Value("${api.coingecko.domain}")
  private String domain;

  @Value("${api.coingecko.version}")
  private String version;

  @Value("${api.coingecko.endpoints.key}")
  private String key;

  @Value("${api.coingecko.endpoints.coins}")
  private String coins;

  @Value("${api.coingecko.endpoints.marketChart}")
  private String marketChart;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public SingleCoin getSingleCoin(String id) throws RestClientException {

    String url =
        BcUtil.getUrlCoin(Scheme.HTTPS, domain, version, coins, id, key);
    // System.out.println("getSingleCoin : " + url);
    SingleCoin singleCoin = restTemplate.getForObject(url, SingleCoin.class);

    return singleCoin;
  }

  @Override
  public HistoricalChart historicalChart(String id, String currency,
      String days) throws RestClientException {

    String url = BcUtil.getUrlHistoricalChart(Scheme.HTTPS, domain, version,
        coins, id, marketChart, currency, days, key);
    // System.out.println("historicalChart : " + url);
    HistoricalChart historicalChart =
        restTemplate.getForObject(url, HistoricalChart.class);

    return historicalChart;
  }

}
