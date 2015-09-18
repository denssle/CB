package de.hhbk.de.cb;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by admin on 10.09.15.
 */
public class MenueActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_menue);
        //this.setTitle("Main");
        currentUser = LoginController.getUser();
        TextView textView = (TextView) findViewById(R.id.textUserName);
        textView.setText(currentUser.getForname()+" "+currentUser.getLastname());
        //setHasOptionsMenu(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.dropdown_menue, menu);
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            debug.getInt().message("Menue: Settings");
            return true;
        }
        else if(id == R.id.action_user) {
            debug.getInt().message("Menue: USR");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
