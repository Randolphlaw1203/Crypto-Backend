package coingecko.coingecko.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd
  // &order=market_cap_desc&per_page=1&page=10&sparkline=false&price_change_percentage=24h
  // &x_cg_demo_api_key=CG
  public static String getUrl(Scheme scheme, String domain, String version,
      String markets, String currency, String order, String per_page,
      String page, String sparkline, String price_change_percentage,
      String key) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(markets)//
        .replaceQueryParam("vs_currency", currency)//
        .replaceQueryParam("order", order)//
        .replaceQueryParam("per_page", per_page)//
        .replaceQueryParam("page", page)//
        .replaceQueryParam("sparkline", sparkline)//
        .replaceQueryParam("price_change_percentage", price_change_percentage)//
        .replaceQueryParam("x_cg_demo_api_key", key)//
        .build(false)//
        .toUriString();
  }

  // https://api.coingecko.com/api/v3/simple/supported_vs_currencies?
  // x_cg_demo_api_key=CG
  public static String getUrlCurr(Scheme scheme, String domain, String version,
      String simple, String supportedCurrencies, String key) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(simple)//
        .path(supportedCurrencies)//
        .replaceQueryParam("x_cg_demo_api_key", key)//
        .build(false)//
        .toUriString();
  }

  // https://api.coingecko.com/api/v3/coins/bitcoin?x_cg_demo_api_key=CG
  public static String getUrlCoin(Scheme scheme, String domain, String version,
      String coins, String id, String key) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(coins)//
        .pathSegment(id)//
        .replaceQueryParam("x_cg_demo_api_key", key)//
        .build(false)//
        .toUriString();
  }

  // https://api.coingecko.com/api/v3/coins/bitcoin//market_chart?vs_currency=usd
  // &days=365&x_cg_demo_api_key=CG
  public static String getUrlHistoricalChart(Scheme scheme, String domain,
      String version, String coins, String id, String marketChart,
      String currency, String days, String key) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.toLowerCase())//
        .host(domain)//
        .path(version)//
        .path(coins)//
        .pathSegment(id)//
        .path(marketChart)//
        .replaceQueryParam("vs_currency", currency)//
        .replaceQueryParam("days", days)//
        .replaceQueryParam("x_cg_demo_api_key", key)//
        .build(false)//
        .toUriString();
  }


}
