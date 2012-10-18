package com.example.auto_sms;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class Map extends MapActivity  {
	
	MapView mapView ;
	

	
	@SuppressWarnings("deprecation")
	

	      

	

///////////////////////////////////////////////////////////////
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map) ;
		
		MapView mapView = (MapView) this.findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		MapController mc;
		mc = mapView.getController();
		mc.setZoom(17);
	
		
		

////////////////////////////////////////////////////////////////////////
		
		}
	

		 
	public boolean onCreateOptionsMenu(Menu menu){
	    super.onCreateOptionsMenu(menu);
	    MenuInflater oMenu = getMenuInflater();
	    oMenu.inflate(R.menu.activity_map, menu);
	    return true;
	}

	@SuppressWarnings("deprecation")
	public boolean onOptionsItemSelected(MenuItem item){
	    switch(item.getItemId()){
	    case R.id.mapStreet:
	         mapView.setStreetView(true);
	         mapView.setSatellite(false);
	         mapView.invalidate();
	         return true;

	    case R.id.mapSat:
	         mapView.setSatellite(true);
	         mapView.setStreetView(false);
	         mapView.invalidate();
	         return true;
	    }
	    return false;
	}
		  
	
	

	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		MapView mapView = (MapView) this.findViewById(R.id.mapView);
		if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
			mapView.setSatellite(true);
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			mapView.setSatellite(false);
			return true;
		} 
		return super.onKeyDown(keyCode, event);
	}	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}
