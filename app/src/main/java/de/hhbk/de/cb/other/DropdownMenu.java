package de.hhbk.de.cb.other;

import android.app.Activity;
import android.content.Intent;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.DatePickerActivity;
import de.hhbk.de.cb.activitys.SettingsActivity;
import de.hhbk.de.cb.activitys.UserActivity;

/**
 * Created by admin on 22.09.15.
 */
public class DropdownMenu {
    public boolean manageMenu(int id, Activity menueActivity) {
        if (id == R.id.action_settings) {
            debug.getInt().message("Menu: Settings");
            menueActivity.startActivity(new Intent(menueActivity, SettingsActivity.class));
            return true;
        } else if(id == R.id.action_user) {
            debug.getInt().message("Menu: User");
            menueActivity.startActivity(new Intent(menueActivity, UserActivity.class));
            return true;
        } else if(id == R.id.action_pupillist) {
            debug.getInt().message("Menu: Schuelerliste");
            menueActivity.startActivity(new Intent(menueActivity, DatePickerActivity.class));
            return true;
        }
        return false;
    }
}
