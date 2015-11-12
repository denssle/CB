package de.hhbk.de.cb.activitys;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.controller.PupilListController;
import de.hhbk.de.cb.menus.DropdownMenu;

/**
 * Created by dominik on 14.10.15.
 */
public class PupilListActivity extends AppCompatActivity {
    private PupilListController pupilListController;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupillist);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            pupilListController = new PupilListController();
            fm.beginTransaction().add(android.R.id.content, pupilListController).commit();
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

    private void toastToast(String output) {
        View v = findViewById(android.R.id.content);
        Toast toastAusgabe=Toast.makeText(v.getContext(), output, Toast.LENGTH_SHORT);
        toastAusgabe.show();
    }

    public void savePresence() {
        toastToast("Anwesenheit gespeichert.");
        pupilListController.savePresence();
    }
}
