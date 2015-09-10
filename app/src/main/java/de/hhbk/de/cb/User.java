package de.hhbk.de.cb;
import java.util.UUID;
/**
 * Created by admin on 10.09.15.
 */
public class User {
    private UUID id;
    private String name;
    private String password;

    public User() {
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public boolean isNameCorrect(String otherName) {
        if(otherName.equals(name)) {
            return true;
        }
        return false;
    }
    public boolean isPasswordCorrect(String pass) {
        if(pass.equals(password)) {
            return true;
        }
        return false;
    }
}
