package eventtypes;

public class CommentPosted {
    public String commentId;
    public String postId;
    public String authorId;
    public String text;
    public long timestamp;

    public CommentPosted(String commentId, String postId, String authorId, String text) {
        this.commentId = commentId;
        this.postId = postId;
        this.authorId = authorId;
        this.text = text;
        this.timestamp = System.currentTimeMillis();
    }


}
