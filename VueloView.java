package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VueloView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public JSpinner spinner;
    public JComboBox aerolinea;
    public JComboBox destino;
    public JComboBox origen;
    public JButton btnConsultar;
    public JButton btnEliminar;
    public JButton btnActualizar;
    public JButton btnCrear;
    public JButton btnLeerTodos;
    public JTextField numero;
    public JTextField Filas;
    public JTextField Columnas;
    public JTable tablaAsientos;
    public JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VueloView frame = new VueloView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VueloView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 605, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Numero");
        lblNewLabel.setBounds(10, 11, 46, 14);
        contentPane.add(lblNewLabel);

        numero = new JTextField();
        numero.setBounds(76, 9, 104, 25); 
        contentPane.add(numero);

        spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(
                new Date(), 
                new Date(), 
                null,    
                Calendar.DAY_OF_YEAR));
        spinner.setBounds(396, 107, 156, 30);
        contentPane.add(spinner);

        JLabel lblOrigen = new JLabel("Origen");
        lblOrigen.setBounds(10, 60, 46, 14);
        contentPane.add(lblOrigen);

        JLabel lblDestino = new JLabel("Destino");
        lblDestino.setBounds(10, 115, 58, 14);
        contentPane.add(lblDestino);

        JLabel lblAerolinea = new JLabel("Aerolinea");
        lblAerolinea.setBounds(316, 60, 58, 14);
        contentPane.add(lblAerolinea);

        JLabel lblAsientos = new JLabel("Asientos");
        lblAsientos.setBounds(316, 11, 58, 14);
        contentPane.add(lblAsientos);

        JLabel lblFecha = new JLabel("FechaHoraSalida");
        lblFecha.setBounds(288, 115, 100, 14);
        contentPane.add(lblFecha);

        aerolinea = new JComboBox();
        aerolinea.setModel(new DefaultComboBoxModel(new String[]{
                "Avianca", "LATAM", "Viva Air", "Wingo"
        }));
        aerolinea.setBounds(400, 56, 86, 22);
        contentPane.add(aerolinea);

        destino = new JComboBox();
        destino.setModel(new DefaultComboBoxModel(new String[]{
                "Medellin", "Cartagena", "Bucaramanga", "Cali", "Barranquilla"
        }));
        destino.setBounds(78, 111, 102, 22);
        contentPane.add(destino);

        origen = new JComboBox();
        origen.setModel(new DefaultComboBoxModel(new String[]{
                "Medellin", "Cartagena", "Bucaramanga", "Cali", "Barranquilla"
        }));
        origen.setBounds(75, 56, 112, 22);
        contentPane.add(origen);

        btnConsultar = new JButton("Consultar Vuelo");
        btnConsultar.setBounds(124, 170, 112, 37);
        contentPane.add(btnConsultar);

        btnEliminar = new JButton("Eliminar Vuelo");
        btnEliminar.setBounds(368, 170, 112, 37);
        contentPane.add(btnEliminar);

        btnActualizar = new JButton("Actualizar Vuelo");
        btnActualizar.setBounds(246, 170, 112, 37);
        contentPane.add(btnActualizar);

        btnCrear = new JButton("Crear Vuelo");
        btnCrear.setBounds(10, 170, 104, 37);
        contentPane.add(btnCrear);

        btnLeerTodos = new JButton("Leer Todos");
        btnLeerTodos.setBounds(490, 170, 89, 37);
        contentPane.add(btnLeerTodos);

        JLabel lblFilas = new JLabel("Filas ");
        lblFilas.setBounds(316, 25, 46, 14);
        contentPane.add(lblFilas);

        JLabel lblNewLabel_1 = new JLabel("Columnas");
        lblNewLabel_1.setBounds(400, 25, 60, 14);
        contentPane.add(lblNewLabel_1);

        Filas = new JTextField();
        Filas.setBounds(338, 25, 37, 25); 
        contentPane.add(Filas);

        Columnas = new JTextField();
        Columnas.setBounds(449, 25, 37, 25); 
        contentPane.add(Columnas);

        JScrollPane Asientos = new JScrollPane();
        Asientos.setBounds(20, 229, 208, 184);
        contentPane.add(Asientos);

        tablaAsientos = new JTable();
        tablaAsientos.setModel(new DefaultTableModel(
                new Object[][]{},             
                new String[]{"Asientos", "Disponibilidad"}
        ));
        Asientos.setViewportView(tablaAsientos);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(277, 229, 302, 184);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},            
                new String[]{"Numero", "Origen", "Destino", "Aerolinea", "HoraSalida"}
        ));
        scrollPane.setViewportView(table);
    }
}
