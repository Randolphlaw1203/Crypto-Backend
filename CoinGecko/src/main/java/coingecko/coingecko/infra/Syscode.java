package coingecko.coingecko.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Syscode {
  OK("000000", "OK."), //
  NOTFOUND("000001", "Resource Not Found."), //
  REST_CLIENT_EXCEPTION("900001", "RestClientException."), //
  NULL_POINTER_EXCEPTION("900002", "NPE."), //
  GENERAL_EXCEPTION("999999", "Unhandled Other Exceptions."), //
  ;

  private String code;
  private String message;

}
