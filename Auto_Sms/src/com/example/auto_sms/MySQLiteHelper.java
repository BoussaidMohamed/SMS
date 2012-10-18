
/*package com.example.auto_sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



static final String dbName="SMS";
static final String MessageTable="Message";
static final String colID="ID";
static final String colNum="Numero";
static final String colText="Text";
static final String colDate="Date";
static final String colHeure="Heure";
static final String colPlace="Place";



static final String viewEmps="ViewEmps";


public DatabaseHelper(Context context) {
	  super(context, dbName, null,33); 
	  }

@Override
public void onCreate(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	
	  
	 
	  db.execSQL("CREATE TABLE "+MessageTable+"  ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
	        colNum+" Integer, "+colText+" TEXT, "+colHeure+" DATE , "+colDate+" DATE, "+colPlace+" TEXT ;");
	  
	  
		  
	  db.execSQL("CREATE VIEW "+viewEmps+
	    " AS SELECT "+MessageTable+"."+colID+" AS _id,"+
	    " "+MessageTable+"."+colNum+","+
	    " "+MessageTable+"."+colText+","+
	    " "+MessageTable+"."+colHeure+""+
	    " "+MessageTable+"."+colDate+""+
	    " "+MessageTable+"."+colPlace+""+
	    " FROM "+MessageTable 
	    );
	  //Inserts pre-defined departments
	  InsertMessage(db) ;  
	
}

void InsertMessage(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	
	SQLiteDatabase db1=this.getWritableDatabase();
	 ContentValues cv=new ContentValues();
	   
	   cv.put(colNum, R.id.numero);
	   cv.put(colText, R.id.message);
	   cv.put(colHeure, R.id.Time);
	   cv.put(colDate, R.id.date);
	   cv.put(colPlace, R.id.adresse);
	   db1.insert(MessageTable,null, cv);
	                     db1.close();
	
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	// TODO Auto-generated method stub
	
}

}

*/

/*
package com.example.auto_sms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_MESSAGE = "message";
  public static final String COLUMN_ID = "_id";
  static final String colNum="Numero";
  static final String colText="Text";
  static final String colDate="Date";
  static final String colHeure="Heure";
  static final String colPlace="Place";


  private static final String DATABASE_NAME = "Messages.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_MESSAGE + "(" + COLUMN_ID
      + " integer primary key autoincrement, " + colNum
      + " text not null, "+ colHeure 
      + " , "+ colDate
      + " ,"+colPlace
      + " ,"+colText 
      + ");";

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
    onCreate(db);
  }

}

*/

package com.example.auto_sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
	 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "MessageBase";
 
    // Messages table name
    private static final String Messages= "Messages";
 
    // Messages Table Columns names
    private static final String KEY_ID = "id";
    private static final String colNum="Numero";
    private static final String colText="Text";
    private static final String colDate="Date";
    private static final String colHeure="Heure";
    private static final String colPlace="Place";
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    public void onCreate1(SQLiteDatabase db) {
        String CREATE_MESSAGES_TABLE = "CREATE TABLE " + Messages + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + colNum + " TEXT,"
                + colHeure + " TEXT," + colDate + "TEXT,"+ colPlace +"TEXT," + colText +"TEXT" + ") ;";
        db.execSQL(CREATE_MESSAGES_TABLE);
    }
        
 
    // Upgrading database
    public void onUpgrade1(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Messages);
 
        // Create tables again
        onCreate(db);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 String CREATE_MESSAGES_TABLE = "CREATE TABLE " + Messages + "("
	                + KEY_ID + " INTEGER PRIMARY KEY," + colNum + " TEXT,"
	                + colHeure + " TEXT," + colDate + "TEXT,"+ colPlace +"TEXT," + colText +"TEXT" + ") ;";
	        db.execSQL(CREATE_MESSAGES_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Messages);
 
        // Create tables again
        onCreate(db);
		
	}
	
	
	 // Adding new contact
	public void addSave(SaveData SAVE) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(colNum, SaveData.getnum()); // Contact Num
	    values.put(colHeure, SaveData.getheure()); // Contact heure 
	    values.put(colDate, SaveData.getdate()) ; // Contact Date 
	    values.put(colPlace, SaveData.getPlace()); // Contact Place
	    values.put(colText, SaveData.getmessage()); // Contact message
	    
	    // Inserting Row
	    db.insert(Messages, null, values);
	    db.close(); // Closing database connection
	}
	
}