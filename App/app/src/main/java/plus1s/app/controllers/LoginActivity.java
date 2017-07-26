package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import plus1s.app.R;
import plus1s.app.model.Account;
import plus1s.app.model.Administrator;
import plus1s.app.model.Encryption;
import plus1s.app.model.FoundItem;
import plus1s.app.model.Item;
import plus1s.app.model.LostItem;
import plus1s.app.model.Manager;
import plus1s.app.model.User;
import plus1s.app.model.UserDetails;


public class LoginActivity extends AppCompatActivity {
    private final DatabaseReference database = FirebaseDatabase.getInstance().getReference("user");
    private final DatabaseReference database_2 = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //random variable instantiations
        final EditText login_username = (EditText) findViewById(R.id.login_user);
        final TextView login_back = (TextView) findViewById(R.id.login_back);
        final EditText login_password = (EditText) findViewById(R.id.login_password);
        final Button login_login = (Button) findViewById(R.id.login_login);
        final TextView login_reg = (TextView) findViewById(R.id.login_register);

        database_2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Item>> t = new GenericTypeIndicator<HashMap<String, Item>>() {};
                if (dataSnapshot.hasChild("foundItems")) {
                    FoundItem.setFoundItem(dataSnapshot.child("foundItems").getValue(t));
                }

                if (dataSnapshot.hasChild("lostItems")) {
                    LostItem.setLostItem(dataSnapshot.child("lostItems").getValue(t));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //register on clicking register button
        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to register page
                goToRegister();
            }
        });

        //login action on clicking login button
        login_login.setOnClickListener(new View.OnClickListener() {
            String log_password = "";

            @Override
            public void onClick(View view) {
                //parse in input data

                String log_username = login_username.getText().toString().trim();
                log_password = login_password.getText().toString().trim();
                log_password = Encryption.encrypt(log_password);
                DatabaseReference Ref = database.child(log_username);
                ValueEventListener e = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Account user;
                        // retrieve data from Database
                        System.out.println("downloadRequest::onDataChange is Called!");
                        if (dataSnapshot.exists()) {
                            user = createUser(dataSnapshot.child("type").getValue(String.class));

                            user.setUsername(dataSnapshot.child("username").getValue(String.class));
                            user.setName(dataSnapshot.child("name").getValue(String.class));
                            user.setPassword(dataSnapshot.child("password").getValue(String.class));
                            user.setEmail(dataSnapshot.child("email").getValue(String.class));
                            user.setIsLocked(dataSnapshot.child("isLocked").getValue(boolean.class));
                            GenericTypeIndicator<HashMap<String, Item>> t = new GenericTypeIndicator<HashMap<String, Item>>() {};
                            if (dataSnapshot.hasChild("items")) {
                                user.setItems(dataSnapshot.child("items").getValue(t));
                            }
                            if (loginProcess(log_password, user)) {
                                goToMain();
                            } else {
                                //display an alert while password is invalid
                                AlertDialog.Builder dialog3 = new AlertDialog.Builder(LoginActivity.this);
                                dialog3.setTitle("Invalid Login Attempt");
                                dialog3.setMessage("please enter correct combination ")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                login_password.setText("");
                            }
                        } else {
                            //display an alert while password is invalid
                            AlertDialog.Builder dialog3 = new AlertDialog.Builder(LoginActivity.this);
                            dialog3.setTitle("Invalid Login Attempt");
                            dialog3.setMessage("please enter correct combination ")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                            login_password.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                };
                Ref.addListenerForSingleValueEvent(e);
            }
        });

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWelcome();
            }
        });

    }

    /**
     * go to main page
     */
    private void goToMain() {
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    /**
     * go to register page
     */
    private void goToRegister() {
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    /**
     * go to welcome page
     */
    private void goToWelcome() {
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
    }

    /**
     * check the account from online database and create corresponding one on local client
     * @param type the account type parsing in
     * @return the account created
     */
    public static Account createUser(String type) {
        Account user;
        switch (type) {
            case "Administrator":
                user = new Administrator();
                break;
            case "Manager":
                user = new Manager();
                break;
            default:
                user = new User();
                break;
        }
        return user;
    }

    /**
     * check if passwords match
     * @param password the passwprd user puts in
     * @param user the user gotten from online database
     * @return the result whether passwords match
     */
    public static boolean loginProcess(String password, Account user) {
        if (password.equals(user.getPassword())) {
            UserDetails.login(user);
            return true;
        } else {
            return false;
        }
    }
}
