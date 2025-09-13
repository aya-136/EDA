package subscribers;

import eventtypes.*;
import events.Event;
import events.Subscriber;


public class SecurityMonitor implements Subscriber<UserLogin> {
    @Override
    public void onEvent(Event<UserLogin> e) {
        UserLogin u = e.getPayload();
        System.out.println("security login of " + u.userId + " from " + u.ip);
    }
}
