package plus1s.app.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import plus1s.app.R;
import plus1s.app.model.Item;
import plus1s.app.model.UserDetails;

public class LostItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item);

        final Button lost_cancel = (Button)findViewById(R.id.lost_cancel);
        final Button lost_add = (Button)findViewById(R.id.lost_add);
        final EditText lost_lost_item = (EditText) findViewById(R.id.lost_lost_item);
        final EditText LocationEnter = (EditText)  findViewById(R.id.lost_location_enter);
        final EditText DescriptionEnter = (EditText)  findViewById(R.id.lost_description_enter);
        final EditText MoneyReward = (EditText)  findViewById(R.id.lost_reward);
        final EditText LongitudeNumber = (EditText) findViewById(R.id.lost_longitude);
        final EditText LatitudeNumber = (EditText) findViewById(R.id.lost_latitude);
        final Spinner lostCategorySpinner = (Spinner) findViewById(R.id.lost_categoty_spinner);
        final Spinner lostTypeSpinner = (Spinner) findViewById(R.id.lost_type_spinner);

        ArrayAdapter<String> category_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Item.legalItemCategory);
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lostCategorySpinner.setAdapter(category_adapter);

        ArrayAdapter<String> type_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Item.legalItemType);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lostTypeSpinner.setAdapter(type_adapter);

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
                String pre_latitude = LatitudeNumber.getText().toString().trim();
                String pre_longitude = LongitudeNumber.getText().toString().trim();

                double latitude;
                if (!pre_latitude.equals("")) {
                    latitude = Double.parseDouble(pre_latitude);
                } else {
                    latitude = 0;
                }

                double longitude;
                if (!pre_longitude.equals("")) {
                    longitude = Double.parseDouble(pre_longitude);
                } else {
                    longitude = 0;
                }

                int moneyReward;
                if (!reward.equals("")) {
                    moneyReward = Integer.parseInt(reward);
                } else {
                    moneyReward = 0;
                }

                if (!lost_item.equals("")) {
                    UserDetails.getCurrentUser().addItems(lost_item,
                            description,
                            location,
                            lostCategorySpinner.getSelectedItem().toString(),
                            lostTypeSpinner.getSelectedItem().toString(),
                            moneyReward,
                            UserDetails.getCurrentUser().getUsername(),latitude, longitude);
                    lost_lost_item.setText("");
                    LocationEnter.setText("");
                    DescriptionEnter.setText("");
                    MoneyReward.setText("");
                    LatitudeNumber.setText("");
                    LongitudeNumber.setText("");
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
