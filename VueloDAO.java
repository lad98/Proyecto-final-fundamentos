package modeloDAO;

import modeloDTO.Vuelo;

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
        for (Vuelo vuelo: lista) {
            if(vuelo.getNumero()==((Vuelo) object).getNumero());
            return vuelo;
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
        boolean estado = lista.remove(object);
        guardar();
        return estado;
    }

    @Override
    public int buscarIndex(Object object) {
        return lista.indexOf(object);
    }

    @Override
    public List leerTodos() {
        return lista;
    }
}
