package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import plus1s.app.R;
import plus1s.app.model.UserDetails;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button main_logout = (Button)findViewById(R.id.main_logout);
        TextView main_welcome = (TextView) findViewById(R.id.main_welcome);
        main_welcome.setText("Welcome," + UserDetails.getCurrentUser().getName());

        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetails.logout();
            }
        });
    }

}
