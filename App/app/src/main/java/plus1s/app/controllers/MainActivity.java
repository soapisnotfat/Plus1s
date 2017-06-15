package plus1s.app.controllers;

import android.app.AlertDialog;
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

        //random variable instantiations
        Button main_logout = (Button)findViewById(R.id.main_logout);
        TextView main_welcome = (TextView) findViewById(R.id.main_welcome);
        TextView main_email = (TextView) findViewById(R.id.main_email);
        main_welcome.setText("Welcome," + UserDetails.getCurrentUser().getName());
        main_email.setText("Your email is" + UserDetails.getCurrentUser().getEmail());

        //logout action on clocking logout button
        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetails.logout();

                //display if successfully logout
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(MainActivity.this);
                dialog3.setTitle("You have logged out");
                dialog3.setMessage("滚吧 ")
                        .setNegativeButton("OK", null)
                        .create()
                        .show();

                // go to login page after successfully logout
                goTologging();
            }
        });
    }

    /**
     * go to logging page
     */
    private void goTologging() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(loginIntent);
    }

}
