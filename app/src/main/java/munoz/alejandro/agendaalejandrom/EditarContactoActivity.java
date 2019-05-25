package munoz.alejandro.agendaalejandrom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    }

    // TAREA: ABRIR ACTIVITY CON EL BOTÓN DE LOS CONTACTOS.
}
