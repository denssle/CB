package de.hhbk.de.cb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 22.09.15.
 */
public class DropdownMenue {
    public boolean manageMenue(int id, AppCompatActivity menueActivity) {
        if (id == R.id.action_settings) {
            debug.getInt().message("Menue: Settings");
            menueActivity.startActivity(new Intent(menueActivity, SettingsActivity.class));
            return true;
        }
        else if(id == R.id.action_user) {
            debug.getInt().message("Menue: USR");
            return true;
        }
        else if(id == R.id.action_pupillist) {
            debug.getInt().message("Menue: USR");
            menueActivity.startActivity(new Intent(menueActivity, PupillistActivity.class));
            return true;
        }
        return false;
    }
}
