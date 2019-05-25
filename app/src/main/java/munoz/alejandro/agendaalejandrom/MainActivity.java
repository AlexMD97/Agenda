package munoz.alejandro.agendaalejandrom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private ArrayList<Contacto> contactos;
    private AgendaProvider agendaProvider;
    private ContactosAdapter contactosAdapter;
    private ListView lvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agendaProvider = new AgendaProvider(this);
        contactos = agendaProvider.cargarContactos();
        contactosAdapter = new ContactosAdapter(contactos, this);
        lvContactos = findViewById(R.id.lvContactos);
        lvContactos.setAdapter(contactosAdapter);

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
}
