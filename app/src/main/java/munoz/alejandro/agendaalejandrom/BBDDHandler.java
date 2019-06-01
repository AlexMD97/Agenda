package munoz.alejandro.agendaalejandrom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class BBDDHandler extends SQLiteOpenHelper {
    public static final String BIRTHDAYHELPER = "birthdayhelper";
    public static final int VERSION = 1;
    private SQLiteDatabase db;

    public BBDDHandler(@Nullable Context context) {
        super(context, BIRTHDAYHELPER, null, VERSION);
        this.db = this.getWritableDatabase();
    }

    public boolean existsDatabase(){
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+BIRTHDAYHELPER+"'";
        Cursor mCursor = db.rawQuery(sql, null);
        if (mCursor.getCount() > 0) {
            return true;
        }
        mCursor.close();
        return false;
    }

    public void createDatabase() {
        String createQuery = "CREATE TABLE IF NOT EXISTS "+BIRTHDAYHELPER+"(" +
                "ID varchar(255)," +
                "TipoNotif CHAR(1)," +
                "Mensaje VARCHAR(160)," +
                "Telefono VARCHAR(15)," +
                "FechaNacimiento VARCHAR(15)," +
                "Nombre VARCHAR(128)); ";


        db.execSQL(createQuery);
    }

    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        Cursor cursor = db.query(BIRTHDAYHELPER, null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("ID"));
            String nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
            String mensaje = cursor.getString(cursor.getColumnIndex("Mensaje"));
            String telefono = cursor.getString(cursor.getColumnIndex("Telefono"));
            String fechanac = cursor.getString(cursor.getColumnIndex("FechaNacimiento"));
            boolean enviarSMS = cursor.getString(cursor.getColumnIndex("TipoNotif")).equals("S");

            Contacto contacto = new Contacto(id, nombre, telefono, fechanac, null, enviarSMS, mensaje);
            contactos.add(contacto);
        }

        return contactos;
    }

    public void createContactos(ArrayList<Contacto> contactos){
        for(Contacto c : contactos) {
            ContentValues valores = new ContentValues();
            valores.put("ID", c.getId());
            // Comparación binaria: condicion ? valor si true : valor si false
            valores.put("TipoNotif", c.isEnviarSMS() ? "S" : "N");
            valores.put("Mensaje", c.getMensaje());
            valores.put("Telefono", c.getTelefono());
            valores.put("FechaNacimiento", c.getFechanac());
            valores.put("Nombre", c.getNombre());

            db.insert(BIRTHDAYHELPER, null, valores);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // No lo usamos porque queremos comprobar primero si existe o no
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
