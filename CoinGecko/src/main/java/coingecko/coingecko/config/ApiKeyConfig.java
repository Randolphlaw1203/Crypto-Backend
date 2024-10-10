package coingecko.coingecko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:key.txt")
@Component
public class ApiKeyConfig {

    @Value("${your.api.key.property:defaultKey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
