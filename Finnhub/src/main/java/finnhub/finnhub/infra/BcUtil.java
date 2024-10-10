package finnhub.finnhub.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
  public static String getUrl(Scheme scheme, String domain, String version,
      String quote, String symbol, String token) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(quote)//
        .replaceQueryParam("symbol", symbol)//
        .replaceQueryParam("token", token)//
        .build(false)//
        .toUriString();
  }

  public static String getUrlProfile2(Scheme scheme, String domain,
      String version, String stock, String profile2, String symbol,
      String token) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(stock)//
        .path(profile2)//
        .replaceQueryParam("symbol", symbol)//
        .replaceQueryParam("token", token)//
        .build(false)//
        .toUriString();
  }

  public static String getWssTrades(Scheme scheme, String domain,
      String token) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .replaceQueryParam("token", token)//
        .build(false)//
        .toUriString();
  }

}
