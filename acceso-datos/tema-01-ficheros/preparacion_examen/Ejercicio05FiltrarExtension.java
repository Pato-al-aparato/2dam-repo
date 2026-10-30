package preparacion_examen;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio05FiltrarExtension {
    public static void main (String[] args){
        try {
            Path ruta = Path.of("filtros");
            Path ruta1 = ruta.resolve("notas.txt");
            Path ruta2 = ruta.resolve("resumen.txt");
            Path ruta3 = ruta.resolve("empleados.dat");
            Path ruta4 = ruta.resolve("Main.java");
            Path ruta5 = ruta.resolve("tema1");

            Files.createDirectory(ruta);
            Files.createFile(ruta1);
            Files.createFile(ruta2);
            Files.createFile(ruta3);
            Files.createFile(ruta4);
            Files.createDirectory(ruta5);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta, "*.txt")){
                for (Path elemento : stream){
                    System.out.println(elemento.getFileName());
                }
            }

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
