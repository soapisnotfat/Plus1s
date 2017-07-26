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
import plus1s.app.model.Item;
import plus1s.app.model.ItemType;

import plus1s.app.model.LostItem;

public class LostViewActivity extends AppCompatActivity {
    ListView lost_view_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_view);

        final TextView lost_view_back = (TextView) findViewById(R.id.lost_view_back);
        lost_view_list = (ListView) findViewById(R.id.lost_view_list);
        final Animation fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        lost_view_list.setAnimation(fade_in_anim);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, displayLostItem());
        lost_view_list.setAdapter(adapter);
        lost_view_back.setOnClickListener(new View.OnClickListener() {
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
        LostViewActivity.this.startActivity(new Intent(LostViewActivity.this, MainActivity.class));
    }

    /**
     * display all lost items
     *
     * @return a list of all lost items
     */
    private List<String> displayLostItem() {
        ArrayList<Item> e = new ArrayList<>();
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Item> entry: LostItem.getLostItems().entrySet()) {
            e.add(entry.getValue());
        }
        for (Item i : e) {
            if (i.getType().equals(ItemType.LOST.toString())) {
                output.add(i.getName());
            }
        }
        return output;
    }
}