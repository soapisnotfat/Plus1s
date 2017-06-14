package plus1s.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        final EditText reg_name = (EditText) findViewById(R.id.reg_name);
        final EditText reg_username = (EditText) findViewById(R.id.reg_user);
        final EditText reg_password = (EditText) findViewById(R.id.reg_password);
        final EditText reg_password_confirm = (EditText) findViewById(R.id.reg_pass_confirm);
        final Button reg_register = (Button) findViewById(R.id.reg_register);

        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = reg_name.getText().toString();
                String username = reg_username.getText().toString();
                String password_1 = reg_password_confirm.getText().toString();
                String password_2 = reg_password.getText().toString();
                if (password_1.equals(password_2)) {
                    User RegisteredUser = new User(name, username, password_1);
                }
                //TODO: implement the beep while passwords don't match
            }
        });
    }
}
