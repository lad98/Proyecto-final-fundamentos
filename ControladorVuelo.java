package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
		this.vista= vista;
		this.modelo = new VueloDAO();
		
		this.vista.btnActualizar.addActionListener(this);
		this.vista.btnConsultar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnCrear.addActionListener(this);
		this.vista.btnLeerTodos.addActionListener(this);
		
		this.vista.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.vista.btnCrear));
		crear();
		if (e.getSource().equals(this.vista.btnConsultar));
		leer();
		if (e.getSource().equals(this.vista.btnActualizar));
		this.vista.Filas.setEditable(false);
		this.vista.Columnas.setEditable(false);
		actualizar();
		if (e.getSource().equals(this.vista.btnEliminar));
		eliminar();
		if (e.getSource().equals(this.vista.btnLeerTodos));
		leerTodos();
	}
	
	public void crear() {
		Vuelo nuevo = new Vuelo();
		vuelo.setNumero(Integer.valueOf(this.vista.numero.getText()));
		vuelo.setOrigen(this.vista.origen.getSelectedItem().toString());
		vuelo.setDestino(this.vista.destino.getSelectedItem().toString());
		vuelo.setAerolinea(this.vista.aerolinea.getSelectedItem().toString());
		Date fechaHoraSalida = (Date) this.vista.spinner.getValue();
		
		int fila= Integer.valueOf(vista.Filas.getText());
		int asientoFila=  Integer.valueOf(vista.Columnas.getText());
		
		vuelo.generarAsientos(fila, asientoFila);
		if(modelo.crear(nuevo)) 
			JOptionPane.showMessageDialog(null, "Se adiciona un nuevo Vuelo a la Data");
		else 
			JOptionPane.showMessageDialog(null, "ERROR no se pudo adicionar el Vuelo");
		
	}
	
	public void leer () {
		Vuelo buscar = new Vuelo();
		buscar.setNumero(Integer.valueOf(vista.numero.getText()));
		Vuelo vueloE = (Vuelo) modelo.leer(vuelo);
		if(vueloE == null) 
			JOptionPane.showMessageDialog(null, "No se encontro el vuelo");
		else {
			index = modelo.buscarIndex(vueloE);
			this.vista.numero.setText(String.valueOf(vueloE.getNumero()));
			this.vista.origen.setSelectedItem(vueloE.getOrigen());
			this.vista.destino.setSelectedItem(vueloE.getDestino());
			this.vista.aerolinea.setSelectedItem(vueloE.getAerolinea());
			this.vista.spinner.setValue(vueloE.getFechaHoraSalida());
			DefaultTableModel Asientost;
			
			Asientost = (DefaultTableModel) this.vista.tablaAsientos.getModel();
			Asiento[][] asientos = vueloE.getAsiento();
			int filas = Asientost.getRowCount();
			for (int i=0; i<filas;i++) {
				Asientost.removeRow(0);
			}
			for (Asiento[] filaAsientos : asientos) { 
			    for (Asiento asiento : filaAsientos) {
			        
			        Object[] fila = { 
			            asiento.getFila(),
			            asiento.getPasajero() == null ? "Disponible" : "Ocupado"
			        };
			        Asientost.addRow(fila);
				
			}
			
		}
			
		}	
		
		}
		public void actualizar() {
			int respuesta = JOptionPane.showConfirmDialog(null, "Quieres actualizar los datos?");
			if(respuesta == JOptionPane.YES_OPTION) {
				Vuelo vuelo = new Vuelo();
				
			}
		}
		
	}
	
	
