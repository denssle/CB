package de.hhbk.de.cb.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hhbk.de.cb.controller.LoginController;
import de.hhbk.de.cb.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText editTextUsername=(EditText) findViewById(R.id.textFieldName);
        EditText editTextPassword=(EditText) findViewById(R.id.textFieldPassword);

        LoginController loginController = new LoginController(editTextUsername, editTextPassword, this);
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(loginController);
    }
}