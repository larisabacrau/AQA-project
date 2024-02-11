package testdata;

import org.json.simple.JSONObject;
import utils.Reader;

public class StandardUser {


    private String username;
    private String password;

    public StandardUser(String filename) {
        JSONObject json = Reader.json(filename);
        this.username = json.get("username").toString();
        this.password = json.get("password").toString();

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
