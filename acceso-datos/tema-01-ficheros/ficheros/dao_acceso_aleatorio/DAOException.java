package ficheros.dao_acceso_aleatorio;

public class DAOException extends Exception{
    public DAOException(String mensaje){
        super(mensaje);
    }

    // Para guardar la causa original (IOException, SQLException...etc)

    public DAOException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
