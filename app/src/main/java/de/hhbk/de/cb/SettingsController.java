package de.hhbk.de.cb;

import android.view.View;

/**
 * Created by admin on 05.10.2015.
 */
public class SettingsController implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.settingsCheckBox:
                debug.getInt().message("SettingsController: onClick");
                break;
        }
    }
}
