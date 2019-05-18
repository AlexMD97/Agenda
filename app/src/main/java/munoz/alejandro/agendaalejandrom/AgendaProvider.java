package munoz.alejandro.agendaalejandrom;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para extraer los datos de la agenda propia del telefono
 */
public class AgendaProvider {

    private Context context;

    public AgendaProvider(Context context) {
        this.context = context;
    }

    /**
     * Método para obtener los contactos de la agenda del télefono.
     * @return ArrayList de objetos contacto.
     */
    public List<Contacto> cargarContactos(){
        List<Contacto> contactos = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();

        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String nombre = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String telefono = "";

            Cursor cursorTlfn = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[] {id}, null);
            if(cursorTlfn.moveToNext()) {
                telefono = cursorTlfn.getString(cursorTlfn.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }

            Contacto contacto = new Contacto();
            contacto.setId(id);
            contacto.setNombre(nombre);
            contacto.setTelefono(telefono);

            contactos.add(contacto);
        }

        return contactos;
    }


}
