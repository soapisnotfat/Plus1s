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
import android.widget.Toast;

import plus1s.app.R;
import plus1s.app.model.Item;
import plus1s.app.model.UserDetails;

public class FoundItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_item);

        final Button found_cancel = (Button) findViewById(R.id.found_cancel);
        final Button found_add = (Button)findViewById(R.id.found_add);
        final EditText found_found_item = (EditText) findViewById(R.id.found_found_item);
        final EditText foundLocationEnter = (EditText)  findViewById(R.id.found_location_enter);
        final EditText foundDescriptionEnter = (EditText)  findViewById(R.id.found_description_enter);
        final EditText foundMoneyReward = (EditText)  findViewById(R.id.found_reward_enter);
        final Spinner foundCategorySpinner = (Spinner) findViewById(R.id.found_categoty_spinner);
        final Spinner foundTypeSpinner = (Spinner) findViewById(R.id.found_type_spinner);

        ArrayAdapter<String> category_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Item.legalItemCategory);
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foundCategorySpinner.setAdapter(category_adapter);

        ArrayAdapter<String> type_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Item.legalItemType);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foundTypeSpinner.setAdapter(type_adapter);

        found_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        found_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String found_item = found_found_item.getText().toString().trim();
                String foundDescription = foundDescriptionEnter.getText().toString().trim();
                String foundLocation = foundLocationEnter.getText().toString().trim();
                String foundReward = foundMoneyReward.getText().toString().trim();
                int moneyReward;
                if (!foundReward.equals("")) {
                    moneyReward = Integer.parseInt(foundReward);
                } else {
                    moneyReward = 0;
                }

                if (!found_item.equals("")) {
                    UserDetails.getCurrentUser().addFoundItem(found_item,
                            foundDescription,
                            foundLocation,
                            foundCategorySpinner.getSelectedItem().toString(),
                            foundTypeSpinner.getSelectedItem().toString(),
                            moneyReward,
                            UserDetails.getCurrentUser().getUsername());
                    found_found_item.setText("");
                    Toast.makeText(FoundItemActivity.this, "You have added found item", Toast.LENGTH_SHORT).show();
                } else {
                    //display an alert while user's Name is invalid
                    AlertDialog.Builder dialog0 = new AlertDialog.Builder(FoundItemActivity.this);
                    dialog0.setTitle("Invalid input");
                    dialog0.setMessage("Please enter valid input")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    found_found_item.setText("");
                }
            }
        });
    }

    /**
     * go to main page
     */
    private void goToMain() {
        FoundItemActivity.this.startActivity(new Intent(FoundItemActivity.this, MainActivity.class));
    }
}
