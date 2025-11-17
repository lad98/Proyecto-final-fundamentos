package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.dao.VueloDAO;
import modelo.dto.Asiento;
import modelo.dto.Vuelo;
import vista.VueloView;

public class ControladorVuelo implements ActionListener {

    private VueloView vista;
    private VueloDAO modelo;
    private Vuelo vuelo;
    private int index;

    public ControladorVuelo(VueloView vista) {
        this.vista = vista;
        this.modelo = new VueloDAO();

        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnLeerTodos.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);

        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vista.btnCrear)) {
            crear();
        }

        if (e.getSource().equals(this.vista.btnConsultar)) {
            leer();
        }

        if (e.getSource().equals(this.vista.btnActualizar)) {
            this.vista.Filas.setEditable(false);
            this.vista.Columnas.setEditable(false);
            actualizar();
        }

        if (e.getSource().equals(this.vista.btnEliminar)) {
            eliminar();
        }

        if (e.getSource().equals(this.vista.btnLeerTodos)) {
            leerTodos();
        }
    }

    public void crear() {
        Vuelo nuevo = new Vuelo();

        try {
            nuevo.setNumero(Integer.valueOf(this.vista.numero.getText()));

           
            Vuelo temp = new Vuelo();
            temp.setNumero(nuevo.getNumero());
            if (modelo.leer(temp) != null) {
                JOptionPane.showMessageDialog(null,
                        "Error: Ya existe un vuelo con ese número.",
                        "Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            nuevo.setOrigen(this.vista.origen.getSelectedItem().toString());
            nuevo.setDestino(this.vista.destino.getSelectedItem().toString());
            nuevo.setAerolinea(this.vista.aerolinea.getSelectedItem().toString());

            Date fechaHoraSalida = (Date) this.vista.spinner.getValue();
            nuevo.setFechaHoraSalida(fechaHoraSalida);

            int fila = Integer.valueOf(vista.Filas.getText());
            int asientoFila = Integer.valueOf(vista.Columnas.getText());

            nuevo.generarAsientos(fila, asientoFila);

            if (modelo.crear(nuevo)) {
                JOptionPane.showMessageDialog(null, "Se adiciona un nuevo Vuelo a la Data");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Verifique que el número de vuelo, filas y columnas sean números.",
                    "Error de Entrada",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió un error inesperado al crear el vuelo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void leer() {

        Vuelo buscar = new Vuelo();

        try {
            buscar.setNumero(Integer.valueOf(this.vista.numero.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número de vuelo válido.",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vuelo vueloE = (Vuelo) modelo.leer(buscar);

        if (vueloE == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el vuelo");
        } else {

           
            index = modelo.leerTodos().indexOf(vueloE);

            this.vista.numero.setText(String.valueOf(vueloE.getNumero()));
            this.vista.origen.setSelectedItem(vueloE.getOrigen());
            this.vista.destino.setSelectedItem(vueloE.getDestino());
            this.vista.aerolinea.setSelectedItem(vueloE.getAerolinea());
            this.vista.spinner.setValue(vueloE.getFechaHoraSalida());

            Asiento[][] asientos = vueloE.getAsiento();

            
            if (asientos != null) {

                DefaultTableModel Asientost = 
                        (DefaultTableModel) this.vista.tablaAsientos.getModel();
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
            } else {
                JOptionPane.showMessageDialog(null,
                        "El vuelo no tiene asientos asignados.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void actualizar() {
        int respuesta = JOptionPane.showConfirmDialog(null, "Quieres actualizar los datos?");

        if (respuesta == JOptionPane.YES_OPTION) {

            
            Vuelo original = (Vuelo) modelo.leerTodos().get(index);

            Vuelo vuelo = new Vuelo();
            vuelo.setNumero(Integer.valueOf(this.vista.numero.getText()));
            vuelo.setOrigen(this.vista.origen.getSelectedItem().toString());
            vuelo.setDestino(this.vista.destino.getSelectedItem().toString());
            vuelo.setAerolinea(this.vista.aerolinea.getSelectedItem().toString());
            vuelo.setFechaHoraSalida((Date) this.vista.spinner.getValue());

            
            vuelo.setAsiento(original.getAsiento());

            modelo.actualizar(index, vuelo);

            JOptionPane.showMessageDialog(null, "Los datos se modificaron");
            this.vista.Filas.setEditable(true);
            this.vista.Columnas.setEditable(true);
        }
    }

    public void eliminar() {

        Vuelo buscar = new Vuelo();

        try {
            buscar.setNumero(Integer.valueOf(this.vista.numero.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Ingrese un número de vuelo válido para eliminar.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vuelo vueloE = (Vuelo) modelo.leer(buscar);

        if (vueloE == null) {
            JOptionPane.showMessageDialog(null,
                    "El vuelo con el número " + buscar.getNumero() + " no fue encontrado.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Asiento[][] asientosDelVuelo = vueloE.getAsiento();
        int contador = 0;

        if (asientosDelVuelo != null) {
            for (int i = 0; i < asientosDelVuelo.length; i++) {
                for (int j = 0; j < asientosDelVuelo[i].length; j++) {
                    if (asientosDelVuelo[i][j] != null &&
                            asientosDelVuelo[i][j].getPasajero() != null) {
                        contador++;
                    }
                }
            }
        }

        if (contador == 0) {

            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "El vuelo está vacío. ¿Confirmas la eliminación de los datos?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                boolean eliminado = modelo.eliminar(vueloE);

                if (eliminado) {

                    JOptionPane.showMessageDialog(null,
                            "El vuelo ha sido eliminado exitosamente.");

                    this.vista.numero.setText("");
                    this.vista.origen.setSelectedIndex(0);
                    this.vista.destino.setSelectedIndex(0);
                    this.vista.aerolinea.setSelectedIndex(0);
                    this.vista.spinner.setValue(new Date());
                    this.vista.Filas.setText("");
                    this.vista.Columnas.setText("");

                    DefaultTableModel asientosModel =
                            (DefaultTableModel) this.vista.tablaAsientos.getModel();
                    asientosModel.setRowCount(0);

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: No se pudo eliminar el vuelo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede eliminar el vuelo. Hay " + contador + " asientos ocupados.",
                    "Eliminación Bloqueada",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void leerTodos() {

        List<Vuelo> listaVuelos = modelo.leerTodos();

        DefaultTableModel tableModel =
                (DefaultTableModel) this.vista.table.getModel();
        tableModel.setRowCount(0);

        for (Vuelo vuelo : listaVuelos) {

            Object[] fila = {
                    vuelo.getNumero(),
                    vuelo.getOrigen(),
                    vuelo.getDestino(),
                    vuelo.getAerolinea(),
                    vuelo.getFechaHoraSalida()
            };

            tableModel.addRow(fila);
        }

        if (listaVuelos.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay vuelos registrados en el sistema.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
