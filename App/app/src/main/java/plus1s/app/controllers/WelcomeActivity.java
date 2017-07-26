package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import plus1s.app.R;

public class WelcomeActivity extends AppCompatActivity {
    TextView animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button welcome_login = (Button) findViewById(R.id.welcome_login);
        Button welcome_register = (Button) findViewById(R.id.welcome_register);
        animation = (TextView) findViewById(R.id.textView);
        final Animation twink_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.twink);
        animation.setAnimation(twink_anim);
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
        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    /**
     * got to register page
     */
    private void goToRegister() {
        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
    }
}
