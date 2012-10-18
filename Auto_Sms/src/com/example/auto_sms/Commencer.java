package com.example.auto_sms;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import android.app.Activity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;



public class Commencer extends Activity {
	
	//private MessageDataSource datasource;
	
	EditText Timetext, datetext, placetext ;
	Button btncontunie;

	
  DateFormat fmtDate=DateFormat.getDateInstance();
  DateFormat fmtTime=DateFormat.getTimeInstance();
  
  TextView dateAndTimeLabel1;
  TextView dateAndTimeLabel2;
  Calendar date=Calendar.getInstance();
  Calendar Time=Calendar.getInstance();
  


  
  public void showTimePickerDialog(View v) {
	    TimePickerFragment newFragment = new TimePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "timePicker");
	}
  
  public void init(){
  	findViewById(R.id.date).setEnabled(false);
		findViewById(R.id.button1).setEnabled(false); 
		findViewById(R.id.Time).setEnabled(false);
		findViewById(R.id.button2).setEnabled(false); 
		findViewById(R.id.date).setEnabled(false); 
		
  } 

	 
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_commencer);
    dateAndTimeLabel1=(TextView)findViewById(R.id.Time);
    updateLabel1();
    dateAndTimeLabel2=(TextView)findViewById(R.id.date);
    updateLabel2();
    init();
    
   datetext = (EditText)findViewById(R.id.date);
    Timetext = (EditText)findViewById(R.id.Time);
    placetext = (EditText)findViewById(R.id.adresse); 
    btncontunie = (Button)findViewById(R.id.button3);
    
   /* datasource = new MessageDataSource(this);
    datasource.open();

    List<Comment> values = datasource.getAllComments();

    // Use the SimpleCursorAdapter to show the
    // elements in a ListView
    ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  */
    

    btncontunie.setOnClickListener(new Button.OnClickListener(){

    	
 @Override
 public void onClick(View arg0) {
  // TODO Auto-generated method stub
	 String dateT = datetext.getText().toString();
	  String TimeT = Timetext.getText().toString();
	  String placeT = placetext.getText().toString() ;
	  
	//  msg.open();
	  //msg.insertmsg(new Msg(6,dateT,TimeT,placeT,"","",""));
	  //msg.close();
 
  FileOutputStream fos;
  try {
   fos = openFileOutput("Save", Context.MODE_PRIVATE);
   fos.write("Date: ".getBytes());
   fos.write(dateT.getBytes());
   fos.write("// ".getBytes());
   fos.write("Heure: ".getBytes());
   fos.write(TimeT.getBytes());
   fos.write("// ".getBytes());
   fos.write("Place: ".getBytes());
   fos.write(placeT.getBytes());
   fos.write("// ".getBytes());
   
   
   fos.close();
  
   Toast.makeText(
     Commencer.this,
       " Enregister ",
     Toast.LENGTH_LONG).show();
  
  } catch (FileNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
 Message (arg0) ;

 } 
 } 
    );
    
    
    ///////////////////////////////////////////////////////////////////////////
    
  /*  //Création d'une instance de ma classe LivresBDD
    MsgBBD MsgBdd = new MsgBBD(this);

    //Création d'un livre
    Msg msg = new Msg(01, "Markoko", "Marcko","User Ex", "ENAC", "Toulouse", "France");

    //On ouvre la base de données pour écrire dedans
    MsgBdd.open();
    //On insère le livre que l'on vient de créer
    MsgBdd.insertmsg(msg);
    MsgBdd.close();
    */

    }

    
  
    
    ///////////////////////////////////////////////////////////////////////////

 
  




  private Object getSupportFragmentManager() {
	// TODO Auto-generated method stub
	return null;
}
public void chooseDate(View v) {
    new DatePickerDialog(Commencer.this, d,
                         date.get(Calendar.YEAR),
                         date.get(Calendar.MONTH),
                         date.get(Calendar.DAY_OF_MONTH))
    .show();
  }
  public void chooseTime(View v) {
    new TimePickerDialog(Commencer.this, t,
                        Time.get(Calendar.HOUR_OF_DAY),
                        Time.get(Calendar.MINUTE),
                         true)
    .show();
  }
  
 
  private void updateLabel1() {
    dateAndTimeLabel1.setText(fmtTime
                             .format(Time.getTime()));
  }
  private void updateLabel2() {
	    dateAndTimeLabel2.setText(fmtDate
	                             .format(date.getTime()));
	  }
  DatePickerDialog.OnDateSetListener d=
     new  DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                             int dayOfMonth) {
      date.set(Calendar.YEAR, year);
      date.set(Calendar.MONTH, monthOfYear);
      date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
      updateLabel2();
    }
  };

  TimePickerDialog.OnTimeSetListener t=
    new TimePickerDialog.OnTimeSetListener() {
      public void onTimeSet(TimePicker view, int hourOfDay,
                            int minute) {
        Time.set(Calendar.HOUR_OF_DAY, hourOfDay);
        Time.set(Calendar.MINUTE, minute);
        updateLabel1();
    }
  };

// allow to check both the tow chekBoxs on the same time
  public void onCheckboxClicked(View view) {
      // Is the view now checked?
      boolean checked = ((CheckBox) view).isChecked();
      
      // Check which  was clicked
      switch(view.getId()) {
          case R.id.checkBox_when:
              if (checked){
                  // set the textFild and the button on available
              	findViewById(R.id.Time).setEnabled(true);
              	findViewById(R.id.button1).setEnabled(true);
              	findViewById(R.id.date).setEnabled(true);
              	findViewById(R.id.button2).setEnabled(true);
              }
              else{
                  // don't set the textFild and the button on available
              	findViewById(R.id.Time).setEnabled(false);
          		findViewById(R.id.button1).setEnabled(false); 
          		findViewById(R.id.date).setEnabled(false);
          		findViewById(R.id.button2).setEnabled(false); 
              }
              break;
          case R.id.checkBox_where:
              if (checked){
                  // set a place to send the message
            	  findViewById(R.id.adresse).setEnabled(true);
              }
              else{
                  // don't send the message according the place
            	  findViewById(R.id.adresse).setEnabled(false);
              }
              break;
          // TODO: Veggie sandwich
      }
      
 //   MySQLiteHelper db = new MySQLiteHelper(this);
      
      /**
       * CRUD Operations
       * */
      // Inserting Contacts
      /*     Log.d("Insert: ", "Inserting ..");
    db.addSave(new SaveData( "0", "0", "fffffffffffff", "ggggggggggggggggg", "ffffffffffffffffff"));
   */  
     
           
       }

 

  public void Message(View view) {
  //	Intent intent = new Intent(this, Messages.class);
  	//startActivity(intent);
  	
  	EditText texttime = (EditText)findViewById(R.id.Time);;
  	EditText textdate = (EditText)findViewById(R.id.date); ; 
  	EditText textplace = (EditText)findViewById(R.id.adresse); ;
	String passingtime = texttime.getText().toString();
	String passingdate = textdate.getText().toString();
	String passingadresse = textplace.getText().toString();
    Intent i = new Intent(Commencer.this, Messages.class);
    Bundle t = new Bundle();
    Bundle d = new Bundle();
    Bundle a = new Bundle();
    
    t.putString("Keyt", passingtime);
    i.putExtras(t);
    
    d.putString("Keyd", passingdate);
    i.putExtras(d);
    
    a.putString("Keya", passingadresse);
    i.putExtras(a);
    startActivity(i);
  	
  	
  }
  
}


