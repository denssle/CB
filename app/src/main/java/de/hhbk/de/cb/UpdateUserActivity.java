package de.hhbk.de.cb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by admin on 24.09.15.
 */
public class UpdateUserActivity extends AppCompatActivity {
    private User currentUser;
    private EditText fornameEditText;
    private EditText lastnameEditText;
    private EditText titleEditText;
    private EditText shortEditText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        currentUser = LoginController.getUser();
        try {
            this.fornameEditText = (EditText) findViewById(R.id.updateTextFieldForname);
            fornameEditText.setText(currentUser.getForname());

            this.lastnameEditText = (EditText) findViewById(R.id.updateTextFieldLastname);
            lastnameEditText.setText(currentUser.getLastname());

            this.titleEditText = (EditText) findViewById(R.id.updateTextFieldTitle);
            titleEditText.setText(currentUser.getTitle());

            this.shortEditText = (EditText) findViewById(R.id.updateTextFieldShortname);
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

    public void updateUser() {
        currentUser.setForname(fornameEditText.getText().toString());
        currentUser.setLastname(lastnameEditText.getText().toString());
        currentUser.setTitle(titleEditText.getText().toString());
        currentUser.setShortname(shortEditText.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenu menu = new DropdownMenu();
        int id = item.getItemId();
        return menu.manageMenu(id, this);
    }
}
