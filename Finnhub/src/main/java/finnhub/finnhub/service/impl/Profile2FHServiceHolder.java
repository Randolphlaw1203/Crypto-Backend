package finnhub.finnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import finnhub.finnhub.infra.BcUtil;
import finnhub.finnhub.infra.Scheme;
import finnhub.finnhub.model.Profile2;
import finnhub.finnhub.service.Profile2Service;

@Service
public class Profile2FHServiceHolder implements Profile2Service {
  @Value("${api.finnhub.domain}")
  private String domain;

  @Value("${api.finnhub.version}")
  private String version;

  @Value("${api.finnhub.endpoints.stock}")
  private String stock;

  @Value("${api.finnhub.endpoints.profile2}")
  private String profile2;

  @Value("${api.finnhub.endpoints.token}")
  private String token;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public Profile2 getProfile2(String symbol) throws RestClientException {

    String url = BcUtil.getUrlProfile2(Scheme.HTTPS, domain, version, stock,
        profile2, symbol, token);
    // System.out.println("url : " + url);
    Profile2 profile2 = restTemplate.getForObject(url, Profile2.class);

    // array -> list
    // return Arrays.stream(quote).collect(Collectors.toList());
    return profile2;
  }

}

