package finnhub.finnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import finnhub.finnhub.controller.Profile2Operation;
import finnhub.finnhub.model.Profile2;
import finnhub.finnhub.service.Profile2Service;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class Profile2Controller implements Profile2Operation {

  @Autowired
  private Profile2Service profile2Service;

  @Override
  public Profile2 getProfile2Response(String symbol) {

    return profile2Service.getProfile2(symbol);

  }
}
