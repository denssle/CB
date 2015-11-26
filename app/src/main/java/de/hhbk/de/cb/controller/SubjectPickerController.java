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

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.PupilListActivity;
import de.hhbk.de.cb.activitys.SubjectPickerActivity;
import de.hhbk.de.cb.model.SchoolClass;
import de.hhbk.de.cb.model.SchoolSubject;
import de.hhbk.de.cb.other.DummyDataLand;

/**
 * Created by dominik on 14.10.15.
 */
@SuppressLint("ValidFragment")
public class SubjectPickerController extends ListFragment {
    private String[] values;
    private Activity activity;
    private static SchoolSubject schoolSubject;
    private SchoolClass schoolClass;

    @SuppressLint("ValidFragment")
    public SubjectPickerController(SubjectPickerActivity activity) {
        this.schoolClass = DummyDataLand.getInt().getSchoolClassByName(SchoolClassPickerController.getSchoolClass()); //TODO Hier muss dann ein DB Anschluss hin!
        this.values = schoolClass.getSubjectsAsString();
        this.activity = activity;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        schoolSubject = schoolClass.getSubjectByName(values[position]);
        activity.startActivity(new Intent(activity, PupilListActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), R.layout.list_entry, R.id.shoolClassEntry,
                values);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public static SchoolSubject getSubject() {
        return schoolSubject;
    }

}
