package link.honeycombpizza.stomptester.builders;

public enum WebSocketScheme {
    WS("ws"),
    WSS("wss");

    private final String scheme;

    WebSocketScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getScheme() {
        return scheme;
    }
}
