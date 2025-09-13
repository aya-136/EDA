package eventtypes;

public class UserLogin {
    public String userId;
    public String ip;
    public long timestamp;

    public UserLogin(String userId, String ip, long timestamp) {
        this.userId = userId;
        this.ip = ip;
        this.timestamp = timestamp;
    }

}