package events;

public final class EventType<P> {
    private final String name;
    private final Class<P> payloadType;

    public EventType(String name, Class<P> payloadType){
        this.name = name;
        this.payloadType = payloadType;
    }
    public String getName() {
        return name;
    }
    public Class<P> getPayloadType() {
        return payloadType;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EventType<?>)) {
            return false;
        }
        return this.name.equals(((EventType<?>) obj).name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    }