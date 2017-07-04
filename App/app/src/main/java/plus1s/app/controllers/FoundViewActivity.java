package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import plus1s.app.R;

public class FoundViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_view);

        final TextView found_view_back = (TextView) findViewById(R.id.found_view_back);
        final ListView found_view_list = (ListView) findViewById(R.id.found_view_list);

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
}
