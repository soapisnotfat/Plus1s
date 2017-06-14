package plus1s.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    UserDataStore userDataStore;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button main_logout = (Button)findViewById(R.id.main_logout);

        userDataStore = new UserDataStore(this);
        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDataStore.clearUserData();
                userDataStore.setUserLoggedIn(false);
                Intent LoginIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(LoginIntent);
            }
        });
    }

    private boolean authenticate() {
        return userDataStore.getUserLogingStatus();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate()) {

        }
    }
}
