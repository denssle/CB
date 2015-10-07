package de.hhbk.de.cb;


import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.09.15.
*/
public class PupilListActivity extends ListActivity {
    private List<Schoolclass> schoolclasses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupillist);
        this.schoolclasses = buildClasses();
        String[] values = makeStringsOutOfClasses(schoolclasses);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_entry, R.id.pupillistEntry, values);
        setListAdapter(adapter);

        PupilListController controller = new PupilListController(this);
        Button buttonback = (Button) findViewById(R.id.pupillistButton);
        buttonback.setOnClickListener(controller);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " !", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);
        debug.getInt().message("PupilListAc: onCreateOptionsMenu: "+super.onCreateOptionsMenu(menu));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DropdownMenu menu = new DropdownMenu();
        int id = item.getItemId();
        return menu.manageMenu(id, this);
    }

    private List<Schoolclass> buildClasses() {
        List<Schoolclass> schoolclasses = new ArrayList<>();
        String[] classnames = {"Jahrgang 01","Jahrgang 02", "Jahrgang 03", "Jahrgang 04"};
        String[] lastnames = {"Agalisiore", "Athoe", "Briususaili", "Faumeti", "Gent", "Hocacn", "Jotanic", "Lyber", "Moimarileio", "Moion", "Nenchio", "Oeoron", "Pesia", "Pial", "Polceronu", "Rtheg", "Tesisthr", "Usarole", "Usoeod", "Ymonod","Bisse",
                "Disicrumuri", "Duturidi", "Entag", "Farampre", "Ganasi", "Gertheusiu", "Icis", "Iolyr", "Joprtan", "Lasclaba", "Osthusares", "Regarp", "Rsmnteth", "Sion", "Ticoner", "Usica", "Vialic", "Ytusilu", "Zenot"};
        String[] fornames = {"Astral Dancer", "Jasminebeats", "Amethyst Tinsel", "Berryjoe", "Pumpkin Set", "Bubble Blazer", "Dream Dasher", "Amethyst Toffee", "Foresthunt", "Hazel Vinyl", "Laughmarch", "Lemon Sparkle", "Polishfly", "Persimmonsstrudel Breeze", "Rainbow Voyager", "Rainbow Sweets", "Shore Lightning", "Silk Rocket", "Stampbuds", "Twilight Rhyme",
                "Charming Starlight", "Star Ashes", "Emeraldaura", "Evening Light", "Shadeflurry Punch", "Treasurepop", "Jade Flame", "Joy Pastels", "Mahogany Sage", "Marble Riff", "Meadow Toffee", "Moonlight Twirler", "Peach Break", "Rain Gears", "Route Will", "Scrolldrop", "Spring Masher", "Timelink", "Trickssky", "Wave Sweets"};

        for(int i = 0; i<4; i++){
            Schoolclass schoolclass = new Schoolclass(classnames[i]);

            for(int j = 0; j<10; j++) {
                debug.getInt().message("i: "+i+" j: "+j+" name: "+fornames[j]+" "+lastnames[j]);
                Pupil pupil = new Pupil();
                pupil.setForname(fornames[j]);
                pupil.setLastname(lastnames[j]);
                pupil.setSchoolclass(schoolclass);
                schoolclass.addPupil(pupil);
            }
            schoolclasses.add(schoolclass);
        }
        return schoolclasses;
    }
    private String[] makeStringsOutOfClasses(List<Schoolclass> schoolclasses) {
        String[] result = new String[schoolclasses.size()];
        for (int i=0; i<schoolclasses.size(); i++) {
            result[i]=schoolclasses.get(i).getClassname();
        }
        return result;
    }
}