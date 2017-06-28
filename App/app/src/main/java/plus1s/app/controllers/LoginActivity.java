package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import plus1s.app.R;
import plus1s.app.model.Account;
import plus1s.app.model.Database;
import plus1s.app.model.UserDetails;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class LoginActivity extends AppCompatActivity {
    Database db = new Database();

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
            @Override
            public void onClick(View view) {
                //parse in input data
                String log_username = login_username.getText().toString();
                String log_password = login_password.getText().toString();

                Account online_user = db.downloadRequest(log_username);
                if ((online_user != null ) && (log_password.equals(online_user.getPassword()))) {
                    UserDetails.login(online_user);
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
