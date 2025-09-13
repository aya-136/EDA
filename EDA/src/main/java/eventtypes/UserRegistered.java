package eventtypes;

public class UserRegistered {
    public String userId;
    public String email;
    public long timestamp;

    public UserRegistered(String userId, String email, long timestamp) {
        this.userId = userId;
        this.email = email;
        this.timestamp = timestamp;
    }
}
