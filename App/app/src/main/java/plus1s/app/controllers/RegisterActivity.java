package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import plus1s.app.R;
import plus1s.app.model.User;
import plus1s.app.model.UserDetails;

public class RegisterActivity extends AppCompatActivity {

    // controls the minimum length of password
    int password_minimum_length = 3;

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

        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = reg_name.getText().toString();
                String username = reg_username.getText().toString();
                String email = reg_email.getText().toString();
                String password_1 = reg_password_confirm.getText().toString();
                String password_2 = reg_password.getText().toString();
                if (!name.trim().equals("")) {
                    if (!username.trim().equals("")) {
                        if (email.contains("@")) {
                            if ((password_2.length() >= password_minimum_length)) {
                                if ((password_2.equals(password_1))) {
                                    User RegisteredUser = new User(name, username, password_1, email);
                                    UserDetails.register(RegisteredUser);
                                    //come back to login page after register successfully
                                    goToLogin();

                                } else {
                                    //display an alert when passwords don't match
                                    AlertDialog.Builder dialog3 = new AlertDialog.Builder(RegisterActivity.this);
                                    dialog3.setTitle("Password not confirmed");
                                    dialog3.setMessage("Your passwords don't match")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                    reg_password_confirm.setText("");
                                }
                            } else {
                                //display an alert while password is invalid
                                AlertDialog.Builder dialog3 = new AlertDialog.Builder(RegisterActivity.this);
                                dialog3.setTitle("Invalid Password");
                                dialog3.setMessage("Your password should be longer than 8 ")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                reg_password.setText("");
                                reg_password_confirm.setText("");
                            }
                        } else {
                            //display an alert while email address is invalid
                            AlertDialog.Builder dialog2 = new AlertDialog.Builder(RegisterActivity.this);
                            dialog2.setTitle("Invalid Email");
                            dialog2.setMessage("Your email should contain '@'")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                            reg_email.setText("");
                        }
                    } else {
                        //display an alert while username is invalid
                        AlertDialog.Builder dialog1 = new AlertDialog.Builder(RegisterActivity.this);
                        dialog1.setTitle("Invalid Username");
                        dialog1.setMessage("Please enter valid Username")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                        reg_username.setText("");
                    }
                } else {
                    //display an alert while user's Name is invalid
                    AlertDialog.Builder dialog0 = new AlertDialog.Builder(RegisterActivity.this);
                    dialog0.setTitle("Invalid Name");
                    dialog0.setMessage("Please enter valid name")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    reg_name.setText("");
                }
            }
        });
    }

    /**
     * go to login page
     */
    private void goToLogin() {
        RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}
