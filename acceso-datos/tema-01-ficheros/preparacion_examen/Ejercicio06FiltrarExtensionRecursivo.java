package preparacion_examen;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio06FiltrarExtensionRecursivo {
    public static void main (String[] args){
        try {
            String extension = ".txt";

            Path ruta = Path.of("busqueda");
            Path ruta1 = ruta.resolve("notas.txt");
            Path ruta2 = ruta.resolve("datos.dat");
            Path ruta3 = ruta.resolve("tema1");
            Path ruta4 = ruta3.resolve("ejercicio1.txt");
            Path ruta5 = ruta3.resolve("Main.java");
            Path ruta6 = ruta.resolve("tema2");
            Path ruta7 = ruta6.resolve("ejercicio2.txt");
            Path ruta8 = ruta6.resolve("personas.dat");

            Files.createDirectory(ruta);
            Files.createFile(ruta1);
            Files.createFile(ruta2);
            Files.createDirectory(ruta3);
            Files.createFile(ruta4);
            Files.createFile(ruta5);
            Files.createDirectory(ruta6);
            Files.createFile(ruta7);
            Files.createFile(ruta8);

            buscarExtension(ruta, extension);

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void buscarExtension(Path ruta, String extension) {
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){

                for (Path elememto : stream){
                    if (Files.isDirectory(elememto)){
                        buscarExtension(elememto,extension);
                    }

                    if (Files.isRegularFile(elememto) && elememto.getFileName().toString().endsWith(extension)){
                        System.out.println(elememto.getFileName());
                    }
                }

            } catch (IOException e){
                System.err.println("Error de E/S: " + e.getMessage());
            }
    }
}