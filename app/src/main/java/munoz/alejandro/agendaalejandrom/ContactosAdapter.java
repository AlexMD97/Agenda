package munoz.alejandro.agendaalejandrom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactosAdapter extends BaseAdapter {
    private ArrayList<Contacto> misContactos;
    private Context context;

    public ContactosAdapter(ArrayList<Contacto> misContactos, Context context) {
        this.misContactos = misContactos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return misContactos.size();
    }

    @Override
    public Object getItem(int i) {
        return misContactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(v==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.contactoslayout,null);

            ImageView foto=v.findViewById(R.id.imgContacto);
            TextView nombre=v.findViewById(R.id.txtNombre);
            TextView telefono=v.findViewById(R.id.txtTelefono);
            TextView aviso=v.findViewById(R.id.txtMensaje);

            nombre.setText(misContactos.get(i).getNombre());
            telefono.setText(misContactos.get(i).getTelefono());
            if(misContactos.get(i).isEnviarSMS()) {
                aviso.setText("Aviso: Enviar SMS");
            } else {
                aviso.setText("Aviso: Solo notificación");
            }
        }
        return v;
    }
}
