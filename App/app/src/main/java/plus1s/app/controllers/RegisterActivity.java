package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import plus1s.app.R;
import plus1s.app.model.AccountType;
import plus1s.app.model.Administrator;
import plus1s.app.model.Encryption;
import plus1s.app.model.Item;
import plus1s.app.model.Manager;
import plus1s.app.model.User;
import plus1s.app.model.UserDetails;


public class RegisterActivity extends AppCompatActivity {

    // controls the minimum length of password
    private static final int password_minimum_length = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        final EditText reg_name = (EditText) findViewById(R.id.reg_name);
        final EditText reg_username = (EditText) findViewById(R.id.reg_user);
        final EditText reg_email = (EditText) findViewById(R.id.reg_email);
        final EditText reg_password = (EditText) findViewById(R.id.reg_password);
        final EditText reg_password_confirm = (EditText) findViewById(R.id.reg_pass_confirm);
        final Button reg_register = (Button) findViewById(R.id.reg_register);
        final Button reg_cancel = (Button) findViewById(R.id.reg_cancel);
        final Spinner reg_account_type = (Spinner) findViewById(R.id.reg_account_type);
        ArrayAdapter<AccountType> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, User.legalAccountType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_account_type.setAdapter(adapter);


        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = reg_name.getText().toString().trim();
                String username = reg_username.getText().toString().trim();
                String email = reg_email.getText().toString().trim();
                String password_1 = reg_password_confirm.getText().toString();
                String password_2 = reg_password.getText().toString();
                String accountType = reg_account_type.getSelectedItem().toString();
                boolean qualified = registerQualified(name, username, email, password_1, password_2);
                if (qualified) {
                    //set up new user
                    User RegisteredUser;
                    switch (accountType) {
                        case "Administrator":
                            RegisteredUser = new Administrator();
                            break;
                        case "Manager":
                            RegisteredUser = new Manager();
                            break;
                        default:
                            RegisteredUser = new User();
                            break;
                    }
                    RegisteredUser.setUsername(username);
                    RegisteredUser.setName(name);
                    RegisteredUser.setEmail(email);
                    RegisteredUser.setPassword(Encryption.encrypt(password_1));
                    RegisteredUser.setIsLocked(false);
                    RegisteredUser.setItems(new HashMap<String, Item>());

                    // upload new user to database
                    UserDetails.register(RegisteredUser);
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference("user").child(username);
                    dr.setValue(UserDetails.getRegisterUser());
                    Toast.makeText(RegisterActivity.this, "You have successfully registered", Toast.LENGTH_SHORT);

                    //come back to login page after register successfully
                    goToLogin();
                } else {
                    AlertDialog.Builder dialog3 = new AlertDialog.Builder(RegisterActivity.this);
                    dialog3.setTitle("Password not confirmed");
                    dialog3.setMessage("Your passwords don't match")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    reg_password_confirm.setText("");
                }
            }
        });

        reg_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWelcome();
            }
        });
    }
    /**
     * check whether the register's information is qualified
     * @param name user's name
     * @param username user's username
     * @param email user's email
     * @param password_1 user's first time typing password
     * @param password_2 user's second time typing password
     * @return whether the register's information is qualified
     */
    public static boolean registerQualified(String name, String username, String email, String password_1, String password_2) {
        if (!name.trim().equals("")) {
            if (!username.trim().equals("")) {
                if (email.contains("@")) {
                    if ((password_2.length() >= password_minimum_length)) {
                        if ((password_2.equals(password_1))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * go to login page
     */
    private void goToLogin() {
        RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    /**
     * go to welcome page
     */
    private void goToWelcome() {
        RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, WelcomeActivity.class));
    }


}
