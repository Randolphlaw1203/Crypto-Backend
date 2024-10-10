package finnhub.finnhub.infra;

public enum Scheme {
  HTTPS, HTTP, WSS;

  public String toLowerCase() {
    return this.name().toLowerCase(); // https or http
  }
}
