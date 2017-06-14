package plus1s.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ivorycandy on 6/13/17.
 */

public class UserDataStore {
    public static final String SP_NAME = "userDetals";
    SharedPreferences UserDataBase;

    public UserDataStore(Context context) {
        UserDataBase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor spEditor = UserDataBase.edit();
        spEditor.putString("name", user.getName());
        spEditor.putString("username", user.getUsername());
        spEditor.putString("password", user.getPassword());
        spEditor.apply();
    }

    public User getCurrentUser() {
        String currentName = UserDataBase.getString("name", "");
        String currentUsername = UserDataBase.getString("username", "");
        String currentPassword = UserDataBase.getString("password", "");

        User currentUser = new User(currentName, currentUsername, currentPassword);

        return currentUser;
    }

    public void setuserLoggedIn(boolean LoggedIn) {
        SharedPreferences.Editor spEditor = UserDataBase.edit();
        spEditor.putBoolean("LoggedIn", LoggedIn);
        spEditor.apply();
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = UserDataBase.edit();
        spEditor.clear();
        spEditor.apply();
    }
}
