package plus1s.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bLogout = (Button)findViewById(R.id.main_logout);
    protected boolean loginStatus = false;
    protected void onCreate(Bundle savedInstanceState) {
        if (!loginStatus) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
