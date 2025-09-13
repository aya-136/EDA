package events;

import java.util.UUID;

public final class Event<P> {
    private final EventType<P> type;
    private final String id ;
    private final P payload;
    private final long timestamp;

    public Event(final EventType<P> type, final String id, final P payload, final long timestamp) {
        this.type = type;
        this.id = id;
        this.payload = payload;
        this.timestamp = timestamp;
    }
    public final EventType<P> getType() {
        return this.type;
    }
    public final String getId() {
        return id;
    }
    public final P getPayload() {
        return payload;
    }
    public final long getTimestamp() {
        return timestamp;
    }
    public static <P> Event<P> of(EventType<P> type, P payload){
        return new Event<>(type, UUID.randomUUID().toString(), payload, System.currentTimeMillis());
    }

}
