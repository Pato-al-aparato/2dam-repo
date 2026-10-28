package ficheros.sistema_ficheros.actividades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act1 {
    public static void main(String[] args) {
        Path carpeta = Path.of(System.getProperty("user.dir"),"prueba");
        Path subcarpeta1 = carpeta.resolve("subcarpeta1");
        Path subcarpeta2 = subcarpeta1.resolve("subcarpeta2");
        Path fichero1 = carpeta.resolve("fichero1.txt");
        Path fichero2 = carpeta.resolve("fichero2.txt");
        Path fichero3 = subcarpeta2.resolve("fichero3.txt");

        try {
            Files.createDirectory(carpeta);
            Files.createFile(fichero1);
            Files.createFile(fichero2);
            Files.createDirectory(subcarpeta1);
            Files.createDirectory(subcarpeta2);
            Files.createFile(fichero3);

        } catch (IOException e){
            System.out.println("Error al crear el fichero o carpeta: " + e.getMessage());
        }

        System.out.println("Carpeta: " + carpeta.toAbsolutePath());
        System.out.println("Fichero1: " + fichero1.toAbsolutePath());
        System.out.println("Fichero2: " + fichero2.toAbsolutePath());
        System.out.println("Subcarpeta1: " + subcarpeta1.toAbsolutePath());
        System.out.println("Subcarpeta2: " + subcarpeta2.toAbsolutePath());
        System.out.println("Fichero3: " + fichero3.toAbsolutePath());
    }
}
