package plus1s.app.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import plus1s.app.R;

public class LostItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item);

        Button lost_cancel = (Button)findViewById(R.id.lost_cancel);

        lost_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });
    }

    private void goToMain() {
        Intent MainIntent = new Intent(LostItemActivity.this, MainActivity.class);
        LostItemActivity.this.startActivity(MainIntent);
    }
}
