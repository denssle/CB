package de.hhbk.de.cb;

import android.app.Activity;
import android.view.View;

/**
 * Created by admin on 29.09.15.
 */
public class UpdateUserController implements View.OnClickListener {
    private Activity activity;

    public UpdateUserController(UpdateUserActivity updateUserActivity) {
        this.activity = updateUserActivity; // for intent
    }

    @Override
    public void onClick(View v) {
        debug.getInt().message("onClick: " +v.getId());
    }
}
