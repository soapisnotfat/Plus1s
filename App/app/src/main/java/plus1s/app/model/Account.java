package plus1s.app.model;

import java.util.ArrayList;

/**
 * Created by zijinluo on 6/19/17.
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
    boolean getIslocked();

    /**
     * getter of permission that user obtains
     * @return permissions
     */
    boolean hasPermission();

    /**
     * getter of user's lost items
     * @return user's lost items
     */
    String getLostItem();

    /**
     * add an item to user's lostItem array
     * @param item the lost item parsing in
     */
    void addLostItem(String item);

}
