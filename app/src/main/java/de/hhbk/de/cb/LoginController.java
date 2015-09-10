package de.hhbk.de.cb;

import android.widget.EditText;
import android.view.*;
import android.widget.Toast;

/**
 * Created by admin on 10.09.15.
 */
public class LoginController implements View.OnClickListener {
    private EditText editTextUsername;
    private EditText editTextPasswort;
    private User user;

    public LoginController(User user) {
        editTextUsername=(EditText) findViewById(R.id.textFieldName);
        editTextPasswort=(EditText) findViewById(R.id.textFieldPassword);
        this.user = user;
    }

    public void onClick(View v) {
        String name =editTextUsername.getText().toString();
        String password =editTextPasswort.getText().toString();
        String output;

        if(user.isNameCorrect(name)&&user.isPasswordCorrect(password)) {
            output = "Login erfolgreich";

        } else {
            output = "Name und / oder Passwort falsch";
        }
        Toast toastAusgabe=Toast.makeText(v.getContext(),output,Toast.LENGTH_SHORT);
        toastAusgabe.show();
    }

}
