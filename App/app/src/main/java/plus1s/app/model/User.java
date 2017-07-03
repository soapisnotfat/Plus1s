package plus1s.app.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivorycandy on 6/13/17.
 * class of user
 */

public class User implements Account{
    private String name, username, password, email;
    private boolean isLocked;
    protected String type;
    private ArrayList<Item> lostItem;
    private ArrayList<Item> foundItem;
    public final static List<AccountType> legalAccountType = Arrays.asList(AccountType.ADMINISTRATOR,
            AccountType.MANAGER,
            AccountType.USER);


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
     * non-param constructor
     */
    public User() {
        this.lostItem = new ArrayList<>();
        this.foundItem = new ArrayList<>();
        type = AccountType.USER.toString();
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
    public boolean getIsLocked() {
        return this.isLocked;
    }


    @Override
    public void addLostItem(String name, String description, String location, ItemCategory category, int reward, String dateEntered, User currentUser) {
        Item i = new Item(name, description, location, true, category, ItemType.LOST, reward, dateEntered, currentUser);
        lostItem.add(i);
    }

    @Override
    public void setLostItem(ArrayList<Item> e) {
        lostItem.addAll(e);
    }

    @Override
    public ArrayList<Item> getFoundItem() {
        return lostItem;
    }

    @Override
    public void addFoundItem(String e) {
        Item i = new Item(e);
        foundItem.add(i);
    }

    @Override
    public void setFoundItem(ArrayList<Item> e) {
        lostItem.addAll(e);
    }

    @Override
    public ArrayList<Item> getLostItem() {
        return lostItem;
    }


    @Override
    public boolean hasPermission() {
        return !getIsLocked();
    }

    @Override
    public String returnType() {
        return "User";
    }

}
