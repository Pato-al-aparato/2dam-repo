package preparacion_examen;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Act9Borrar {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        Path raiz = Path.of("borrarPrueba");
        Path fichero1 = raiz.resolve("fichero1.txt");
        Path fichero2 = raiz.resolve("fichero2.txt");
        Path carpeta = raiz.resolve("carpeta");
        Path fichero3 = carpeta.resolve("fichero3.txt");
        Path subcarpeta = carpeta.resolve("subcarpeta");
        Path fichero4 = subcarpeta.resolve("fichero4.txt");

        try {
            Files.createDirectory(raiz);
            Files.createFile(fichero1);
            Files.createFile(fichero2);
            Files.createDirectory(carpeta);
            Files.createFile(fichero3);
            Files.createDirectory(subcarpeta);
            Files.createFile(fichero4);

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }

        System.out.println("Pulsa ENTER si quieres borrar..");
        String respuesta = sc.nextLine();

        borrarDirectorio(raiz);
    }

    private static void borrarDirectorio(Path ruta) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
            for (Path elemento : stream){
                if (Files.isDirectory(elemento)){
                    borrarDirectorio(elemento);
                }

                if (Files.isRegularFile(elemento)){
                    Files.deleteIfExists(elemento);
                }
            }

            Files.deleteIfExists(ruta);

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
