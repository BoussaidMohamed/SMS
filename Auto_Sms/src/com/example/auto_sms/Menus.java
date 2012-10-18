package com.example.auto_sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Menus extends Activity {

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menus, menu);
        return true;
    }

    
    public void commencerAutoSMS(View view) {
    	Intent intent = new Intent(this, Commencer.class);
    	startActivity(intent);
    	
    }
    
    public void recaptif(View view) {
    	Intent intent = new Intent(this, Recapetif.class);
    	startActivity(intent);
    	
    }
    
    public void Parametres(View view) {
    	Intent intent = new Intent(this,Parametres.class);
    	startActivity(intent);
    	
    }
 

}
    
    
