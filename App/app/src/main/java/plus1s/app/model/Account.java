package plus1s.app.model;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Ivorycandy on 6/19/17.
 * provides User APIs
 */

public interface Account {
    /**
     * setter of user's name
     * @param name the string parsing in
     */
    void setName(String name);

    /**
     * setter of user's username
     * @param username the string parsing in
     */
    void setUsername(String username);

    /**
     * setter of user's password
     * @param password the string parsing in
     */
    void setPassword(String password);

    /**
     * setter of user's email
     * @param email the string parsing in
     */
    void setEmail(String email);

    /**
     * setter of user's lock status
     * @param isLocked the boolean parsing in
     */
    void setIsLocked(boolean isLocked);

    /**
     * getter of user's name
     * @return user's name
     */
    String getName();

    /**
     * getter of user's username
     * @return user's username
     */
    String getUsername();

    /**
     * getter of user's password
     * @return user's password
     */
    String getPassword();

    /**
     * getter of user's email
     * @return user's email
     */
    String getEmail();

    /**
     * getter of user's lock status
     * @return user's lock status
     */
    boolean getIsLocked();

    /**
     * getter of permission that user obtains
     * @return permissions
     */
    boolean hasPermission();

    /**
     * getter of user's found item's name
     * @return user's found item's name
     */
    HashMap<String, Item> getItems();

    /**
     * add an item to user's foundItem array
     * @param name item's name
     * @param description item's description
     * @param location item's location
     * @param category item's category
     * @param currentUsername item's uploader name
     */
    void addItems(String name, String description, String location, String category, String type, int reward, String currentUsername, double latitude, double longtitude);

    /**
     * setter of found item
     * @param e user's found item
     */
    void setItems(HashMap<String, Item> e);

    /**
     * getter of account type
     * @return user's type
     */
    String returnType();



}
