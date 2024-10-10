package coingecko.coingecko.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import coingecko.coingecko.controller.SingleCoinOperation;
import coingecko.coingecko.model.HistoricalChart;
import coingecko.coingecko.model.HistoricalChartResp;
import coingecko.coingecko.model.Mapper;
import coingecko.coingecko.model.SingleCoin;
import coingecko.coingecko.model.SingleCoinResp;
import coingecko.coingecko.service.SingleCoinService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class SingleCoinController implements SingleCoinOperation {

  @Autowired
  private SingleCoinService singleCoinService;

  @Autowired
  private Mapper mapper;

  @Override
  public SingleCoinResp getSingleCoin(String id) {
    SingleCoin singleCoin = singleCoinService.getSingleCoin(id);
    return mapper.map(singleCoin);
  }

  @Override
  public Map<String, List<HistoricalChartResp>> getHistoricalChart(String id,
      String currency, String days) {
    HistoricalChart historicalChart =
        singleCoinService.historicalChart(id, currency, days);
    List<HistoricalChartResp> priceList = mapper.map(historicalChart);

    Map<String, List<HistoricalChartResp>> response = new HashMap<>();
    response.put("prices", priceList);

    return response;
  }

}
