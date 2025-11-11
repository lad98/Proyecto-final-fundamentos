package modeloDTO;

import java.io.Serializable;

public class Pasajero implements Serializable {
    private String nombre;
    private String correoLectronico;

    public String getNombre() {
        return nombre;
    }

    public String getCorreoLectronico() {
        return correoLectronico;
    }
}
