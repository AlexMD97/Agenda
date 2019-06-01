package munoz.alejandro.agendaalejandrom;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static munoz.alejandro.agendaalejandrom.MainActivity.CONTACTO;

public class EditarContactoActivity extends AppCompatActivity {
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);

        contacto = getIntent().getParcelableExtra(CONTACTO);

        EditText etNombre = findViewById(R.id.etNombre);
        etNombre.setText(contacto.getNombre());
        ImageView imgContacto = findViewById(R.id.imgContacto);
        imgContacto.setImageDrawable(contacto.getImagen());
        Button btnContacto = findViewById(R.id.btnVerContacto);
        EditText etFecha = findViewById(R.id.etFecha);
        etFecha.setText(contacto.getFechanac());

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(intent);
            }
        });
    }

    // TAREA: ABRIR ACTIVITY CON EL BOTÓN DE LOS CONTACTOS.
}
