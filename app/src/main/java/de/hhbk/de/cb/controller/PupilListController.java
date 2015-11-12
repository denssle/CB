package de.hhbk.de.cb.controller;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Map;

import de.hhbk.de.cb.model.Lesson;
import de.hhbk.de.cb.model.Pupil;
import de.hhbk.de.cb.model.SchoolClass;
import de.hhbk.de.cb.model.SchoolSubject;
import de.hhbk.de.cb.other.DummyDataLand;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 14.10.15.
 */
@SuppressLint("ValidFragment")
public class PupilListController extends ListFragment {
    private String[] values;
    private Map<Pupil,Boolean> presenceMap;
    private SchoolClass schoolClass;
    private ArrayAdapter<String> adapter;

    @SuppressLint("ValidFragment")
    public PupilListController() {
        this.presenceMap = new HashMap<>();
        this.schoolClass = DummyDataLand.getInt().getSchoolClassByName(SchoolClassPickerController.getSchoolClass()); //Hier muss dann ein DB Anschluss hin!
        for (Pupil pupil : schoolClass.getPupils()) {
            this.presenceMap.put(pupil,true);
        }
        this.values = schoolClass.getNameOfPupils();
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //activity.startActivity(new Intent(activity, MenueActivity.class))
        debug.getInt().message("OnListenItemClick: Pos.: " + position + " Name: " + values[position]);
        Pupil pupil = schoolClass.getPupilByFullName(adapter.getItem(position));
        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l.setItemChecked(position, changePresence(pupil));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_multiple_choice, values);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private boolean changePresence(Pupil pupil) {
        if(presenceMap.get(pupil)) {
            presenceMap.put(pupil,false);
        } else {
            presenceMap.put(pupil,true);
        } return presenceMap.get(pupil);
    }

    public void savePresence() {
        String date = DatePickerController.getDate();
        SchoolSubject subject = SubjectPickerController.getSubject();
        debug.getInt().message("Date: "+date+" Subject: "+subject.getName()+" Klasse: "+schoolClass.getClassname() + " Anwesenheit: " + presenceMap.keySet());
        Lesson lesson = new Lesson(date, subject, schoolClass, presenceMap);
        DummyDataLand.saveLesson(lesson); //TODO
    }
}
