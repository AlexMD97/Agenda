package munoz.alejandro.agendaalejandrom;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Contacto implements Parcelable {
    private String id;
    private String nombre;
    private String telefono;
    private String fechanac;
    private Drawable imagen;
    private boolean enviarSMS;
    private String mensaje;

    public Contacto() {
    }

    public Contacto(String id, String nombre, String telefono, String fechanac, Drawable imagen, boolean enviarSMS, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechanac = fechanac;
        this.imagen = imagen;
        this.enviarSMS = enviarSMS;
        this.mensaje = mensaje;
    }

    protected Contacto(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        telefono = in.readString();
        fechanac = in.readString();
        enviarSMS = in.readByte() != 0;
        mensaje = in.readString();
        imagen = new BitmapDrawable((Bitmap) in.readParcelable(getClass().getClassLoader()));
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public boolean isEnviarSMS() {
        return enviarSMS;
    }

    public void setEnviarSMS(boolean enviarSMS) {
        this.enviarSMS = enviarSMS;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(fechanac);
        dest.writeByte((byte) (enviarSMS ? 1 : 0));
        dest.writeString(mensaje);
        // Para pasar la imagen como parcelable, la convertimos a bitmap.
        if(imagen != null) {
            dest.writeParcelable(((BitmapDrawable) imagen).getBitmap(), 0);
        }
    }
}
