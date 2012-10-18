package com.example.auto_sms;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Messages extends Activity {
	
	TextView Timeactivity, dateactivity ;
	
	  private HeureBBD heures;
	  private PlaceBBD places;

    private static final int PICK_CONTACT = 0;
    
    public void init(){
    	heures = new HeureBBD(this);
    	places= new PlaceBBD(this);
    		
      } 

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        
        Bundle t = getIntent().getExtras();
       String receivingtime = t.getString("Keyt");
        TextView tt = (TextView)findViewById(R.id.HeureText);
        tt.setText(receivingtime);
      
        Bundle d = getIntent().getExtras();
        String receivingdate = d.getString("Keyd");
         TextView td = (TextView)findViewById(R.id.DateText);
         td.setText(receivingdate);
         
         Bundle a = getIntent().getExtras();
         String receivingadresse = a.getString("Keya");
          TextView ta = (TextView)findViewById(R.id.PlaceText) ;
          ta.setText(receivingadresse);
          
          init();
          
          TextView datetext = (TextView)findViewById(R.id.date);
          TextView Timetext = (TextView)findViewById(R.id.Time);
          TextView placetext = (TextView)findViewById(R.id.adresse); 
          EditText num = (EditText)findViewById(R.id.numero) ; 
          EditText message = (EditText)findViewById(R.id.message) ; 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_messages, menu);
        return true;
    }
    public void AlertBox (View v) {
    	
    	
    	 TextView datetext = (TextView)findViewById(R.id.DateText) , Timetext =(TextView)findViewById(R.id.HeureText) , placetext = (TextView)findViewById(R.id.PlaceText);
         EditText num = (EditText)findViewById(R.id.numero) , message = (EditText)findViewById(R.id.message)  ; 
         
         String dateT = datetext.getText().toString();
   	  String TimeT = Timetext.getText().toString();
   	  String placeT = placetext.getText().toString() ;
   	  String numero = num.getText().toString();
   	  String texto = message.getText().toString() ;
   	 
   	  
   	  heures.open();
   	  heures.insertheure(new Msg(0 , texto,"",TimeT,dateT,numero,""));
   	  heures.close();
   	  
   	  places.open();
   	  places.insertplace(new Msg(0 , texto,placeT,"","",numero,""));
   	  places.close();
        
        // prepare the alert box                   
          AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
           
          // set the message to display
          alertbox.setMessage("Votre Message Est Enregistré!");
        
          // add a neutral button to the alert box and assign a click listener
          alertbox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
               
              // click listener on the alert box
              public void onClick(DialogInterface arg0, int arg1) {
                  // the button was clicked
                  Toast.makeText(getApplicationContext(), "Retour à la Page d'accueil", Toast.LENGTH_LONG)
                  
                  .show();
  
              }
         
          });
           
          // show it
          alertbox.show();
          Intent intent = new Intent(this, Menus.class);
          startActivity(intent); 
          
       
          
    }
    public void callContactList(View view){
    	Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
    	startActivityForResult(intent, PICK_CONTACT);
    }
    
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
      super.onActivityResult(reqCode, resultCode, data);

      switch (reqCode) {
        case (PICK_CONTACT) :
          if (resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            Cursor c =  managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
              String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
             // TODO Whatever you want to do with the selected contact name.
              setContentView(R.layout.activity_messages);

              TextView t = new TextView(this); 

              t=(TextView)findViewById(R.id.numero); 
              t.setText(name);
              
            }
          }
          break;
      }
    }
    
    
}
