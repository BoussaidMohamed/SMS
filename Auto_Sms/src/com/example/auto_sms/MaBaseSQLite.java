
package com.example.auto_sms;
 
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
 
public class MaBaseSQLite extends SQLiteOpenHelper {
 
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "MessageBase";
 
    // Messages table name
    private static final String Heure_Table= "Heure_Table";
    private static final String Place_Table= "Place_Table";
    
 
    // Messages Table Columns names
    private static final String KEY_ID = "id";
    private static final String colNum="Numero";
    private static final String colText="Text";
    private static final String colDate="Date";
    private static final String colHeure="Heure";
    private static final String colPlace="Place";
    private static final String colSend ="Send" ;
 
    private static final  String CREATE_HEURE_TABLE = " CREATE TABLE " + Heure_Table + "("
             + KEY_ID +  " INTEGER PRIMARY KEY, " + colNum + " TEXT, "
            + colHeure + " TEXT, " + colDate + " TEXT, " + colText + " TEXT, " + colSend + " TEXT ) ;";
 
    private static final  String CREATE_PLACE_TABLE = " CREATE TABLE " + Place_Table + "("
            + KEY_ID +  " INTEGER PRIMARY KEY, " + colNum +  " TEXT, " + colPlace +" TEXT, " + colText + " TEXT, " + colSend + " TEXT ) ;";


 
	public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on crée la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL(CREATE_HEURE_TABLE);
		db.execSQL(CREATE_PLACE_TABLE);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
		//comme ça lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + Heure_Table+ ";");
		db.execSQL("DROP TABLE " + Place_Table+ ";");
		onCreate(db);
	}
 
}