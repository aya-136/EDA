package events;

import java.util.*;

public final class EventBus {

    private final Map<EventType<?>, List<Subscriber<?>>> subscribers = new HashMap<>();
    private final Map<EventType<?>, List<EventInterceptor<?>>> interceptors = new HashMap<>();

    public <P> void register(EventType<P> type, Subscriber<P> subscriber) {
//        List<events.Subscriber<?>> list = subscribers.get(type);
//        if (list == null) {
//            list = new ArrayList<>();
//            subscribers.put(type, list);
//        }
//        list.add(subscriber);
        if (subscriber == null) throw new NullPointerException("events.Subscriber cannot be null");
        subscribers.computeIfAbsent(type, k -> new ArrayList<>()).add(subscriber);
    }

    public <P> void unregister(EventType<P> type, Subscriber<P> subscriber) {
        List<Subscriber<?>> list = subscribers.get(type);
        if (list != null) list.remove(subscriber);
    }

    public <P> void addInterceptor(EventType<P> type, EventInterceptor<P> interceptor) {
        if (interceptor == null) throw new NullPointerException("Interceptor cannot be null");
        interceptors.computeIfAbsent(type, k -> new ArrayList<>()).add(interceptor);
    }

    public <P> void removeInterceptor(EventType<P> type, EventInterceptor<P> interceptor) {
        List<EventInterceptor<?>> list = interceptors.get(type);
        if (list != null) list.remove(interceptor);
    }

    public <P> void publish(Event<P> event) {
        List<EventInterceptor<?>> typeInterceptors = interceptors.getOrDefault(event.getType(), Collections.emptyList());
        for (EventInterceptor<?> i : typeInterceptors) {
            @SuppressWarnings("unchecked")
            EventInterceptor<P> interceptor = (EventInterceptor<P>) i;
            interceptor.beforePublish(event);
        }
        List<Subscriber<?>> typeSubscribers = subscribers.getOrDefault(event.getType(), Collections.emptyList());
        for (Subscriber<?> s : typeSubscribers) {
            @SuppressWarnings("unchecked")
            Subscriber<P> subscriber = (Subscriber<P>) s;

            for (EventInterceptor<?> i : typeInterceptors) {
                @SuppressWarnings("unchecked")
                EventInterceptor<P> interceptor = (EventInterceptor<P>) i;
                interceptor.beforeDispatch(event, subscriber);
            }

            Exception error = null;
            try {
                subscriber.onEvent(event);
            } catch (Exception e) {
                error = e;//to pass it later
                e.printStackTrace();
            }
            for (EventInterceptor<?> i : typeInterceptors) {
                @SuppressWarnings("unchecked")
                EventInterceptor<P> interceptor = (EventInterceptor<P>) i;
                interceptor.afterDispatch(event, subscriber, error);//here
            }
        }
    }
}