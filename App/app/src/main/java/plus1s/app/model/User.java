package plus1s.app.model;

import java.util.ArrayList;

/**
 * Created by ivorycandy on 6/13/17.
 * class of user
 */

public class User implements Account{
    private String name, username, password, email;
    private boolean isLocked;
    private ArrayList<Item> lostItem;



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
        this.lostItem = new ArrayList<>();
    }

    /**
     * four param constructor
     * @param name user's name
     * @param username user's username
     * @param password user's password
     * @param email user's email
     */
    public User (String name, String username, String password, String email) {
        this(name, username, password, email, false);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
    @Override
    public boolean getIslocked() {
        return this.isLocked;
    }

    @Override
    public void addLostItem(String e) {
        Item i = new Item(e);
        lostItem.add(i);
    }
    @Override
    public String getLostItemName() {
        String output = "";
        for (Item i: lostItem) {
            output += i.getName() + ",\n";
        }
        return output;
    }

    @Override
    public boolean hasPermission() {
        return !getIslocked();
    }

}
