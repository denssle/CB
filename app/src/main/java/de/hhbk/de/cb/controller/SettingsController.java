package de.hhbk.de.cb.controller;

import android.view.View;

import de.hhbk.de.cb.R;
import de.hhbk.de.cb.other.debug;

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
