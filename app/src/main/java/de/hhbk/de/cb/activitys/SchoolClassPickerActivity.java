package de.hhbk.de.cb.activitys;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.DatePickerController;
import de.hhbk.de.cb.controller.SchoolClassPickerController;
import de.hhbk.de.cb.model.SchoolClass;
import de.hhbk.de.cb.other.DropdownMenu;
import de.hhbk.de.cb.other.DummyDataLand;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
public class SchoolClassPickerActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolclasspicker);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            SchoolClassPickerController list = new SchoolClassPickerController(this);
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }

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
