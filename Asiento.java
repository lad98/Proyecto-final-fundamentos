package modeloDTO;

import java.io.Serializable;

public class Asiento implements Serializable {
    private int fila;
    private char asiento;
    private Pasajero pasajero;

    public Asiento(int fila, char asiento) {
        this.fila = fila;
        this.asiento = asiento;
    }

    public int getFila() {
        return fila;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public char getAsiento() {
        return asiento;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
