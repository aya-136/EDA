import eventtypes.*;
import events.Event;
import events.EventBus;
import events.EventTypes;
import interceptors.LoggingInterceptor;
import subscribers.*;

public class Main {
    public static void main(String[] args) {

        EventBus eventBus1 = new EventBus();

        eventBus1.register(EventTypes.USER_REGISTERED, new AuditSubscriber());
        eventBus1.register(EventTypes.USER_REGISTERED, new WelcomeWorkflow());
        eventBus1.register(EventTypes.USER_LOGIN, new SecurityMonitor());

        eventBus1.addInterceptor(EventTypes.USER_REGISTERED, new LoggingInterceptor<>());
        eventBus1.addInterceptor(EventTypes.FILE_UPLOADED, new LoggingInterceptor<>());
        eventBus1.addInterceptor(EventTypes.COMMENT_POSTED, new LoggingInterceptor<>());

        long now = System.currentTimeMillis();
        //Happy Path
        eventBus1.publish(Event.of(EventTypes.USER_REGISTERED, new UserRegistered("firstUser", "aya@zeyad.com", now)));
        eventBus1.publish(Event.of(EventTypes.FILE_UPLOADED, new FileUploaded("file123", "firstUser", 100, now)));
        eventBus1.publish(Event.of(EventTypes.FILE_UPLOADED, new FileUploaded("badFile_136", "firstUser", 50, now)));


    }
}
