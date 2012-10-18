package com.example.auto_sms;
 
import java.util.List;

import org.w3c.dom.Comment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class HeureBBD {
 
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "MessageBase";
 
    // Messages table name
    private static final String Heure_Table= "Heure_Table";
 
    // Messages Table Columns names
    private static final String KEY_ID = "id";
    private static final String colNum="Numero";
    private static final String colText="Text";
    private static final String colDate="Date";
    private static final String colHeure="Heure";
    private static final String colSend ="Send" ;
	private static final int NUM_COL_ID = 0 ;
	private static final int NUM_COL_NUM = 1;
	private static final int NUM_COL_HEURE = 2;
    private static final int NUM_COL_DATE = 3 ;
    private static final int NUM_COL_MSG = 4 ;
    private static final int  NUM_COL_SEND = 5 ;
    
	private SQLiteDatabase bdd;
 
	private MaBaseSQLite maBaseSQLite;
 
	public HeureBBD(Context context){
		//On cr�e la BDD et sa table
		maBaseSQLite = new MaBaseSQLite(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
 
	public void open(){
		//on ouvre la BDD en �criture
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'acc�s � la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertheure(Msg message){
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ�e � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(colNum, Msg.getnum());
		values.put(colHeure, Msg.getheure());
		values.put(colDate, Msg.getdate());
		values.put(colText, Msg.getmessage());
		values.put(colSend, Msg.getsend());
		//on ins�re l'objet dans la BDD via le ContentValues
		return bdd.insert(Heure_Table, null, values);
	}
 
	public int updatebase(int id, Msg Msg){
		//La mise � jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simplement pr�ciser quel livre on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		values.put(colNum, Msg.getnum());
		values.put(colHeure, Msg.getheure());
		values.put(colDate, Msg.getdate());
		values.put(colText, Msg.getmessage());
		values.put(colSend, Msg.getsend());
		return bdd.update(Heure_Table, values, KEY_ID + " = " +id, null);
	}
 
	public int removeHeureWithID(int id){
		//Suppression d'un livre de la BDD gr�ce � l'ID
		return bdd.delete(Heure_Table, KEY_ID + " = " +id, null);
	}
 
	public Msg getHeureWithID(int id){
		//R�cup�re dans un Cursor les valeurs correspondant � un livre contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
		Cursor c = bdd.query(Heure_Table, new String[] {KEY_ID, colNum, colHeure, colDate ,colText, colSend}, KEY_ID + " LIKE \"" +id +"\"", null, null, null, null);
		return cursorToHeure(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un livre
	private Msg cursorToHeure(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un livre
		Msg msg = new Msg();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		msg.setID(c.getInt(NUM_COL_ID));
		msg.setheure(c.getString(NUM_COL_HEURE));
		msg.setdate(c.getString(NUM_COL_DATE));
		msg.setmessage(c.getString(NUM_COL_MSG));
		msg.setnum(c.getString(NUM_COL_NUM));
		msg.setsend(c.getString(NUM_COL_SEND));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return msg;
	}
	
	
	public Cursor fetchAllHeure() {
		 
		  Cursor mCursor = bdd.query(Heure_Table, new String[] {KEY_ID,
		    colNum, colHeure, colDate, colText, colSend}, 
		    null, null, null, null, null);
		 
		  if (mCursor != null) {
		   mCursor.moveToFirst();
		  }
		  return mCursor;
		 
	}

	public SQLiteDatabase getWritableDatabase() {
		
		// TODO Auto-generated method stub
		return null;
	}


	
}