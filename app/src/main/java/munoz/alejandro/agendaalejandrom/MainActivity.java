package munoz.alejandro.agendaalejandrom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final int REQUEST_CODE = 1;
    public static final String CONTACTO = "contacto";
    private ArrayList<Contacto> contactos;
    private AgendaProvider agendaProvider;
    private BBDDHandler bbdd;
    private ContactosAdapter contactosAdapter;
    private ListView lvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbdd = new BBDDHandler(this);
        if(bbdd.existsDatabase()) {
            contactos = bbdd.getContactos();
        } else {
            agendaProvider = new AgendaProvider(this);
            contactos = agendaProvider.cargarContactos();
            // los guardamos en la bbdd
            bbdd.createDatabase();
            bbdd.createContactos(contactos);
        }

        contactosAdapter = new ContactosAdapter(contactos, this);
        lvContactos = findViewById(R.id.lvContactos);
        lvContactos.setAdapter(contactosAdapter);
        lvContactos.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuppal, menu);
        return true;
    }

    public void clickEditarContacto(View v) {
        Intent i = new Intent(this, EditarContactoActivity.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ConfigurarNotificaciones:
                //TODO time picker Dialog
                break;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contacto pulsado = contactos.get(position);
        Intent i = new Intent(this, EditarContactoActivity.class);
        i.putExtra(CONTACTO, pulsado);
        startActivityForResult(i, REQUEST_CODE);
    }
}
