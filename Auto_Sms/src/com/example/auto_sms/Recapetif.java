package com.example.auto_sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Recapetif extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapetif);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_recapetif, menu);
        return true;
    }
    public void Mapou (View view) {
    	Intent intent = new Intent(this, Map.class);
    	startActivity(intent);
}
}

