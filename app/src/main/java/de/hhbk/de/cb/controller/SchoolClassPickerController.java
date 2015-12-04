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
import de.hhbk.de.cb.activitys.SchoolClassPickerActivity;
import de.hhbk.de.cb.activitys.SubjectPickerActivity;
import de.hhbk.de.cb.other.DummyDataLand;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
@SuppressLint("ValidFragment")
public class SchoolClassPickerController extends ListFragment {
    private String[] numbers_text;
    private Activity activity;
    private static String schoolClass;

    @SuppressLint("ValidFragment")
    public SchoolClassPickerController(SchoolClassPickerActivity activity, Boolean new_entry) {
        if(new_entry) {
            this.numbers_text = DummyDataLand.getInt().getNamesOfSchoolClasses();//TODO Hier muss dann ein DB Anschluss hin!
        } else {
            this.numbers_text = DummyDataLand.getInt().getNamesOfSchoolClassesAtSpecDay(DatePickerController.getDate());
        }
        debug.getInt().message("numbers_text: " + numbers_text.length);
        this.activity = activity;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        debug.getInt().message("Simple List Fragment: "+(numbers_text[(int) id]));
        schoolClass = numbers_text[(int) id];
        activity.startActivity(new Intent(activity, SubjectPickerActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), R.layout.list_entry, R.id.shoolClassEntry,
                numbers_text);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static String getSchoolClass() {
        return schoolClass;
    }
}
