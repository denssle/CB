package de.hhbk.de.cb.activitys;


import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hhbk.de.cb.controller.DatePickerController;
import de.hhbk.de.cb.other.DropdownMenu;
import de.hhbk.de.cb.model.Pupil;
import de.hhbk.de.cb.controller.PupilListController;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.model.Schoolclass;
import de.hhbk.de.cb.other.debug;
import de.hhbk.de.cb.other.strings;

/**
 * Created by admin on 22.09.15.
*/
public class PupilListActivity extends ListActivity {
    private Map<String, Schoolclass> schoolclasses;
    private PupilListController controller;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupillist);
        this.schoolclasses = buildClasses();
        String[] values = makeStringsOutOfClasses(schoolclasses);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_entry, R.id.shoolClassEntry, values);
        setListAdapter(adapter);

        button = (Button) findViewById(R.id.pupillistButton);
        this.controller = new PupilListController(this, button);
        button.setOnClickListener(controller);
        button.setText(strings.back);

        TextView dateText = (TextView) findViewById(R.id.pupillistDate);
        dateText.setText(DatePickerController.getDate());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        if (schoolclasses.containsKey(item)) {
            Schoolclass theChosenOne = schoolclasses.get(item);
            Toast.makeText(this, item +theChosenOne.getID()+ " !", Toast.LENGTH_LONG).show();
            showSchoolClass(theChosenOne);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);
        debug.getInt().message("PupilListAc: onCreateOptionsMenu: " + super.onCreateOptionsMenu(menu));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenu menu = new DropdownMenu();
        int id = item.getItemId();
        return menu.manageMenu(id, this);
    }

    /*
    * Aendert den Inhalt der ListView von Klassen auf Schueler sowie den "Zurueck"Button zu einem "Speichern" Button.
     */
    private void showSchoolClass(Schoolclass sclass) {
        String[] values = new String[sclass.getNumberOfPupils()];
        List<Pupil> pupils = sclass.getPupils();
        for(int i = 0; i<sclass.getNumberOfPupils(); i++) {
            values[i] = pupils.get(i).getForname() +" "+ pupils.get(i).getLastname();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.pupil_entry, R.id.pubilEntryText, values);
        setListAdapter(adapter);
        button.setText(strings.save);
    }

    /*
    * Erzeugt Dummydaten.
    */
    private Map<String, Schoolclass> buildClasses() {
        Map<String,Schoolclass> schoolclasses = new HashMap<>();
        String[] classnames = {"FUU 02","BAA", "YOLO", "HHBK"};
        String[] lastnames = {"Agalisiore", "Athoe", "Briususaili", "Faumeti", "Gent", "Hocacn", "Jotanic", "Lyber", "Moimarileio", "Moion", "Nenchio", "Oeoron", "Pesia", "Pial", "Polceronu", "Rtheg", "Tesisthr", "Usarole", "Usoeod", "Ymonod","Bisse",
                "Disicrumuri", "Duturidi", "Entag", "Farampre", "Ganasi", "Gertheusiu", "Icis", "Iolyr", "Joprtan", "Lasclaba", "Osthusares", "Regarp", "Rsmnteth", "Sion", "Ticoner", "Usica", "Vialic", "Ytusilu", "Zenot"};
        String[] fornames = {"Astral Dancer", "Jasminebeats", "Amethyst Tinsel", "Berryjoe", "Pumpkin Set", "Bubble Blazer", "Dream Dasher", "Amethyst Toffee", "Foresthunt", "Hazel Vinyl", "Laughmarch", "Lemon Sparkle", "Polishfly", "Persimmonsstrudel Breeze", "Rainbow Voyager", "Rainbow Sweets", "Shore Lightning", "Silk Rocket", "Stampbuds", "Twilight Rhyme",
                "Charming Starlight", "Star Ashes", "Emeraldaura", "Evening Light", "Shadeflurry Punch", "Treasurepop", "Jade Flame", "Joy Pastels", "Mahogany Sage", "Marble Riff", "Meadow Toffee", "Moonlight Twirler", "Peach Break", "Rain Gears", "Route Will", "Scrolldrop", "Spring Masher", "Timelink", "Trickssky", "Wave Sweets"};

        for(int i = 0; i<4; i++){
            Schoolclass schoolclass = new Schoolclass(classnames[i]);

            for(int j = 10*i; j<10*(i+1); j++) {
                debug.getInt().message("i: "+i+" j: "+j+" name: "+fornames[j]+" "+lastnames[j]);
                Pupil pupil = new Pupil();
                pupil.setForname(fornames[j]);
                pupil.setLastname(lastnames[j]);
                pupil.setSchoolclass(schoolclass);
                schoolclass.addPupil(pupil);
            }
            schoolclasses.put(schoolclass.getClassname(),schoolclass);
        }
        return schoolclasses;
    }
    private String[] makeStringsOutOfClasses(Map<String,Schoolclass> classes) {
        String[] result = new String[classes.size()];
        result = classes.keySet().toArray(result);
        return result;
    }

    /**
    *Kehr zur Klassenuebersicht zurueck.
    */
    public void backToTheRoot() {
        String[] values = makeStringsOutOfClasses(schoolclasses);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_entry, R.id.shoolClassEntry, values);
        setListAdapter(adapter);
        button.setText(strings.back);
    }
}