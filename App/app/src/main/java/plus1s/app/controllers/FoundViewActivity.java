package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import plus1s.app.R;
import plus1s.app.model.FoundItem;
import plus1s.app.model.Item;

public class FoundViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_view);

        final TextView found_view_back = (TextView) findViewById(R.id.found_view_back);
        final ListView found_view_list = (ListView) findViewById(R.id.found_view_list);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, displayFoundItem());
        found_view_list.setAdapter(adapter);
        final Animation fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        found_view_list.setAnimation(fade_in_anim);
        found_view_back.setOnClickListener(new View.OnClickListener() {
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
        FoundViewActivity.this.startActivity(new Intent(FoundViewActivity.this, MainActivity.class));
    }

    /**
     * display all found items
     *
     * @return a list of found items
     */
    private List<String> displayFoundItem() {
        ArrayList<Item> e = new ArrayList<>();
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Item> entry: FoundItem.getFoundItems().entrySet()) {
            e.add(entry.getValue());
        }
        for (Item i : e) {
                output.add(i.getName());
        }
        return output;
    }
}
