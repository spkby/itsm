package by.itsm.patients.logic.context;

public class HashSalt {

    private final String salt;

    public HashSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }
}
