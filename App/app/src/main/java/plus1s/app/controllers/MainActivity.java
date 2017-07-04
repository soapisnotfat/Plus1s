package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import plus1s.app.R;
import plus1s.app.model.FoundItem;
import plus1s.app.model.Item;
import plus1s.app.model.ItemType;
import plus1s.app.model.UserDetails;

public class MainActivity extends AppCompatActivity {
    FoundItem fi = new FoundItem();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //random variable instantiations
        final Button main_logout = (Button)findViewById(R.id.main_logout);
        final Button main_add_item = (Button) findViewById(R.id.main_add_item);
        final Button main_go_to_map = (Button) findViewById(R.id.go_to_map);
        final TextView main_welcome = (TextView) findViewById(R.id.main_welcome);
        final TextView main_lost = (TextView) findViewById(R.id.main_lost);
        final TextView main_found = (TextView) findViewById(R.id.main_found);
        final TextView main_role = (TextView) findViewById(R.id.main_role);
        final ListView main_lost_item_list = (ListView) findViewById(R.id.main_lost_item_list);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, displayLostItem());
        main_welcome.setText("Welcome," + UserDetails.getCurrentUser().getName());
        main_lost.setText("Your lost item(s) are ");
        main_go_to_map.setText("Click here to map");
        main_found.setText("Found items are" + displayFoundItem());
        main_role.setText("Mode: " + UserDetails.getCurrentUser().returnType());
        main_lost_item_list.setAdapter(adapter);

        //logout action on clocking logout button
        main_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = UserDetails.getCurrentUser().getUsername();
                DatabaseReference df = FirebaseDatabase.getInstance().getReference("user").child(temp);
                df.setValue(UserDetails.getCurrentUser());
                UserDetails.logout();

                //display if successfully logout
                Toast.makeText(MainActivity.this, "You have successfully logged out", Toast.LENGTH_SHORT).show();
                // go to login page after successfully logout
                goToLogin();
            }
        });
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
     * display current user's lot items
     * @return string of lost item
     */
    private List<String> displayLostItem() {
        ArrayList<Item> e = new ArrayList<>();
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Item> entry: UserDetails.getCurrentUser().getItems().entrySet()) {
            e.add(entry.getValue());
        }
        for (Item i : e) {
            if (i.getType().equals(ItemType.LOST.toString())) {
                output.add(i.getName());
            }
        }
        return output;
    }

    /**
     * display current found items
     * @return string of found items
     */
    private String displayFoundItem() {
        return fi.getFoundItemName();
    }

    private void goToMap() {
        MainActivity.this.startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}
