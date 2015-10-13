package de.hhbk.de.cb.controller;

import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import de.hhbk.de.cb.activitys.DatePickerActivity;
import de.hhbk.de.cb.other.debug;

/**
 * Created by dominik on 13.10.15.
 */
public class DatePickerController implements View.OnClickListener {
    private DatePickerActivity activity;
    private DatePicker picker;
    public DatePickerController(DatePickerActivity pickerActivity, DatePicker datePicker) {
        this.activity = pickerActivity;
        this.picker = datePicker;
    }
    @Override
    public void onClick(View v) {
        debug.getInt().message("DatePicker: Day of Month: " + picker.getDayOfMonth() + " Month: " + picker.getMonth() + " Year: " + picker.getYear());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, picker.getYear());
        calendar.set(Calendar.MONTH, picker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, picker.getDayOfMonth());
        Date dateRepresentation = calendar.getTime();
        debug.getInt().message("Date: "+dateRepresentation.toString());
    }
}
