package events;

@FunctionalInterface
public interface Subscriber<P> {
    void onEvent(Event<P> e) throws Exception;

    default String name() {
        return getClass().getSimpleName();
    }

}
