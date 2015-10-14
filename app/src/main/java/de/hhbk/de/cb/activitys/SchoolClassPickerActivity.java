package de.hhbk.de.cb.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.DatePickerController;
import de.hhbk.de.cb.other.DropdownMenu;

/**
 * Created by dominik on 14.10.15.
 */
public class SchoolClassPickerActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolclasspicker);
        TextView dateText = (TextView) findViewById(R.id.schoolclasspickerdate);
        dateText.setText(DatePickerController.getDate());

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
