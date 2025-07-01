package link.honeycombpizza.stomptester;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

public class TypedStompFrameHandler<T> implements StompFrameHandler {
    private final Class<T> type;
    private final CompletableFuture<T> future;
    public TypedStompFrameHandler(Class<T> type, CompletableFuture<T> future) {
        this.type = type;
        this.future = future;
    }
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return this.type;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received payload: " + payload);
        if (type.isInstance(payload)) { // Use Class#isInstance for type safety
            T data = type.cast(payload); // Use Class#cast for safe casting
            future.complete(data);
        } else {
            throw new IllegalArgumentException("Unexpected payload type: " + payload.getClass());
        }
    }
}

