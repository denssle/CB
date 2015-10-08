package de.hhbk.de.cb.controller;

import android.content.Intent;
import android.view.View;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.UpdateUserActivity;
import de.hhbk.de.cb.activitys.UserActivity;

/**
 * Created by admin on 29.09.15.
 */
public class UpdateUserController implements View.OnClickListener {
    private UpdateUserActivity activity;

    public UpdateUserController(UpdateUserActivity updateUserActivity) {
        this.activity = updateUserActivity; // for intent
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.saveButton:
                activity.updateUser();
                break;
            case R.id.cancelButton:
                break;
        }
        activity.startActivity(new Intent(activity, UserActivity.class));
    }
}
