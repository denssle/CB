package de.hhbk.de.cb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 25.09.15.
 */
public class PupillistFragment extends Fragment {

    public PupillistFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String [] strings = {
                "Bla","Fuu", "Bar","Yo!"
        };
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        getActivity(), // Die aktuelle Umgebung (diese Activity)
                        R.layout.activity_pupillist, // ID der XML-Layout Datei
                        R.id.pupillistEntry, // ID des TextViews
                        stringList); // Beispieldaten in einer ArrayList

        View rootView = inflater.inflate(R.layout.activity_pupillist, container, false);

        ListView aktienlisteListView = (ListView) rootView.findViewById(R.id.listView);
        aktienlisteListView.setAdapter(adapter);
        return rootView;
    }
}
