package com.example.auto_sms;

import java.lang.annotation.Annotation;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

@SuppressLint("NewApi")
public class TimePickerFragment
implements  TimePickerDialog.OnTimeSetListener , TimePickerDialog.OnClickListener, OnTimeChangedListener {

@SuppressLint({ "NewApi", "NewApi" })

private static final String HOUR = "hour";
private static final String MINUTE = "minute";


public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current time as the default values for the picker
final Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);

// Create a new instance of TimePickerDialog and return it
return new TimePickerDialog(getActivity(), this, hour, minute,
DateFormat.is24HourFormat(getActivity()));
}

private Context getActivity() {
	// TODO Auto-generated method stub
	return null;
}

public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
// Do something with the time chosen by the user
	/*Intent intent = new Intent();
	EditText Time = (EditText) view;
	String message = editText.getText().toString();
	intent.putExtra(EXTRA_MESSAGE, message);*/
	
}

@Override
public void onClick(DialogInterface dialog, int which) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
	// TODO Auto-generated method stub
	
}

public static String getMinute() {
	return MINUTE;
}

public Class<? extends Annotation> annotationType() {
	// TODO Auto-generated method stub
	return null;
}

public void show(Object fragmentManager, String string) {
	// TODO Auto-generated method stub
	
}

public void setActivity(Object activity) {
	// TODO Auto-generated method stub
	
}
}
