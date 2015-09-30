package de.hhbk.de.cb;

import android.content.Intent;
import android.view.View;

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
