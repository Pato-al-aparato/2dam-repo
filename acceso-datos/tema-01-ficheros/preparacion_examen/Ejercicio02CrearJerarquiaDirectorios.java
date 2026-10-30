package preparacion_examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio02CrearJerarquiaDirectorios {
    public static void main(String[] args) {
        try {
            Path path = Path.of("examen","tema1","ejercicios");

            Files.createDirectories(path);

            Path path2 = path.resolve("ejericicios.txt");

            if (Files.notExists(path2)){
                Files.createFile(path2);
                System.out.println("Fichero creado correctamente");
            } else {
                System.out.println("El fichero ya existe");
            }

            System.out.println("Ruta absoluta del fichero: " + path2.toAbsolutePath());

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
