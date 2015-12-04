package de.hhbk.de.cb.activitys;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.SchoolClassPickerController;
import de.hhbk.de.cb.menus.DropdownMenu;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
public class SchoolClassPickerActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolclasspicker);

        // Fallunterscheidung, ob ein neues Ding angelegt werden soll oder ob ein bestethendes bearbeitet werden muss.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean new_entry  = sp.getBoolean("new_entry", false);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            SchoolClassPickerController list = new SchoolClassPickerController(this, new_entry);
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }

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
