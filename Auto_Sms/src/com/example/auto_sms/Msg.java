package com.example.auto_sms;
 
/**
 * Création d'un livre tout simple pour un exemple d'utilisation de SQLite sous Android
 * @author Axon
 * http://www.tutomobile.fr
 */
public class Msg {
 
	  //private variables
    static int _id;
    static String _place;
    static String _heure ;
    static String _date;
    static String _num ; 
    static String _message ;
    static String _Send ;
    
    
 
    // Empty constructor
    public Msg(){
 
    }
    // constructor
    public Msg(int id, String message , String place, String heure , String date , String num , String Send){
       _id = id;
      _place = place;
        _heure = heure ;
       _date = date ;
        _num = num ;
        _message = message ;
        _Send = Send ;
        
    }
 
    // constructor
    public Msg(String place, String heure , String message , String date , String num , String Send){
    	_place = place;
        _heure = heure ;
        _date = date ;
        _num = num ;
        _message = message ;
        _Send =  Send ; 
    }
    // getting ID
    public static int getID(){
        return _id;
    }
 
    // setting id
    public void setID(int id){
       _id = id;
    }
    
    //getting Send 
    public static String getsend () {
    return	_Send ; 
    }

    
    //setting Send 
    
    public void setsend (String Send ) {
    	
    	_Send = Send;
    	
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