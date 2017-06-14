package plus1s.app;

/**
 * Created by ivorycandy on 6/13/17.
 */

public class User {
    private String name, username, password, email;
    private boolean isLocked;

    /**
     * five param constructor
     * @param name user's name
     * @param username user's username
     * @param password user's password
     * @param email user's email
     * @param isLocked user's lock status
     */
    public User (String name, String username, String password, String email, boolean isLocked) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isLocked = isLocked;
    }

    /**
     * four param constructor
     * @param name user's name
     * @param username user's username
     * @param password user's password
     * @param email user's email
     */
    public User (String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public void setEmail(String password) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setIsLocked(String password) {
        this.isLocked = isLocked;
    }
    public boolean getIslocked() {
        return this.isLocked;
    }


}
