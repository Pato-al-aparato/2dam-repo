package preparacion_examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio10InformacionFichero {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta del fichero: ");
        Path rutaFichero = Path.of(sc.nextLine());

        try {
            if (Files.exists(rutaFichero) && Files.isRegularFile(rutaFichero)){
                System.out.println("La ruta pertenece a un fichero existente");
                System.out.println("Nombre: " + rutaFichero.getFileName());
                System.out.println("Ruta: " + rutaFichero.toAbsolutePath());
                System.out.println("Tamaño: " + Files.size(rutaFichero) + " bytes");
            } else  {
                System.out.println("El fichero no existe o la ruta no pertenece a un fichero");
            }

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}