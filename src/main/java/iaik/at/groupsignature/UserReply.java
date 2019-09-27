package iaik.at.groupsignature;

public class UserReply {
    private int user_id;
    private int timestamp;
    private int nonce;
    private String user_x509;
    private String message;
    private GroupPublicKey gpk;
    private GroupSecretKey actualGsk;

    public GroupSecretKey getActualGsk() {
        return actualGsk;
    }

    public GroupPublicKey getGpk() {
        return gpk;
    }

    public String getMessage() {
        return message;
    }

    public void setActualGsk(GroupSecretKey actualGsk) {
        this.actualGsk = actualGsk;
    }

    public void setGpk(GroupPublicKey gpk) {
        this.gpk = gpk;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
