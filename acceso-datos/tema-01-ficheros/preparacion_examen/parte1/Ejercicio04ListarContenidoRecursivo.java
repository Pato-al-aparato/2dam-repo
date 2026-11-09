package preparacion_examen.parte1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio04ListarContenidoRecursivo {
    public static void main (String[] args){
        try {
            Path ruta = Path.of(System.getProperty("user.dir"));
            Path ruta1 = ruta.resolve("prueba");
            Path ruta2 = ruta1.resolve("tema1");
            Path ruta3 = ruta2.resolve("ejercicio1.txt");
            Path ruta4 = ruta2.resolve("ejercicio2.txt");
            Path ruta5 = ruta1.resolve("tema2");
            Path ruta6 = ruta5.resolve("notas.txt");
            Path ruta7 = ruta1.resolve("resumen.txt");

            Files.createDirectory(ruta1);

            Files.createDirectory(ruta2);
            Files.createFile(ruta3);
            Files.createFile(ruta4);

            Files.createDirectory(ruta5);
            Files.createFile(ruta6);

            Files.createFile(ruta7);

            mostrarContenido(ruta1);

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void mostrarContenido(Path ruta) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
            for (Path elemento : stream){
                if (Files.isRegularFile(elemento)){
                    System.out.println("Fichero --> " + elemento.getFileName());
                }
                if (Files.isDirectory(elemento)){
                    System.out.println("Directorio --> " + elemento.getFileName());
                    mostrarContenido(elemento);
                }
            }

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
