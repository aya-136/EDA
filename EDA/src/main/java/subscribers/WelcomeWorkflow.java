package subscribers;

import eventtypes.UserRegistered;
import events.Event;
import events.Subscriber;

public class WelcomeWorkflow implements Subscriber<UserRegistered> {
    @Override
    public void onEvent(Event<UserRegistered> e) {
        UserRegistered u = e.getPayload();
        System.out.println("welcome, email to " + u.email);
    }
}
