package munoz.alejandro.agendaalejandrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contacto> contactos;
    private AgendaProvider agendaProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agendaProvider = new AgendaProvider(this);
        contactos = agendaProvider.cargarContactos();

        // tarea: crear el listview principal y mostrar el contenido del arraylist de contactos.
        // tarea2: crear el activity de edición de contactos.
    }
}
