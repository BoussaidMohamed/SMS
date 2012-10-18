package com.example.auto_sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Parametres extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_parametres, menu);
        return true;
    }
    
    public void Acceuil(View view) {
    	Intent intent = new Intent(this, Menus.class);
    	startActivity(intent);
    }
}
