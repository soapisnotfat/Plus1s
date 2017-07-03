package plus1s.app.model;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ivorycandy on 6/14/17.
 * provides info to register and login user locally
 */

public class UserDetails {
    private static final HashMap<String, Account> localDetails = new HashMap<>();
    public static Account currentUser;
    public static Account registerUser;

    public static Account getCurrentUser() {
        return currentUser;
    }

    public static Account getRegisterUser() {
        return registerUser;
    }

    /**
     * register new user to local storage
     * @param newUser user to be registered
     */
    public static void register(Account newUser) {
        localDetails.put(newUser.getUsername(), newUser);
        registerUser = newUser;
    }

    /**
     *  set up current user
     * @param user user parsing in
     */
    public static void login(Account user) {
        currentUser = user;
    }

    /**
     * logout the current user
     */
    public static void logout() {
        currentUser = null;
    }

    /**
     * getter of localDetails
     * @return localDetails
     */
    public static HashMap<String, Account> getLocalDetails() {
        return localDetails;
    }

    public static void setLocalDetails(String username, Account user) {
        localDetails.put(username, user);
    }

    //TODO report system is about to be online
}
