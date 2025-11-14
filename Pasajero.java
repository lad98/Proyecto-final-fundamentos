package modelo.dto;

import java.io.Serializable;

public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;
	private String nombre;
    private String correoLectronico;

    public String getNombre() {
        return nombre;
    }

    public String getCorreoLectronico() {
        return correoLectronico;
    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCorreoLectronico(String correoLectronico) {
		this.correoLectronico = correoLectronico;
	}
    
    
}
