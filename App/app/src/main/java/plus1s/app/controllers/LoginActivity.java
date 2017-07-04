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
import com.google.firebase.database.ValueEventListener;

import plus1s.app.R;
import plus1s.app.model.Account;
import plus1s.app.model.Administrator;
import plus1s.app.model.Database;
import plus1s.app.model.Item;
import plus1s.app.model.Manager;
import plus1s.app.model.User;
import plus1s.app.model.UserDetails;


public class LoginActivity extends AppCompatActivity {
    Database db = new Database();
     DatabaseReference database = FirebaseDatabase.getInstance().getReference("user");

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
                DatabaseReference Ref = database.child(log_username);
                ValueEventListener e = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Account user;
                        System.out.println("downloadRequest::onDataChange is Called!");
                        switch (dataSnapshot.child("type").getValue(String.class)) {
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

                        user.setUsername(dataSnapshot.child("username").getValue(String.class));
                        user.setName(dataSnapshot.child("name").getValue(String.class));
                        user.setPassword(dataSnapshot.child("password").getValue(String.class));
                        user.setEmail(dataSnapshot.child("email").getValue(String.class));
                        user.setIsLocked(dataSnapshot.child("isLocked").getValue(boolean.class));
                        //GenericTypeIndicator<ArrayList<Item>> t = new GenericTypeIndicator<ArrayList<Item>>() {};
                        //user.setLostItem(dataSnapshot.child("lostItem").getValue(t));
                        if (user != null) {
                            if (log_password.equals(user.getPassword())) {
                                UserDetails.login(user);
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
                            //display an alert while username is not found
                            AlertDialog.Builder dialog3 = new AlertDialog.Builder(LoginActivity.this);
                            dialog3.setTitle("Invalid Login Attempt");
                            dialog3.setMessage("Username not found")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                            login_password.setText("");
                            login_username.setText("");
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

}
