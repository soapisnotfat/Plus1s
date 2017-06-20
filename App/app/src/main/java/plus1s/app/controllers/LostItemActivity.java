package plus1s.app.controllers;

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
                if (!lost_lost_item.getText().toString().trim().equals("")) {
                    UserDetails.getCurrentUser().addLostItem(lost_lost_item.getText().toString());
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
