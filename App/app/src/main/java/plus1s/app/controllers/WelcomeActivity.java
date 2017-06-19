package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import plus1s.app.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button welcome_login = (Button) findViewById(R.id.welcome_login);
        Button welcome_register = (Button) findViewById(R.id.welcome_register);

        welcome_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               goToLogin();
            }
        });

        welcome_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });

    }

    /**
     * go to login page
     */
    private void goToLogin() {
        Intent LoginIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
        WelcomeActivity.this.startActivity(LoginIntent);
    }

    /**
     * got to register page
     */
    private void goToRegister() {
        Intent RegisterIntent = new Intent(WelcomeActivity.this, RegisterActivity.class);
        WelcomeActivity.this.startActivity(RegisterIntent);
    }
}