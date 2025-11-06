package modelo.dao;

import java.util.List;

public interface ICrud {
	
	public boolean crear(Object object);
	
	public Object leer(Object object);
	
	public Object actualizar(int index, Object object);
	
	public boolean eliminar(Object object);
	
	public int buscarIndex(Object object);
	
	public List leerTodos();

}
