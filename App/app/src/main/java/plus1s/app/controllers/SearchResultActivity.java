package plus1s.app.controllers;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import plus1s.app.R;
import plus1s.app.model.Item;

public class SearchResultActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        final TextView search_result_back = (TextView) findViewById(R.id.search_result_back);
        final ListView search_result_list = (ListView) findViewById(R.id.search_result_list);
        img = (ImageView) findViewById(R.id.imageView3);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Item.searchList);
        search_result_list.setAdapter(adapter);
        TransitionDrawable animation = (TransitionDrawable)img.getDrawable();
        animation.startTransition(3000);
        animation.reverseTransition(3000);
//        img.setBackgroundResource(R.drawable.trans);
//        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
//        frameAnimation.start();
        search_result_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Item.searchList.clear();
                goToSearch();
            }
        });
    }

    /**
     * go to search page
     */
    private void goToSearch() {
        SearchResultActivity.this.startActivity(new Intent(SearchResultActivity.this, SearchActivity.class));
    }

}
