package de.hhbk.de.cb;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

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
