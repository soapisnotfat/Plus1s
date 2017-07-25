package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import plus1s.app.R;
import plus1s.app.model.FoundItem;
import plus1s.app.model.Item;
import plus1s.app.model.ItemCategory;
import plus1s.app.model.ItemType;
import plus1s.app.model.LostItem;
import plus1s.app.model.UserDetails;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final TextView search_cancel = (TextView) findViewById(R.id.search_cancel);
        final TextView search_back = (TextView) findViewById(R.id.search_back);
        final EditText search_item_name = (EditText) findViewById(R.id.search_item_name);
        final Button search_search = (Button) findViewById(R.id.search_search_button);
        final Spinner search_category = (Spinner) findViewById(R.id.search_category_spinner);
        final Spinner search_type = (Spinner) findViewById(R.id.search_type_spinner);

        ArrayAdapter<String> category_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, validCategory());
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_category.setAdapter(category_adapter);

        ArrayAdapter<String> type_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, validType());
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_type.setAdapter(type_adapter);

        search_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_category = search_category.getSelectedItem().toString();
                String current_type = search_type.getSelectedItem().toString();
                String current_name = search_item_name.getText().toString().trim();

                // if name inout is not detected, return all items by default
                if (current_name.equals("")) {
                    Item.searchList.addAll(correspondingArray(current_type, current_category));
                } else {
                    ArrayList<String> e = new ArrayList<>();
                    for (String i : correspondingArray(current_type, current_category)) {
                        if (i.equals(current_name)) {
                            e.add(i);
                        }
                    }
                    Item.searchList.addAll(e);
                }
                goToSearchResult();
            }
        });

        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        search_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_item_name.setText("");
                search_category.setSelection(0);
                search_type.setSelection(0);
            }
        });
    }

    /**
     * go to main page
     */
    private void goToMain() {
        SearchActivity.this.startActivity(new Intent(SearchActivity.this, MainActivity.class));
    }

    /**
     * go to result page
     */
    private void goToSearchResult() {
        SearchActivity.this.startActivity(new Intent(SearchActivity.this, SearchResultActivity.class));
    }

    /**
     * display valid categories for category spinner
     *
     * @return a list of all categories
     */
    private List<String> validCategory() {
        List<String> output = new ArrayList<>();
        output.add("All Categories");
        output.add(ItemCategory.HEIRLOOMS.toString());
        output.add(ItemCategory.KEEPSAKES.toString());
        output.add(ItemCategory.MISC.toString());
        return output;
    }

    /**
     * display valid types for types spinner
     *
     * @return a list of all types
     */
    private List<String> validType() {
        List<String> output = new ArrayList<>();
        output.add("All Types");
        output.add(ItemType.FOUND.toString());
        output.add(ItemType.LOST.toString());
        output.add(ItemType.NEED.toString());
        return output;
    }

    /**
     * return all lost items
     *
     * @return all lost items
     */
    private ArrayList<Item> returnAllLost() {
        ArrayList<Item> temp = new ArrayList<>();
        for (Map.Entry<String, Item> entry: LostItem.getLostItems().entrySet()) {
            temp.add(entry.getValue());
        }
        return temp;
    }

    /**
     * return all found items
     *
     * @return all found items
     */
    private ArrayList<Item> returnAllFound() {
        ArrayList<Item> temp = new ArrayList<>();
        for (Map.Entry<String, Item> entry: FoundItem.getFoundItems().entrySet()) {
            temp.add(entry.getValue());
        }
        return temp;
    }

    /**
     * return all items
     *
     * @return all items
     */
    private ArrayList<Item> returnAllItem() {
        ArrayList<Item> temp = new ArrayList<>();
        temp.addAll(returnAllLost());
        temp.addAll(returnAllFound());
        return temp;
    }

    /**
     * return personal lost items
     *
     * @return personal lost items
     */
    private ArrayList<Item> returnPersonalLost() {
        ArrayList<Item> temp = new ArrayList<>();
        for (Map.Entry<String, Item> entry: UserDetails.getCurrentUser().getItems().entrySet()) {
            if (entry.getValue().getType().equals("LOST")) {
                temp.add(entry.getValue());
            }
        }
        return temp;
    }

    /**
     * return the search result list
     *
     * @param type item's type
     * @param category item's category
     * @return search result list
     */
    private ArrayList<String> correspondingArray(String type, String category) {
        ArrayList<Item> personalLost = returnPersonalLost();
        ArrayList<Item> allLost = returnAllLost();
        ArrayList<Item> allFound = returnAllFound();
        ArrayList<Item> allItem = returnAllItem();
        ArrayList<String> output = new ArrayList<>();

        if (type.equals("FOUND")) {
            if (category.equals("All Categories")) {
                for (Item i : allFound) {
                    output.add(i.getName());
                }
            }
            if (category.equals("HEIRLOOMS")) {
                for (Item i : allFound) {
                    if (i.getCategory().equals("HEIRLOOMS")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("KEEPSAKES")) {
                for (Item i : allFound) {
                    if (i.getCategory().equals("KEEPSAKES")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("MISC")) {
                for (Item i : allFound) {
                    if (i.getCategory().equals("MISC")) {
                        output.add(i.getName());
                    }
                }
            }
        }

        if (type.equals("LOST")) {
            if (category.equals("All Categories")) {
                for (Item i : allLost) {
                    output.add(i.getName());
                }
            }
            if (category.equals("HEIRLOOMS")) {
                for (Item i : allLost) {
                    if (i.getCategory().equals("HEIRLOOMS")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("KEEPSAKES")) {
                for (Item i : allLost) {
                    if (i.getCategory().equals("KEEPSAKES")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("MISC")) {
                for (Item i : allLost) {
                    if (i.getCategory().equals("MISC")) {
                        output.add(i.getName());
                    }
                }
            }
        }

        if (type.equals("All Types")) {
            if (category.equals("All Categories")) {
                for (Item i : allItem) {
                    output.add(i.getName());
                }
            }
            if (category.equals("HEIRLOOMS")) {
                for (Item i : allItem) {
                    if (i.getCategory().equals("HEIRLOOMS")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("KEEPSAKES")) {
                for (Item i : allItem) {
                    if (i.getCategory().equals("KEEPSAKES")) {
                        output.add(i.getName());
                    }
                }
            }
            if (category.equals("MISC")) {
                for (Item i : allItem) {
                    if (i.getCategory().equals("MISC")) {
                        output.add(i.getName());
                    }
                }
            }
        }
        return output;
    }
}
