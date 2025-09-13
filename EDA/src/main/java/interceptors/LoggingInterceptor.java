package interceptors;

import events.Event;
import events.EventInterceptor;
import events.Subscriber;

public class LoggingInterceptor<P> implements EventInterceptor<P> {

    @Override
    public void beforePublish(Event<P> event) {
        System.out.println("publish " + event.getType().getName() + " id=" + event.getId());
    }

    @Override
    public void beforeDispatch(Event<P> event, Subscriber<P> subscriber) {
        System.out.println("dispatch : " + subscriber.name());
    }

    @Override
    public void afterDispatch(Event<P> event, Subscriber<P> subscriber, Throwable errorOrNull) {
        if (errorOrNull == null) {
            System.out.println("DONE");
        } else {
            System.out.println("Error: " + errorOrNull.getMessage());
        }
    }
}
