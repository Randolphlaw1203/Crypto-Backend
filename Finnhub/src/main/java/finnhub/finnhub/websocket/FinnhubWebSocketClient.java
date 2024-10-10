package finnhub.finnhub.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import java.net.URI;

public class FinnhubWebSocketClient extends WebSocketClient {

    private WebSocketSession session;
    private String symbolToSubscribe;

    public FinnhubWebSocketClient(URI serverUri, WebSocketSession session) {
        super(serverUri);
        this.session = session;
    }

    public void connectAndSubscribe(String message) {
        this.symbolToSubscribe = message;
        connect();
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to Finnhub");
        send(symbolToSubscribe);
    }

    @Override
    public void onMessage(String message) {
        try {
            session.sendMessage(new TextMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
