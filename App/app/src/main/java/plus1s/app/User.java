package plus1s.app;

/**
 * Created by ivorycandy on 6/13/17.
 */

public class User {
    private String name, username, password;

    public User (String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User (String username, String password) {
        this.name = "Unknown";
        this.username = username;
        this.password = password;
    }

}
