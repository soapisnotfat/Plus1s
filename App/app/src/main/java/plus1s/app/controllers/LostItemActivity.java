package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import plus1s.app.R;
import plus1s.app.model.UserDetails;

public class LostItemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item);

        final Button lost_cancel = (Button)findViewById(R.id.lost_cancel);
        final Button lost_add = (Button)findViewById(R.id.lost_add);
        final EditText lost_lost_item = (EditText) findViewById(R.id.lost_lost_item);;

        lost_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        lost_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lost_item = lost_lost_item.getText().toString().trim();
                if (!lost_item.equals("")) {
                    UserDetails.getCurrentUser().addLostItem(lost_item);
                } else {
                    //display an alert while user's Name is invalid
                    AlertDialog.Builder dialog0 = new AlertDialog.Builder(LostItemActivity.this);
                    dialog0.setTitle("Invalid input");
                    dialog0.setMessage("Please enter valid input")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    lost_lost_item.setText("");
                }
            }
        });
    }

    /**
     * go to main page
     */
    private void goToMain() {
        Intent MainIntent = new Intent(LostItemActivity.this, MainActivity.class);
        LostItemActivity.this.startActivity(MainIntent);
    }


}
