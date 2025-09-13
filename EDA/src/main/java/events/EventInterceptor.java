package events;

public interface EventInterceptor<P> {
    void beforePublish(Event<P> e);
    void beforeDispatch(Event<P> e, Subscriber<P> s);
    void afterDispatch(Event<P> e, Subscriber<P> s, Throwable errorOrNull);
}
