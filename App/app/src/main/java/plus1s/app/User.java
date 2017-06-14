package plus1s.app;

/**
 * Created by ivorycandy on 6/13/17.
 */

public class User {
    private String name, username, password;

    /**
     * three param constructor
     * @param name user's name
     * @param username user's username
     * @param password user's password
     */
    public User (String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * two param constructor
     * @param username user's username
     * @param password user's password
     */
    public User (String username, String password) {
        this.name = "Unknown";
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }


}
