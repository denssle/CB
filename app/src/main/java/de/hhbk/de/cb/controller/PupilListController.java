package de.hhbk.de.cb.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.MenueActivity;
import de.hhbk.de.cb.activitys.PupilListActivity;
import de.hhbk.de.cb.model.SchoolClass;
import de.hhbk.de.cb.other.DummyDataLand;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
@SuppressLint("ValidFragment")
public class PupilListController extends ListFragment {
    private String[] values;
    private Activity activity;

    @SuppressLint("ValidFragment")
    public PupilListController(PupilListActivity activity) {
        this.activity = activity;
        SchoolClass schoolClass = DummyDataLand.getInt().getSchoolClassByName(SchoolClassPickerController.getSchoolClass()); //Hier muss dann ein DB Anschluss hin!
        this.values = schoolClass.getNameOfPupils();
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //activity.startActivity(new Intent(activity, MenueActivity.class))
        debug.getInt().message("OnListenItemClick: Pos.: "+position+" Id: "+id+" V.id: "+v.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), R.layout.pupil_entry, R.id.pubilEntryText, values);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
