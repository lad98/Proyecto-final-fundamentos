package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



import Vista.AsignarAsientoView;
import modeloDAO.VueloDAO;
import modeloDTO.Vuelo;
import modeloDTO.Asiento;
import modeloDTO.Pasajero;
public class AsignarAsientoController implements ActionListener {

    private AsignarAsientoView Vista;
    private VueloDAO modelo;
    public Vuelo vuelo;
    
    private int index;

    public AsignarAsientoController(AsignarAsientoView Vista) {
        this.Vista = Vista;
        this.modelo = new VueloDAO();

        this.Vista.Consultar.addActionListener(this);
        this.Vista.Asignar.addActionListener(this);
        this.Vista.MostrarAsientos.addActionListener(this);
      

        this.Vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.Vista.Asignar)) {
            asignarAsiento();
        }

        if (e.getSource().equals(this.Vista.Consultar)) {
            leer();
        }
        
        if (e.getSource().equals(this.Vista.MostrarAsientos)) {
            mostrarAsientos();
        }
  
    }
     public void asignarAsiento() {
        Vuelo vueloE = this.vuelo;

        if (vueloE == null) {
            JOptionPane.showMessageDialog(null, "Primero consulte un vuelo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = -1;
        int asientoFila = -1;

        try {
            fila = Integer.parseInt(Vista.Fila.getText()) - 1;
            String letraTexto = Vista.Letra.getText();
            
            // VALIDAR QUE SEA MAYÚSCULA
            if (letraTexto.isEmpty() || !Character.isUpperCase(letraTexto.charAt(0))) {
                JOptionPane.showMessageDialog(null, "Ingrese una letra MAYÚSCULA (A-F).",
                        "Error entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            asientoFila = letraTexto.charAt(0) - 'A';
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores válidos (Fila: número, Letra: A-F).",
                    "Error entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Asiento[][] asientosDelVuelo = vueloE.getAsiento();

        if (asientosDelVuelo == null) {
            JOptionPane.showMessageDialog(null, "El vuelo no tiene asientos cargados.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fila < 0 || fila >= asientosDelVuelo.length ||
            asientoFila < 0 || asientoFila >= asientosDelVuelo[fila].length) {

            JOptionPane.showMessageDialog(null, "Fila o asiento fuera de rango.",
                    "Error de rango", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Asiento asientoSeleccionado = asientosDelVuelo[fila][asientoFila];

        if (asientoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "El asiento no existe.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (asientoSeleccionado.getPasajero() == null) {

            String nombrePasajero = JOptionPane.showInputDialog(null,
                    "Ingrese el nombre del pasajero:",
                    "Asignar Pasajero",
                    JOptionPane.QUESTION_MESSAGE);

            if (nombrePasajero == null || nombrePasajero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String correoPasajero = JOptionPane.showInputDialog(null,
                    "Ingrese el correo electrónico del pasajero:",
                    "Asignar Pasajero",
                    JOptionPane.QUESTION_MESSAGE);

            if (correoPasajero == null || correoPasajero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un correo.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Pasajero nuevoPasajero = new Pasajero();
            nuevoPasajero.setNombre(nombrePasajero.trim());
            nuevoPasajero.setCorreoLectronico(correoPasajero.trim());

            asientoSeleccionado.setPasajero(nuevoPasajero);

            JOptionPane.showMessageDialog(null,
                    "Asiento asignado a " + nombrePasajero + ". Fila " + (fila + 1) +
                    ", Asiento " + (char)('A' + asientoFila),
                    "Asignado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Asiento ocupado por: " + asientoSeleccionado.getPasajero().getNombre(),
                    "Ocupado", JOptionPane.WARNING_MESSAGE);
        }

        mostrarAsientos();
    }

    public void leer() {
        int numVuelo = -1;

        try {
            numVuelo = Integer.valueOf(Vista.NumVuelo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número de vuelo válido.",
                    "Error entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Vuelo> listaVuelos = modelo.leerTodos();
        Vuelo vueloE = null;

    
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getNumero() == numVuelo) {
                vueloE = vuelo;
                break;
            }
        }

        if (vueloE == null) {
            JOptionPane.showMessageDialog(null, "Vuelo no encontrado.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    
        this.vuelo = vueloE;

 
        DefaultTableModel tableModel = (DefaultTableModel) this.Vista.TablaVuelos.getModel();
        tableModel.setRowCount(0);

        Object[] fila = {
            vueloE.getNumero(),
            vueloE.getOrigen(),
            vueloE.getDestino(),
            vueloE.getAerolinea(),
            vueloE.getFechaHoraSalida()
        };

        tableModel.addRow(fila);  
    }

    public void mostrarAsientos() {
        int numVuelo = -1;

        try {
            numVuelo = Integer.valueOf(Vista.NumVuelo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número de vuelo válido.",
                    "Error entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Vuelo> listaVuelos = modelo.leerTodos();
        Vuelo vueloE = null;

        
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getNumero() == numVuelo) {
                vueloE = vuelo;
                break;
            }
        }

        if (vueloE == null) {
            JOptionPane.showMessageDialog(null, "Vuelo no encontrado.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Asiento[][] asientos = vueloE.getAsiento();

        if (asientos != null) {
            DefaultTableModel Asientost =
                    (DefaultTableModel) this.Vista.ListaAsientos.getModel();
            Asientost.setRowCount(0);

            for (Asiento[] filaAsientos : asientos) {
                if (filaAsientos != null) {
                    for (Asiento asiento : filaAsientos) {
                        if (asiento != null) {
                            Object[] fila = {
                                    asiento.getFila() + "-" + asiento.getAsiento(),
                                    asiento.getPasajero() == null ? "Disponible" : "Ocupado"
                            };
                            Asientost.addRow(fila);
                        }
                    }
                }
            }
        }
    }

}
