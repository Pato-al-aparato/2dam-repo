package preparacion_examen;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Act7FiltroRecursividadConUsuario {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String extension = ".";

        System.out.print("Introduce la ruta absoluta donde quieras buscar: ");
        Path ruta = Path.of(sc.nextLine());

        System.out.print("Introduce la extensión de los ficheros a buscar (por ejemplo txt): ");
        extension+= sc.nextLine();

        sc.close();

        buscarExtension(ruta,extension);
    }

    private static void buscarExtension(Path ruta, String extension) {
        if((Files.exists(ruta)) && (Files.isDirectory(ruta))){
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
                for (Path elemento : stream){
                    if (Files.isDirectory(elemento)){
                        buscarExtension(elemento,extension);
                    }

                    if (Files.isRegularFile(elemento) && elemento.getFileName().toString().endsWith(extension)){
                        System.out.println(elemento.getFileName());
                    }
                }

            } catch(IOException e){
                System.err.println("Error de E/S: " + e.getMessage());
            }
        } else {
            System.err.println("La ruta no existe o no es un directorio");
        }
    }
}