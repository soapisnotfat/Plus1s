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
        Button main_add_lost_item = (Button) findViewById(R.id.main_add_lost_item);
        TextView main_welcome = (TextView) findViewById(R.id.main_welcome);
        TextView main_lost = (TextView) findViewById(R.id.main_lost);
        main_welcome.setText("Welcome," + UserDetails.getCurrentUser().getName());
        main_lost.setText("Your lost item(s) are" + displayLostItem());

        //logout action on clocking logout button
        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetails.logout();

                //display if successfully logout
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(MainActivity.this);
                dialog3.setTitle("You have logged out");
                dialog3.setMessage(".. ")
                        .setNegativeButton("OK", null)
                        .create()
                        .show();

                // go to login page after successfully logout
                goToLogin();
            }
        });

        main_add_lost_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLostItem();
            }
        });
    }

    /**
     * go to logging page
     */
    private void goToLogin() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(loginIntent);
    }

    private void goToLostItem() {
        Intent LostItemIntent = new Intent(MainActivity.this, LostItemActivity.class);
        MainActivity.this.startActivity(LostItemIntent);
    }
    /**
     * display current user's lot items
     * @return string of lost item
     */
    private String displayLostItem() {
        String output = "";
        if (UserDetails.getCurrentUser().getLostItem() != null) {
            for (String i : UserDetails.getCurrentUser().getLostItem()) {
                output += i + "," + '\n';
            }
        }
        return output;
    }
}
