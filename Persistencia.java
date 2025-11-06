package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Persistencia <T> {
	protected List<T> lista;
	protected ObjectInputStream entrada;
	protected ObjectOutputStream salida;
	protected String archivo;
	
	public Persistencia(String archivo) {
		this.lista = new ArrayList<T>();
		this.archivo = archivo;
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.lista = (List<T>) entrada.readObject();
				this.entrada.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
				guardar();
			}
		}
	}
	
	public void guardar() {
		try {
			this.salida= new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(lista); 
			this.salida.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
