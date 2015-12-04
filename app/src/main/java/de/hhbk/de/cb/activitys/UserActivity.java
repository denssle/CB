package de.hhbk.de.cb.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import de.hhbk.de.cb.menus.DropdownMenu;
import de.hhbk.de.cb.controller.LoginController;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.model.User;
import de.hhbk.de.cb.controller.UserActivityController;

/**
 * Created by admin on 22.09.15.
 */
public class UserActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        User currentUser = LoginController.getUser();
        TextView fornameTextField = (TextView) findViewById(R.id.textFieldForname);
        fornameTextField.setText(currentUser.getForname());

        TextView lastnameTextField = (TextView) findViewById(R.id.textFieldLastname);
        lastnameTextField.setText(currentUser.getLastname());

        TextView titleTextField = (TextView) findViewById(R.id.textFieldTitle);
        titleTextField.setText(currentUser.getTitle());

        TextView shortTextField = (TextView) findViewById(R.id.textFieldShortname);
        shortTextField.setText(currentUser.getShortname());

        UserActivityController controller = new UserActivityController(this);
        Button updateButton = (Button) findViewById(R.id.updateUserButton);
        updateButton.setOnClickListener(controller);
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
