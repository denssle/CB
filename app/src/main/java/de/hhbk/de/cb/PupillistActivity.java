package de.hhbk.de.cb;


import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by admin on 22.09.15.
*/

public class PupillistActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[] {"Jahrgang 01","Jahrgang 02", "Jahrgang 03", "Jahrgang 04"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_entry, R.id.pupillistEntry, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " !", Toast.LENGTH_LONG).show();
    }
}