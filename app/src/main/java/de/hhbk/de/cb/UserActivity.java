package de.hhbk.de.cb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 22.09.15.
 */
public class UserActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        currentUser = LoginController.getUser();
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
        inflater.inflate(R.menu.dropdown_menue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenue menue = new DropdownMenue();
        int id = item.getItemId();
        return menue.manageMenue(id, this);
    }
}
