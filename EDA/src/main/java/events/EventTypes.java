package events;

import eventtypes.*;

public final class EventTypes {
    public static final EventType<UserRegistered> USER_REGISTERED =
            new EventType<>("USER_REGISTERED", UserRegistered.class);

    public static final EventType<UserLogin> USER_LOGIN =
            new EventType<>("USER_LOGIN", UserLogin.class);

    public static final EventType<FileUploaded> FILE_UPLOADED =
            new EventType<>("FILE_UPLOADED", FileUploaded.class);

    public static final EventType<CommentPosted> COMMENT_POSTED =
            new EventType<>("COMMENT_POSTED", CommentPosted.class);
}
