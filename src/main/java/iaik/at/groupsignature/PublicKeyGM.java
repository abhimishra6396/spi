package iaik.at.groupsignature;

public class PublicKeyGM {
    private String pubkey;

    PublicKeyGM() {
        setPubkey("Test Key");
    }

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }
}
