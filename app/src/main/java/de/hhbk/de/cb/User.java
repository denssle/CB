package de.hhbk.de.cb;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.UUID;

/**
 * Created by admin on 10.09.15.
 */
public class User {
    private UUID id;
    private String username;
    private String password;
    private String lastname;
    private String forname;
    private String title;
    private String shortname;

    public User() {
        id = UUID.randomUUID();
    }

    public UUID getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public UUID getId() {
        return id;
    }

    public boolean isUsernameCorrect(String otherName) {
        if(otherName.equals(username)) {
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

    public void init(String name, String password, JSONObject result) {
        this.username = name;
        this.password = password;
        try {
            this.lastname = (String) result.get("nachname");
            this.forname = (String) result.get("vorname");
            this.title = (String) result.get("anrede");
            this.shortname = (String) result.get("kuerzel");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
