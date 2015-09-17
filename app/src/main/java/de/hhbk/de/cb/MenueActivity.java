package de.hhbk.de.cb;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.net.URL;

/**
 * Created by admin on 10.09.15.
 */
public class MenueActivity extends AppCompatActivity {
    private User currentUser;
    private MySQLConnection sqlConnection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);
        //this.setTitle("Main");
        currentUser = LoginController.getUser();
        TextView textView = (TextView) findViewById(R.id.textUserName);
        textView.setText(currentUser.getName());
        //setHasOptionsMenu(true);
        sqlConnection = new MySQLConnection();
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
            sqlConnection.doInBackground();
            return true;
        }
        else if(id == R.id.action_user) {
            debug.getInt().message("Menue: USR");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
