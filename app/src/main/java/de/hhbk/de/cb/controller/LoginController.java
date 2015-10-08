package de.hhbk.de.cb.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.view.*;
import android.widget.Toast;
import android.content.Intent;
import org.json.JSONObject;

import de.hhbk.de.cb.model.User;
import de.hhbk.de.cb.other.WebConnection;
import de.hhbk.de.cb.activitys.MenueActivity;
import de.hhbk.de.cb.other.debug;

/**
 * Created by admin on 10.09.15.
 */
public class LoginController implements View.OnClickListener {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private static User user;
    private Activity loginActivity;

    public LoginController(EditText editTextUsername, EditText editTextPassword, Activity loginActivity) {
        this.editTextUsername = editTextUsername;
        this.editTextPassword = editTextPassword;
        this.loginActivity = loginActivity;
        user = new User();
    }

    public void onClick(View v) {
        String name =editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (offlineCheck(name, password)) {
            loginActivity.startActivity(new Intent(loginActivity, MenueActivity.class));
        } else {
            if(onlineCheck(name, password, v)) {
                loginActivity.startActivity(new Intent(loginActivity, MenueActivity.class));
            }
        }
    }

    private boolean offlineCheck(String name, String password) {
        try {
            if (user.isPasswordCorrect(password)&& user.isUsernameCorrect(name)) {
                return true;
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Boolean onlineCheck(String name, String password, View view) {
        JSONObject result = null;
        AsyncTask.Status status;
        try
        {
            WebConnection task = new WebConnection();
            task.execute(name, password);
            status = task.getStatus();
            debug.getInt().message("Status: " + status);
            result = task.get();
            debug.getInt().message("Erfolg: " + result);
            String success = (String) result.get("success");
            if (success.equals("1")) {
                toastToast("Login erfolgreich.", view);
                user.init(name, password, result);
                return true;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        toastToast("Login gescheitert.", view);
        return false;
    }

    private void toastToast(String output, View view) {
        Toast toastAusgabe=Toast.makeText(view.getContext(), output, Toast.LENGTH_SHORT);
        toastAusgabe.show();
    }

    public static User getUser(){
        return user;
    }
}
