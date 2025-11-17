package modelo.dto;


import java.io.Serializable;
import java.util.Date;

public class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;
	private int numero;
    private String origen;
    private String destino;
    private Date fechaHoraSalida;
    private String aerolinea;
    private Asiento[][] asientos;
	

    public int getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public Asiento[][] getAsiento() {
        return asientos;
    }

    
    public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public void setAsiento(Asiento[][] asiento) {
		this.asientos = asiento;
	}

	public void generarAsientos(int filas, int asientosFilas) {
	    
	    this.asientos = new Asiento[filas][asientosFilas];
	    
	    for (int i = 0; i < filas; i++){
	        for ( int j = 0; j < asientosFilas ; j++){
	            
	           
	            Asiento asiento = new Asiento();
	            
	           
	            asiento.setFila(i+1);
	            asiento.setAsiento((char)('A'+j));
	            asiento.setPasajero(null);
	            
	            this.asientos[i][j]= asiento;
	        }
	    }
	}

}
    }


}
