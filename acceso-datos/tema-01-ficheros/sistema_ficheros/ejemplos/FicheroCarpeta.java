package sistema_ficheros.ejemplos;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FicheroCarpeta {
    public static void main(String[] args) {

        Path carpeta = Path.of("carpeta");
        if (Files.notExists(carpeta)) {
            try {
                Files.createDirectory(carpeta);
                System.out.println("Carpeta creada correctamente");

            } catch (IOException e) {
                System.out.println("Error al crear la carpeta " + e.getMessage());
            }
        } else {
            System.out.printf("La carpeta ya existe en %s", carpeta.toAbsolutePath());
        }

        // Creamos el fichero dentro de la carpeta base
        Path fichero = carpeta.resolve("fichero.txt");

        try {
            Files.createFile(fichero);
            System.out.println("Fichero creado correctamente");
            System.out.println("Ubicación: " + fichero.toAbsolutePath());
            System.out.println("Tamaño: " + Files.size(fichero));


        } catch (FileAlreadyExistsException e) { // Modificar para usar la excepción FileAlreadyExistsException
            System.out.println("El fichero ya existe o no se ha podido crear");
        } catch (IOException e) {
            System.out.println("El fichero no se ha podido crear " + e.getMessage());
        }
    }
}