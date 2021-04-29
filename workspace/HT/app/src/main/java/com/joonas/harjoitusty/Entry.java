package com.joonas.harjoitusty;

import android.icu.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class Entry {
    // Superclass for log entries.
    protected Date date;
    protected Calendar calendar;
    protected String dateString;

    protected Entry(){
        // Constructor sets the date variable to current date.
        date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        dateString = format.format(calendar.getTime());
    }
}

