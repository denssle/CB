package de.hhbk.de.cb;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by admin on 29.09.15.
 */
public class UserActivityController implements View.OnClickListener {
    private Activity activity;

    public UserActivityController(UserActivity userActivity) {
        this.activity = userActivity;
    }

    @Override
    public void onClick(View v) {
        activity.startActivity(new Intent(activity, UpdateUserActivity.class));
    }
}
