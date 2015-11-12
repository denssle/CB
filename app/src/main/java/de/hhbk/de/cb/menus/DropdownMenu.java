package de.hhbk.de.cb.menus;

import android.app.Activity;
import android.content.Intent;
import de.hhbk.de.cb.R;
import de.hhbk.de.cb.activitys.DatePickerActivity;
import de.hhbk.de.cb.activitys.MenueActivity;
import de.hhbk.de.cb.activitys.PupilListActivity;
import de.hhbk.de.cb.activitys.SettingsActivity;
import de.hhbk.de.cb.activitys.UserActivity;
import de.hhbk.de.cb.other.debug;

/**
 * Created by admin on 22.09.15.
 */
public class DropdownMenu {
    public boolean manageMenu(int id, Activity activity) {
        if (id == R.id.action_settings) {
            debug.getInt().message("Menu: Settings");
            activity.startActivity(new Intent(activity, SettingsActivity.class));
            return true;
        } else if(id == R.id.action_user) {
            debug.getInt().message("Menu: User");
            activity.startActivity(new Intent(activity, UserActivity.class));
            return true;
        } else if(id == R.id.action_pupillist) {
            debug.getInt().message("Menu: Schuelerliste");
            activity.startActivity(new Intent(activity, DatePickerActivity.class));
            return true;
        }
        return false;
    }
    public boolean pupilListMenu (int id, PupilListActivity pupilListActivity) {
        if (manageMenu(id,pupilListActivity)) {
            return true;
        } else if (id== R.id.action_save) {
            debug.getInt().message("Menu: Speichern");
            pupilListActivity.savePresence();
            pupilListActivity.startActivity(new Intent(pupilListActivity, MenueActivity.class));
            return true;
        }
        return false;
    }
}