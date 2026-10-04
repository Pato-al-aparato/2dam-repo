package Actividades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Act5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta donde quieras buscar: ");
        Path ruta = Path.of(sc.nextLine());

        System.out.print("Introduce la extensión: ");
        String extension = sc.nextLine();

        if (Files.exists(ruta) && Files.isDirectory(ruta)) {

            try (Stream<Path> archivos = Files.walk(ruta)) {
                archivos
                        .filter(Files::isRegularFile)
                        .filter(fichero -> fichero.toString().endsWith(extension))
                        .forEach(System.out::println);

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("La ruta no existe o no es un directorio.");
        }
    }
}