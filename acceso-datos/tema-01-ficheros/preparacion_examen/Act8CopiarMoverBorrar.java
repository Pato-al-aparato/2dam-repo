package preparacion_examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act8CopiarMoverBorrar {
    public static void main(String[] args){
        crearEstructura();
    }

    private static void crearEstructura() {
        try {
            Path ruta = Path.of("operaciones");
            Path ruta1 = ruta.resolve("origen");
            Path ruta2 = ruta1.resolve("datos.txt");
            Path ruta3 = ruta.resolve("destino");

            Files.createDirectory(ruta);
            Files.createDirectory(ruta1);
            Files.createFile(ruta2);
            Files.createDirectory(ruta3);


        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
