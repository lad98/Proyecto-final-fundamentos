package Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsignarAsientoView extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField NumVuelo;
	public JTable TablaVuelos;
	public JTextField Fila;
	public JTextField Letra;
	public JTable table;
	public JTable ListaAsientos;
	public JButton Consultar;
	public JButton Asignar;
	public JButton MostrarAsientos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarAsientoView frame = new AsignarAsientoView();
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
	public AsignarAsientoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelVuelo = new JLabel("Número de Vuelo");
		labelVuelo.setBounds(10, 10, 85, 20);
		labelVuelo.setToolTipText("");
		contentPane.add(labelVuelo);
		
		NumVuelo = new JTextField();
		NumVuelo.setBounds(94, 11, 96, 18);
		contentPane.add(NumVuelo);
		NumVuelo.setColumns(10);
		
		TablaVuelos = new JTable();
		TablaVuelos.setModel(new DefaultTableModel(
			new Object[][] {
				{"Numero", "Origen", "Destino", "Fecha Salida", "Hora Salida", "Aerolinea", "Asientos"},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Numero", "Origen", "Destino", "Fecha Salida", "Hora Salida", "Aerolinea", "Asientos"
			}
		));
		TablaVuelos.setBounds(10, 40, 369, 32);
		contentPane.add(TablaVuelos);
		
		JLabel lblNewLabel_1 = new JLabel("Fila");
		lblNewLabel_1.setBounds(265, 82, 47, 20);
		contentPane.add(lblNewLabel_1);
		
		Fila = new JTextField();
		Fila.setBounds(304, 83, 39, 18);
		contentPane.add(Fila);
		Fila.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Letra");
		lblNewLabel_2.setBounds(265, 119, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		Letra = new JTextField();
		Letra.setColumns(10);
		Letra.setBounds(304, 113, 39, 18);
		contentPane.add(Letra);
		
		
		Asignar = new JButton("Asignar Asiento");
		Asignar.setBounds(247, 149, 127, 20);
		contentPane.add(Asignar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 127, 115);
		contentPane.add(scrollPane);
		
		ListaAsientos = new JTable();
		ListaAsientos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asiento", "Disponibilidad"
			}
		));
		scrollPane.setViewportView(ListaAsientos);
		
		
		Consultar = new JButton("Consultar Vuelo");
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Consultar.setBounds(197, 10, 112, 20);
		contentPane.add(Consultar);
		
		
		MostrarAsientos = new JButton("Mostrar Asientos");
		MostrarAsientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MostrarAsientos.setBounds(10, 207, 119, 20);
		contentPane.add(MostrarAsientos);
	}
}
