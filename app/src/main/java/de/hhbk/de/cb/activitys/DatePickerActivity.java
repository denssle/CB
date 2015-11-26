package de.hhbk.de.cb.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.DatePickerController;
import de.hhbk.de.cb.menus.DropdownMenu;
/**
 * Created by dominik on 08.10.15.
 */
public class DatePickerActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        DatePickerController controller = new DatePickerController(this, datePicker);
        Button button = (Button) findViewById(R.id.datePickerButton);
        button.setOnClickListener(controller);
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
