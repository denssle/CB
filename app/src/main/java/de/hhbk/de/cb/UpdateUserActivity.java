package de.hhbk.de.cb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

/**
 * Created by admin on 24.09.15.
 */
public class UpdateUserActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        currentUser = LoginController.getUser();
        try {
            EditText fornameEditText = (EditText) findViewById(R.id.updateTextFieldForname);
            fornameEditText.setText(currentUser.getForname());

            EditText lastnameEditText = (EditText) findViewById(R.id.updateTextFieldLastname);
            lastnameEditText.setText(currentUser.getLastname());

            EditText titleEditText = (EditText) findViewById(R.id.updateTextFieldTitle);
            titleEditText.setText(currentUser.getTitle());

            EditText shortEditText = (EditText) findViewById(R.id.updateTextFieldShortname);
            shortEditText.setText(currentUser.getShortname());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        UpdateUserController controller = new UpdateUserController(this);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(controller);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(controller);
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
