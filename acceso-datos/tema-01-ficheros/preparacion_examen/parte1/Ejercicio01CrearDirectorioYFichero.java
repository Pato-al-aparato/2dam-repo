package preparacion_examen.parte1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* Algunos mini ejercicios con los conceptos base de creación de rutas,
ficheros, directorios y la comporbación de que existen*/

public class Ejercicio01CrearDirectorioYFichero {
    public static void main(String[] args) {
        try {
            Path path = Path.of("pruebas");

            System.out.println("\nLa ruta absoluta de " + path.getFileName() + " es: " + path.toAbsolutePath());

            if (Files.notExists(path)){
                Files.createDirectory(path);
                System.out.println("Directorio " + path.getFileName() +" creado correctamente");
            } else {
                System.out.println("El directorio ya existe");
            }

            Path path2 = path.resolve("datos.txt");

            if (Files.notExists(path2)){
                Files.createFile(path2);
                System.out.println("Fichero " + path2.getFileName() + " creado correctamente");
            } else {
                System.out.println("El fichero ya existe");
            }

            System.out.println("\nRuta absoluta de " + path2.getFileName() + " es: " + path2.toAbsolutePath());

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
