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
import plus1s.app.model.UserDetails;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText login_username = (EditText) findViewById(R.id.login_user);
        final EditText login_password = (EditText) findViewById(R.id.login_password);
        final Button login_login = (Button) findViewById(R.id.login_login);
        final TextView login_reg = (TextView) findViewById(R.id.login_register);
        final String log_username = login_username.getText().toString();
        final String log_password = login_password.getText().toString();

        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });

        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserDetails.login(log_username, log_password)) {
                    goToMain();
                } else {
                    //display an alert while password is invalid
                    AlertDialog.Builder dialog3 = new AlertDialog.Builder(LoginActivity.this);
                    dialog3.setTitle("Invalid Login Attempt");
                    dialog3.setMessage("please enter correct word combination ")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    login_password.setText("");
                }
            }
        });

    }

    private void goToMain() {
        Intent toMainIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(toMainIntent);
    }

    private void goToRegister() {
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(registerIntent);
    }
}
