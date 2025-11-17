package modelo.dao;

	import modelo.dto.Vuelo;

	import java.util.List;



	public class VueloDAO extends Persistencia<Vuelo> implements ICrud {
	    public VueloDAO() {
	        super("Vuelo");
	    }

	    @Override
	    public boolean crear(Object object) {

	        boolean estado = lista.add((Vuelo) object);
	        guardar();
	        return estado;
	    }

	    @Override
	    public Object leer(Object object) {
	        for (Vuelo vuelo : lista) {
	            if (vuelo.getNumero() == ((Vuelo) object).getNumero()) {
	                return vuelo;
	            }
	        }
	        return null;
	    }
	    
	    @Override
	    public Object actualizar(int index, Object object) {
	        Object estado = lista.set(index,(Vuelo) object);
	        guardar();
	        return estado;
	    }


	    @Override
	    public boolean eliminar(Object object) {
	        int index = buscarIndex(object);
	        if (index != -1) {
	            lista.remove(index);
	            guardar();
	            return true;
	        }
	        return false;
	    }


	    @Override
	    public int buscarIndex(Object object) {
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).getNumero() == ((Vuelo) object).getNumero()) {
	                return i;
	            }
	        }
	        return -1;
	    }


	    @Override
	    public List<Vuelo> leerTodos() {
	        return lista;
	    }
	}

