package de.hhbk.de.cb;

import android.app.Activity;
import android.widget.EditText;
import android.view.*;
import android.widget.Toast;
import android.content.Intent;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by admin on 10.09.15.
 */
public class LoginController implements View.OnClickListener {
    private EditText editTextUsername;
    private EditText editTextPasswort;
    private static User user;
    private Activity loginActivity;

    public LoginController(User user, EditText editTextUsername, EditText editTextPasswort, Activity loginActivity) {
        this.user = user;
        this.editTextUsername = editTextUsername;
        this.editTextPasswort = editTextPasswort;
        this.loginActivity = loginActivity;
    }

    public void onClick(View v) {
        String name =editTextUsername.getText().toString();
        String password =editTextPasswort.getText().toString();

        if(user.isNameCorrect(name)&&user.isPasswordCorrect(password)) {
            toastToast("Login erfolgreich", v);
            loginActivity.startActivity(new Intent(loginActivity, MenueActivity.class));
        } else {
            toastToast("Login gescheitert.", v);
        }
    }

    private void toastToast(String output, View view) {
        Toast toastAusgabe=Toast.makeText(view.getContext(), output, Toast.LENGTH_SHORT);
        toastAusgabe.show();
    }

    public static User getUser(){
        return user;
    }
}
