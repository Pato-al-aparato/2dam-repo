package Actividades;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Act5 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta donde quieras buscar: ");
        String r = sc.nextLine();

        Path ruta = Path.of(r);
        System.out.print("Extensión: ");
        String extension = sc.nextLine();

        if(Files.exists(ruta) && (Files.isDirectory(ruta))){
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta,
                    entry -> Files.isRegularFile(entry) && entry.toString().endsWith(extension))){
                for (Path fichero: stream){
                    System.out.println(fichero.getFileName());
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}