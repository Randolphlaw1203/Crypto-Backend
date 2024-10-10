package coingecko.coingecko.service;

import java.util.List;
import coingecko.coingecko.model.Coins;

public interface CoinsService {

  List<Coins> getCoins(String currency, String order, String per_page,
      String page, String sparkline, String price_change_percentage);
}
