package ficheros.dao_acceso_aleatorio;

import java.util.List;

public interface ProductoDAO {
    void insertar(Producto producto) throws DAOException;
    List<Producto> listar() throws DAOException;
    boolean actualizar (Producto producto) throws DAOException;


}
