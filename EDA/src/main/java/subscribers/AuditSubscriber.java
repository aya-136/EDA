package subscribers;
import eventtypes.UserRegistered;
import events.Event;
import events.Subscriber;

public class AuditSubscriber implements Subscriber<UserRegistered> {
    @Override
    public void onEvent(Event<UserRegistered> e) {
        UserRegistered u = e.getPayload();
        System.out.println("audit registered " + u.userId + " " + u.email);
    }
}
