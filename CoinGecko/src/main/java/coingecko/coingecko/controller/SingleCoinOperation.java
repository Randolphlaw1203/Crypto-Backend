package coingecko.coingecko.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import coingecko.coingecko.model.HistoricalChartResp;
import coingecko.coingecko.model.SingleCoinResp;

public interface SingleCoinOperation {

        @GetMapping(value = "/coin/{id}")
        SingleCoinResp getSingleCoin(
                        @PathVariable(value = "id", required = true) String id);

        @GetMapping(value = "/coin/{id}/market_chart")
        Map<String, List<HistoricalChartResp>> getHistoricalChart(
                        @PathVariable(value = "id", required = true) String id,
                        @RequestParam(value = "currency",
                                        required = true) String currency,
                        @RequestParam(value = "days",
                                        required = true) String days);
}
