package eventtypes;

public class FileUploaded {
    String fileId;
    String ownerId;
    long sizeBytes;
    long timestamp;

    public FileUploaded(String fileId, String ownerId, long sizeBytes, long timestamp) {
        this.fileId = fileId;
        this.ownerId = ownerId;
        this.sizeBytes = sizeBytes;
        this.timestamp = timestamp;
    }
}

