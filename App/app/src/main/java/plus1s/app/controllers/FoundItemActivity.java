package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import plus1s.app.R;
import plus1s.app.model.FoundItem;

public class FoundItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_item);

        final Button found_back = (Button) findViewById(R.id.found_back);

        found_back.setOnClickListener(new View.OnClickListener() {
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
        FoundItemActivity.this.startActivity(new Intent(FoundItemActivity.this, MainActivity.class));
    }
}
