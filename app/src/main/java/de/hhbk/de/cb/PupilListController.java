package de.hhbk.de.cb;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;

/**
 * Created by dominik on 07.10.15.
 */
public class PupilListController implements View.OnClickListener {
    private Activity activity;
    public PupilListController(ListActivity activity) {
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        activity.startActivity(new Intent(activity, MenueActivity.class));
    }
}
