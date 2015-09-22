package de.hhbk.de.cb;

/**
 * Created by admin on 22.09.15.
 */
public class PupillistActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_pupillist);
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
