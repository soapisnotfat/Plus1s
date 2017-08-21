package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import plus1s.app.R;
import plus1s.app.model.UserDetails;

public class BanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);

        final TextView ban_back = (TextView)findViewById(R.id.ban_back);
        final ListView ban_list = (ListView)findViewById(R.id.ban_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, UserDetails.getBanList());
        ban_list.setAdapter(adapter);
        ban_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String username = adapter.getItem(i);
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(BanActivity.this);
                dialog3.setTitle("Unban User");
                dialog3.setMessage("Are you sure to unban " + username + " ?")
                        .setNegativeButton("No", null)
                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                unBanUser(username);
                                goToMain();
                            }
                        })
                        .create()
                        .show();
            }
        });

        ban_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });
    }

    /**
     * go to main page
     */
    private void goToMain() {
        BanActivity.this.startActivity(new Intent(BanActivity.this, MainActivity.class));
    }

    /**
     * unban the user
     * @param username user's username
     */
    private void unBanUser(String username) {
        DatabaseReference df = FirebaseDatabase.getInstance().getReference("user").child(username).child("isLocked");
        df.setValue(false);
        updateBanList(username, false);
    }

    /**
     * ban the user
     * @param username user's username
     */
    private void banUser(String username) {
        DatabaseReference df = FirebaseDatabase.getInstance().getReference("user").child(username).child("isLocked");
        df.setValue(true);
        updateBanList(username, true);
    }

    /**
     * update the banlist
     * @param username the user's username
     * @param operation the direction of operation (add/remove)
     */
    private void updateBanList(String username, boolean operation) {
        if (operation) {
            UserDetails.addBanList(username);
        } else {
            UserDetails.removeBanList(username);
        }
        DatabaseReference df_2 = FirebaseDatabase.getInstance().getReference("banList");
        df_2.setValue(UserDetails.getBanList());
    }
}
