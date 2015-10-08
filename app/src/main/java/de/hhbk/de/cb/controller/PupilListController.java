package de.hhbk.de.cb.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.MenueActivity;
import de.hhbk.de.cb.activitys.PupilListActivity;
import de.hhbk.de.cb.other.debug;
import de.hhbk.de.cb.other.strings;

/**
 * Created by dominik on 07.10.15.
 */
public class PupilListController implements View.OnClickListener {
    private PupilListActivity activity;
    private Button button;

    public PupilListController(PupilListActivity activity, Button button) {
        this.activity = activity;
        this.button = button;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.pupillistButton) {
            debug.getInt().message("Controll:" + button.getText());
            if(button.getText().equals(strings.back)) {
                activity.startActivity(new Intent(activity, MenueActivity.class));
            }
            if(button.getText().equals(strings.save)) {
                activity.backToTheRoot();
            }
        }
    }
}
