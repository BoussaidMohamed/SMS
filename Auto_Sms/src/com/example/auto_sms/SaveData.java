package com.example.auto_sms; 
 
public class SaveData {
 
    //private variables
    int _id;
    static String _place;
    static String _heure ;
    static String _date;
    static String _num ; 
    static String _message ;
    
    
 
    // Empty constructor
    public SaveData(){
 
    }
    // constructor
    public SaveData(int id, String message , String place, String heure , String date , String num){
        this._id = id;
      _place = place;
        _heure = heure ;
       _date = date ;
        _num = num ;
        _message = message ;
        
    }
 
    // constructor
    public SaveData(String place, String heure , String message , String date , String num){
    	_place = place;
        _heure = heure ;
        _date = date ;
        _num = num ;
        _message = message ;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting message
    public static String getmessage(){
        return _message;
    }
 
    // setting message
    public void setmessage(String message){
        _message = message;
    }
    
 // getting num
     public static String getnum(){
        return _num;
    }
 
    // setting num
    public void setnum( String num){
        _num = num;
    }
    
    // getting place
    public static String getPlace(){
        return _place;
    }
 
    // setting place
    public void setplace(String place){
        _place = place;
    }
    
    // getting heure
    public static  String getheure(){
        return _heure;
    }
 
    // setting heure
    public void setheure(String heure){
        _heure = heure;
    }
 
    
    // getting date
    public static String getdate(){
        return _date;
    }
 
    // setting date
    public void setdate(String date){
       _date = date;
    }

}