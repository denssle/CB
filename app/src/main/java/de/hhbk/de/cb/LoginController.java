package de.hhbk.de.cb;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.view.*;
import android.widget.Toast;
import android.content.Intent;
import org.json.JSONObject;

/**
 * Created by admin on 10.09.15.
 */
public class LoginController implements View.OnClickListener {
    private EditText editTextUsername;
    private EditText editTextPasswort;
    private static User user;
    private Activity loginActivity;

    public LoginController(EditText editTextUsername, EditText editTextPasswort, Activity loginActivity) {
        this.editTextUsername = editTextUsername;
        this.editTextPasswort = editTextPasswort;
        this.loginActivity = loginActivity;
        user = new User();
    }

    public void onClick(View v) {
        String name =editTextUsername.getText().toString();
        String password =editTextPasswort.getText().toString();
        JSONObject result = null;
        String success = "";
        String message = "Verbindung fehlerhaft.";
        AsyncTask.Status status;
        try
        {
            WebConnection task = new WebConnection();
            task.execute(name, password);
            status = task.getStatus();
            debug.getInt().message("Status: " + status);
            result = task.get();
            debug.getInt().message("Erfolg: "+result);
            success = (String) result.get("success");
            message = (String) result.get("message");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        if(success.equals("1")) {
            toastToast(message, v);
            user.init(name,password,result);
            loginActivity.startActivity(new Intent(loginActivity, MenueActivity.class));
        } else {
            toastToast(message, v);
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
