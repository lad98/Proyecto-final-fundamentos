package modeloDTO;

import java.io.Serializable;
import java.util.Date;

public class Vuelo implements Serializable {
    private int numero;
    private String origen;
    private String destino;
    private Date fechaHoraSalida;
    private String aerolinea;
    private Asiento[][] asiento;

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
        return asiento;
    }

    public void generarAsientos(int filas, int asientosFilas) {
        Asiento[][] asientos = new Asiento [32][32];
        for (int i = 0; i < filas; i++){
            for ( int j = 0; j < asientosFilas ; j++){
                char asiento = (char)('A'+j);
                int fila = (i + 1);
                asientos[i][j] = new Asiento(fila, asiento);
            }
        }
    }


}
