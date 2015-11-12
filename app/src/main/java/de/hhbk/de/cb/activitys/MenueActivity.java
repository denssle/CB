package de.hhbk.de.cb.activitys;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import de.hhbk.de.cb.menus.DropdownMenu;
import de.hhbk.de.cb.controller.LoginController;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.model.User;

/**
 * Created by admin on 10.09.15.
 */
public class MenueActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_menu);
        User currentUser = LoginController.getUser();
        TextView textView = (TextView) findViewById(R.id.textUserName);
        textView.setText(currentUser.getForname()+" "+ currentUser.getLastname());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu_standard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenu menu = new DropdownMenu();
        int id = item.getItemId();
        return menu.manageMenu(id, this);
    }
}
