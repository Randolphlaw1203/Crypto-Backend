package finnhub.finnhub.websocket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.net.URI;
import finnhub.finnhub.config.ApiKeyConfig;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ApiKeyConfig apiKeyConfig;

    @Override
    protected void handleTextMessage(WebSocketSession session,
            TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);

        // Validate JSON structure before sending
        if (isValidMessage(payload)) {
            String apiKey = apiKeyConfig.getApiKey();
            URI uri = new URI("wss://ws.finnhub.io?token=" + apiKey);
            System.out.println("URL:" + uri);
            FinnhubWebSocketClient client =
                    new FinnhubWebSocketClient(uri, session);
            client.connectAndSubscribe(payload);
        } else {
            session.sendMessage(new TextMessage(
                    "{\"msg\":\"Malformed message\",\"type\":\"error\"}"));
        }
    }

    private boolean isValidMessage(String message) {
        // Basic validation logic, improve as needed
        return message.contains("\"type\":\"subscribe\"")
                && message.contains("\"symbol\":\"");
    }
}
