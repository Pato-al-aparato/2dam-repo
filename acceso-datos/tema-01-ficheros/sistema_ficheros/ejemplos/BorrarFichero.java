package sistema_ficheros.ejemplos;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BorrarFichero {
    public static void main(String[] args) {
        Path fichero = Path.of("fichero.txt");

        try {
            Files.createFile(fichero);
            System.out.println("Fichero creado correctamente");

        } catch (FileAlreadyExistsException e){
            System.out.println("El fichero ya existe: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error");
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Presiona ENTER para borrar..");
            sc.nextLine(); // Espera la confirmación del usuario
        }

        try {
            Files.delete(fichero);
            System.out.println("Fichero borrado correctamente");
        } catch (IOException e){
            System.out.println("Error al borrar el fichero " + e.getMessage());
        }
    }
}
