package plus1s.app.model;


import java.util.ArrayList;

/**
 * Created by Ivorycandy on 6/14/17.
 *
 * provides info to register and login user locally
 */

public class UserDetails {
    private static Account currentUser;
    private static Account registerUser;
    private static ArrayList<String> banList = new ArrayList<>();

    /**
     * register new user to local storage
     *
     * @param newUser user to be registered
     */
    public static void register(Account newUser) {
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
     * setter of banList
     * @param e the banList put in
     */
    public static void setBanList(ArrayList<String> e) {
        banList.clear();
        banList.addAll(e);
    }

    /**
     * add a user to the ban list
     * @param e the username will be added to banList
     */
    public static void addBanList(String e) {
        banList.add(e);
    }

    /**
     * remove one user from banList
     * @param e the user
     */
    public static void removeBanList(String e) {
        banList.remove(e);
    }

    /**
     * getter of banList
     * @return the banList
     */
    public static ArrayList<String> getBanList() {
        return banList;
    }
}
