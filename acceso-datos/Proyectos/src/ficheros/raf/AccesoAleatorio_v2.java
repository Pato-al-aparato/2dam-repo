package ficheros.raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class AccesoAleatorio_v2 {
    private static final int LONG_APELLIDO = 20; // 20 caracteres
    private static final int BYTES_INT = 4;
    private static final int BYTES_DOUBLE = 8;
    private static final int BYTES_CHAR = 2;
    private static final int TAMANO_REGISTRO = BYTES_INT
            + (LONG_APELLIDO*BYTES_CHAR)
            + BYTES_INT
            + BYTES_DOUBLE; // Cada registro ocupa 56 bytes

    private static final Path RUTA = Path.of("ficheros_prueba","fichero_aleatorio_v2.dat");

    public static void main(String[] args) {
        try {
            if (RUTA.getParent() != null){
                Files.createDirectories(RUTA.getParent());
            }

            String[] apellidos = {"FERNÁNDEZ", "GIL", "LÓPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
            int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
            double[] salarios = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

            // 1) Escribir los registros en el fichero
            try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")){
                // sobreescribimos
                raf.setLength(0);

                for (int i = 0; i < apellidos.length; i++) {

                }
            }



            // 2) Modificar el departamento del tercer empleado
            // 3) Sumar los salarios de todos los empleados
            // 4) Leer y mostrar por consola los datos del 5º empleado
            // 5) Actualizar el salario del 3º registro y mostrarlo
            // 6) Mostrar todos los registros


        } catch(IOException e){
            System.err.println("Erroe de I/O" + e.getMessage());
        }
    }
}
