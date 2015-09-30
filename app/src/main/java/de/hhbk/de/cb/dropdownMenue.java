package de.hhbk.de.cb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 22.09.15.
 */
public class DropdownMenue {
    public boolean manageMenue(int id, Activity menueActivity) {
        if (id == R.id.action_settings) {
            debug.getInt().message("Menue: Settings");
            menueActivity.startActivity(new Intent(menueActivity, SettingsActivity.class));
            return true;
        } else if(id == R.id.action_user) {
            debug.getInt().message("Menue: User");
            menueActivity.startActivity(new Intent(menueActivity, UserActivity.class));
            return true;
        } else if(id == R.id.action_pupillist) {
            debug.getInt().message("Menue: Schuelerliste");
            menueActivity.startActivity(new Intent(menueActivity, PupillistActivity.class));
            return true;
        }
        return false;
    }
}
