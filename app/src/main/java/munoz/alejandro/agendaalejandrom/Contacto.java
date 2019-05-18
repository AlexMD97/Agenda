package munoz.alejandro.agendaalejandrom;

import android.graphics.drawable.Drawable;

public class Contacto {
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
}
