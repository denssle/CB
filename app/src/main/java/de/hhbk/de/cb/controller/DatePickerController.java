package de.hhbk.de.cb.controller;

import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;
import de.hhbk.de.cb.activitys.DatePickerActivity;
import de.hhbk.de.cb.activitys.SchoolClassPickerActivity;

/**
 * Created by dominik on 13.10.15.
 */
public class DatePickerController implements View.OnClickListener {
    private DatePickerActivity activity;
    private DatePicker picker;
    private static String date;

    public DatePickerController(DatePickerActivity pickerActivity, DatePicker datePicker) {
        this.activity = pickerActivity;
        this.picker = datePicker;
    }

    @Override
    public void onClick(View v) {
        makeDate();
        activity.startActivity(new Intent(activity, SchoolClassPickerActivity.class));
    }

    private void makeDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, picker.getYear());
        calendar.set(Calendar.MONTH, picker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, picker.getDayOfMonth());
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = Integer.toString(calendar.get(Calendar.MONTH)+1);
        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        date = day+ "." + month +"." + year;
    }

    public static String getDate() {
        return date;
    }
}
