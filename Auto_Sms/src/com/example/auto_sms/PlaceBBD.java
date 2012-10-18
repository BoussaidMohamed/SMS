package com.example.auto_sms;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class PlaceBBD {
 
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "MessageBase";
 
    // Place_Table table name
    private static final String Place_Table= "Place_Table";
 
    // Place_Table Table Columns names
    private static final String KEY_ID = "id";
    private static final String colNum="Numero";
    private static final String colText="Text";
    private static final String colSend ="Send" ;
	private static final int NUM_COL_ID = 0 ;
	private static final int NUM_COL_NUM = 1; 
    private static final int NUM_COL_MSG = 2;
    private static final int  NUM_COL_SEND = 3 ;
    
	private SQLiteDatabase bdd;
 
	private MaBaseSQLite maBaseSQLite;
 
	public PlaceBBD(Context context){
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
 
	public long insertplace(Msg message){
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ�e � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(colNum, Msg.getnum());
		values.put(colText, Msg.getmessage());
		values.put(colSend, Msg.getsend());
		//on ins�re l'objet dans la BDD via le ContentValues
		return bdd.insert(Place_Table, null, values);
	}
 
	public int updatebase(int id, Msg Msg){
		//La mise � jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simplement pr�ciser quel livre on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		values.put(colNum, Msg.getnum());
		values.put(colText, Msg.getmessage());
		values.put(colSend, Msg.getsend());
		return bdd.update(Place_Table, values, KEY_ID + " = " +id, null);
	}
 
	public int removeLivreWithID(int id){
		//Suppression d'un livre de la BDD gr�ce � l'ID
		return bdd.delete(Place_Table, KEY_ID + " = " +id, null);
	}
 
	public Msg getLivreWithTitre(int id){
		//R�cup�re dans un Cursor les valeurs correspondant � un livre contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
		Cursor c = bdd.query(Place_Table, new String[] {KEY_ID, colNum, colText, colSend}, KEY_ID + " LIKE \"" +id +"\"", null, null, null, null);
		return cursorToMsg(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un livre
	private Msg cursorToMsg(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un livre
		Msg msg = new Msg();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		msg.setID(c.getInt(NUM_COL_ID));
		msg.setmessage(c.getString(NUM_COL_MSG));
		msg.setnum(c.getString(NUM_COL_NUM));
		msg.setsend(c.getString(NUM_COL_SEND));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return msg;
	}
}