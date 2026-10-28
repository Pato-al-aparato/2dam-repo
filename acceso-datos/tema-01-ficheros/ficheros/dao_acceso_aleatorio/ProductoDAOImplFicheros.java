package ficheros.dao_acceso_aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProductoDAOImplFicheros implements ProductoDAO{
    private static final int TAM_REGISTRO = 4 + 8;
    private final Path ruta;

    public ProductoDAOImplFicheros(Path ruta) throws DAOException {
        this.ruta = ruta;
        try {
            if (Files.notExists(ruta)){
                Files.createFile(ruta);
            }


        } catch(IOException e){
            throw new DAOException("No se puede crear el fichero  " + ruta, e);
        }
    }


    @Override
    public void insertar(Producto producto) throws DAOException {

    }

    @Override
    public List<Producto> listar() throws DAOException {
        return List.of();
    }

    @Override
    public boolean actualizar(Producto producto) throws DAOException {
        return false;
    }

    // MÉTODOS AUXILIARES

    // Contar el número de registros que contiene el fichero
    private long contar (RandomAccessFile raf) throws IOException {
        return raf.length() / TAM_REGISTRO;
    }

    // Leer el registro N (concreto)
    private Producto leerEn(RandomAccessFile raf, long numRegistro) throws IOException {
        raf.seek((numRegistro - 1) * TAM_REGISTRO);
        int referencia = raf.readInt();
        double precio = raf.readDouble();
        return new Producto(referencia, precio);
    }

    // Escribir un Producto en un registro concreto
    private void escribirEn(RandomAccessFile raf, long numRegistro, Producto producto) throws IOException {
        raf.seek((numRegistro - 1) * TAM_REGISTRO);
        raf.writeInt(producto.getReferencia());
        raf.writeDouble(producto.getPrecio());
    }
}
