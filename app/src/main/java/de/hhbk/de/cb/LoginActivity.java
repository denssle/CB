package de.hhbk.de.cb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText editTextUsername=(EditText) findViewById(R.id.textFieldName);
        EditText editTextPassword=(EditText) findViewById(R.id.textFieldPassword);

        User user = new User();
        user.setName("Heinrich");
        user.setPassword("Hertz");

        LoginController loginController = new LoginController(user, editTextUsername, editTextPassword, this);
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(loginController);
    }
}