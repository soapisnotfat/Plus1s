package plus1s.app.model;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivorycandy on 6/13/17.
 * class of user
 */

public class  User implements Account{
    private String name, username, password, email;
    private boolean isLocked;
    String type;
    private final HashMap<String, Item> items;
    public final static List<AccountType> legalAccountType = Arrays.asList(AccountType.ADMINISTRATOR,
            AccountType.MANAGER,
            AccountType.USER);


    /**
     * five param constructor
     *
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
        this.items = new HashMap<>();
    }

    /**
     * non-param constructor
     */
    public User() {
        this.items = new HashMap<>();
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
    public HashMap<String, Item> getItems() {
        return items;
    }

    @Override
    public void addItems(String name, String description, String category, String type, int reward, String currentUsername, double latitude, double longitude) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        Item i = new Item(name, description, true, category, type, reward, formattedDate, currentUsername, latitude, longitude);
        items.put(name, i);
    }

    @Override
    public void setItems(HashMap<String, Item> e) {
        items.putAll(e);
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
