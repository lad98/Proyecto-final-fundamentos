package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.AsignarAsientoView;
import Vista.IUP;
import Vista.VueloView;

public class IUPcontroller implements ActionListener {
	private IUP vista;
	
	public IUPcontroller(IUP vista) {
		super();
		this.vista = vista;
		this.vista.asiento.addActionListener(this);
		this.vista.vuelo.addActionListener(this);
		this.vista.setVisible(true);
				
	}

 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.vista.vuelo)) {
			  VueloController vueloController = new VueloController(new VueloView()) ;
		}
		if(e.getSource().equals(this.vista.asiento)) {
			AsignarAsientoController asignarAsientoController = new AsignarAsientoController(new
					AsignarAsientoView());
		}
			
	}
		
		
}
