package plus1s.app.model;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zijinluo on 6/14/17.
 * provides info to register and login user locally
 */

public class UserDetails {
    private static final HashMap<String, User> localDetails = new HashMap<>();
    public static User currentUser;
    //private static final ArrayList<Report> localReportList = new ArrayList<>();

    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * register new user to local storage
     * @param newUser user to be registered
     */
    public static void register(User newUser) {
        localDetails.put(newUser.getUsername(), newUser);
    }

    /**
     * logging action
     * checking if login is successful
     * @param username the username used to login
     * @param password the corresponding password to login
     * @return the status of lojin
     */
    public static boolean login(String username, String password) {
        if (localDetails.containsKey(username)) {
            if (localDetails.get(username).getPassword().equals(password)) {
                currentUser = localDetails.get(username);
                return true;
            }
        }
        return false;
    }

    /**
     * logout the current user
     */
    public static void logout() {
        currentUser = null;
    }

    //TODO report system is about to be online
}
