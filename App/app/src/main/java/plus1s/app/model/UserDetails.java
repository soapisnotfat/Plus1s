package plus1s.app.model;


import java.util.HashMap;

/**
 * Created by Ivorycandy on 6/14/17.
 *
 * provides info to register and login user locally
 */

public class UserDetails {
    private static final HashMap<String, Account> localDetails = new HashMap<>();
    private static Account currentUser;
    private static Account registerUser;

    /**
     * register new user to local storage
     *
     * @param newUser user to be registered
     */
    public static void register(Account newUser) {
        localDetails.put(newUser.getUsername(), newUser);
        registerUser = newUser;
    }

    /**
     * getter of Current User
     *
     * @return current user
     */
    public static Account getCurrentUser() {
        return currentUser;
    }

    /**
     * getter of registered user
     *
     * @return registered user
     */
    public static Account getRegisterUser() {
        return registerUser;
    }

    /**
     * set up current user
     *
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
     *
     * @return localDetails
     */
    public static HashMap<String, Account> getLocalDetails() {
        return localDetails;
    }

    /**
     * add a single user to local user storage
     *
     * @param username the username of user
     * @param user the data structure of user
     */
    public static void addLocalDetails(String username, Account user) {
        localDetails.put(username, user);
    }

}
