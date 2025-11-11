package Vista;

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

public class VueloView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField numero;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VueloView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		numero = new JTextField();
		numero.setBounds(60, 8, 104, 17);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1762837200000L), new Date(1762837200000L), null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(106, 205, 156, 30);
		contentPane.add(spinner);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(10, 51, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(10, 89, 58, 14);
		contentPane.add(lblDestino);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10, 127, 58, 14);
		contentPane.add(lblAerolinea);
		
		JLabel lblAsientos = new JLabel("Asientos");
		lblAsientos.setBounds(10, 169, 58, 14);
		contentPane.add(lblAsientos);
		
		JLabel lblFecha = new JLabel("FechaHoraSalida");
		lblFecha.setBounds(10, 211, 86, 14);
		contentPane.add(lblFecha);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1A", "1B ", "1C ", "1D", "1E"}));
		comboBox.setBounds(78, 165, 75, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Avianca ", "LATAM", "Viva Air", "Wingo"}));
		comboBox_1.setBounds(78, 123, 86, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Medellin", "Cartagena ", "Bucaramanga", "Cali", "Barranquilla "}));
		comboBox_2.setBounds(80, 85, 102, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Medellin", "Cartagena ", "Bucaramanga", "Cali", "Barranquilla "}));
		comboBox_3.setBounds(70, 47, 112, 22);
		contentPane.add(comboBox_3);

	}
}
