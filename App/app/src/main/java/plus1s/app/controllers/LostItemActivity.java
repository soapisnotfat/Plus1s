package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import plus1s.app.R;
import plus1s.app.model.Item;
import plus1s.app.model.ItemCategory;
import plus1s.app.model.UserDetails;

public class LostItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item);

        final Button lost_cancel = (Button)findViewById(R.id.lost_cancel);
        final Button lost_add = (Button)findViewById(R.id.lost_add);
        final EditText lost_lost_item = (EditText) findViewById(R.id.lost_lost_item);
        final EditText LocationEnter = (EditText)  findViewById(R.id.LocationEnter);
        final EditText DescriptionEnter = (EditText)  findViewById(R.id.DescriptionEnter);
        final EditText MoneyReward = (EditText)  findViewById(R.id.MoneyReward);
        final TextView Name = (TextView) findViewById(R.id.Name);
        final TextView Description = (TextView) findViewById(R.id.Description);
        final TextView Location = (TextView) findViewById(R.id.Location);
        final TextView Category = (TextView) findViewById(R.id.Category);
        final TextView Reward = (TextView) findViewById(R.id.Reward);
        final Spinner CategorySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Item.legalItemCategory);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(adapter);

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
                String description = DescriptionEnter.getText().toString().trim();
                String location = LocationEnter.getText().toString().trim();
                String reward = MoneyReward.getText().toString().trim();
                int moneyReward = Integer.parseInt(reward);

                if (!lost_item.equals("")) {
                    UserDetails.getCurrentUser().addLostItem(lost_item, description, location, (ItemCategory)CategorySpinner.getSelectedItem(),moneyReward, UserDetails.getCurrentUser());
                    lost_lost_item.setText("");
                    Toast.makeText(LostItemActivity.this, "You have added lost item", Toast.LENGTH_SHORT).show();
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
        LostItemActivity.this.startActivity(new Intent(LostItemActivity.this, MainActivity.class));
    }


}
