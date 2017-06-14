package plus1s.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterAvticity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_avticity);

        final EditText reg_name = (EditText) findViewById(R.id.reg_name);
        final EditText reg_username = (EditText) findViewById(R.id.reg_user);
        final EditText reg_password = (EditText) findViewById(R.id.reg_password);
        final EditText reg_passowrd_confirm = (EditText) findViewById(R.id.reg_pass_confirm);
        final Button reg_register = (Button) findViewById(R.id.reg_register);

    }
}
