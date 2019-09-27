package iaik.at.groupsignature;

public class UserMessage {
    private int user_id;
    private int timestamp;
    private int nonce;
    private String user_x509;

    public int getNonce() {
        return nonce;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_x509() {
        return user_x509;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_x509(String user_x509) {
        this.user_x509 = user_x509;
    }
}
