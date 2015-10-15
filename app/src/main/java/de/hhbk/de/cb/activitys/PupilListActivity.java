package de.hhbk.de.cb.activitys;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.PupilListController;
import de.hhbk.de.cb.menus.DropdownMenu;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
public class PupilListActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupillist);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            PupilListController list = new PupilListController(this);
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu_pupillist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenu menu = new DropdownMenu();
        int id = item.getItemId();
        return menu.pupilListMenu(id, this);
    }

    public void savePresence() {
        debug.getInt().message("Speichere Anwesenheit. Nicht!");
    }
}
