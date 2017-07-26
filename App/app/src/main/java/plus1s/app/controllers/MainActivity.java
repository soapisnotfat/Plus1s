package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import plus1s.app.R;
import plus1s.app.model.Encryption;
import plus1s.app.model.FoundItem;
import plus1s.app.model.LostItem;
import plus1s.app.model.UserDetails;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //random variable instantiations
        final Button main_logout = (Button)findViewById(R.id.main_logout);
        final Button main_add_item = (Button) findViewById(R.id.main_add_item);
        final Button main_go_to_map = (Button) findViewById(R.id.main_go_to_map);
        final Button main_lost_view = (Button) findViewById(R.id.main_lost_view);
        final Button main_found_view = (Button) findViewById(R.id.main_found_view);
        final Button main_search = (Button) findViewById(R.id.main_search);
        final Button main_ban = (Button) findViewById(R.id.main_ban);
        final TextView main_welcome = (TextView) findViewById(R.id.main_welcome);
        final TextView main_role = (TextView) findViewById(R.id.main_role);
        img = (ImageView) findViewById(R.id.imageView);
        final Animation fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        img.setAnimation(fade_in_anim);
        main_welcome.setText("Welcome, " + UserDetails.getCurrentUser().getName());
        main_role.setText("Mode: " + UserDetails.getCurrentUser().returnType());

        //logout action on clocking logout button
        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = UserDetails.getCurrentUser().getUsername();
                DatabaseReference df = FirebaseDatabase.getInstance().getReference("user").child(temp);
                df.setValue(UserDetails.getCurrentUser());
                DatabaseReference df_2 =FirebaseDatabase.getInstance().getReference("foundItems");
                df_2.setValue(FoundItem.getFoundItems());
                DatabaseReference df_3 =FirebaseDatabase.getInstance().getReference("lostItems");
                df_3.setValue(LostItem.getLostItems());
                UserDetails.logout();

                //display if successfully logout
                Toast.makeText(MainActivity.this,
                        "You have successfully logged out", Toast.LENGTH_SHORT).show();
                // go to login page after successfully logout
                goToLogin();
            }
        });

        // button activities
        main_go_to_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMap();
            }
        });
        main_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLostItem();
            }
        });
        main_lost_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLostView();
            }
        });
        main_found_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFoundView();
            }
        });
        main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSearch();
            }
        });
        main_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserDetails.getCurrentUser().returnType().equals("Administrator")) {
                    goToBan();
                } else {
                    Toast.makeText(MainActivity.this,
                            "No permission to access this page", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * go to logging page
     */
    private void goToLogin() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    /**
     * go to lost item page
     */
    private void goToLostItem() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, LostItemActivity.class));
    }

    /**
     * go to map page
     */
    private void goToMap() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    /**
     * go to lost view page
     */
    private void goToLostView() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, LostViewActivity.class));
    }

    /**
     * go to found view page
     */
    private void goToFoundView() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, FoundViewActivity.class));
    }

    /**
     * go to search page
     */
    private void goToSearch() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, SearchActivity.class));
    }

    /**
     * go to ban page
     */
    private void goToBan() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, BanActivity.class));
    }
}
