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
import coingecko.coingecko.model.Currencies;
import coingecko.coingecko.service.CurrenciesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurrenciesServiceHolder implements CurrenciesService {

  @Value("${api.coingecko.domain}")
  private String domain;

  @Value("${api.coingecko.version}")
  private String version;

  @Value("${api.coingecko.endpoints.simple}")
  private String simple;

  @Value("${api.coingecko.endpoints.supportedCurrencies}")
  private String supportedCurrencies;

  @Value("${api.coingecko.endpoints.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Currencies> getCurrencies() throws RestClientException {

    String url = BcUtil.getUrlCurr(Scheme.HTTPS, domain, version, simple,
        supportedCurrencies, key);
    // System.out.println("getCurrencies : " + url);
    Currencies[] currencies =
        restTemplate.getForObject(url, Currencies[].class);

    // array -> list
    return Arrays.stream(currencies).collect(Collectors.toList());
  }

}

