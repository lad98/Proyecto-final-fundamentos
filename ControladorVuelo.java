public class ControladorVuelo implements ActionListener {
	
	private VistaVuelo vista;
	private VueloDAO modelo;
	private int index;
	
	
	public ControladorVuelo(VistaVuelo vista) {
		this.vista= vista;
		this.modelo = new VueloDao();
		
		this.vista.btnActualizar.addActionListener(this);
		this.vista.btnLeer.addActionListener(this);
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
		if (e.getSource().equals(this.vista.btnLeer));
		leer();
		if (e.getSource().equals(this.vista.btnActualizar));
		actualizar();
		if (e.getSource().equals(this.vista.btnEliminar));
		eliminar();
		if (e.getSource().equals(this.vista.btnLeerTodos));
		leerTodos();
	}
	
	public void crear() {
		Vuelo nuevo = new Vuelo();
		nuevo.setNumero(Integer.valueOf(vista.getText)));
		nuevo.setOrigen(Integer.valueOf(vista.getText)));
		nuevo.setDestino(Integer.valueOf(vista.getText)));
		nuevo.setFechaHoraSalida(Integer.valueOf(vista.getText)));
		nuevo.setAreolinea(Integer.valueOf(vista.getText)));
		nuevo.setAsientos(Integer.valueOf(vista.getText)));
		
		if(modelo.crear(nuevo)) 
			JOptionPane.showMessageDialog(null, "Se adiciona un nuevo Vuelo a la Data");
		else 
			JOptionPane.showMessageDialog(null, "ERROR no se pudo adicionar el Vuelo");
		
	}
	
	public void leer () {
		Vuelo buscar = new Vuelo();
		buscar.setNumero(Integer.valueOf(vista.getText)));
		Vuelo encontrado = (Vuelo) modelo.leer(buscar);
		
		
		
		
		}
		
		
	}
	
	
}
