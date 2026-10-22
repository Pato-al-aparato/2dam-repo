package Actividades;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act4 {
    public static void main(String[] args) {
        Path ruta = Path.of(System.getProperty("user.dir"));

        imprimirRecursivo(ruta, 0);
    }

    public static void imprimirRecursivo(Path ruta, int nivel) {
        String identacion = " ".repeat(nivel);

        if (Files.isDirectory(ruta)) {
            System.out.println(identacion + "Directorio ---> " + ruta.getFileName());
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
                for (Path elemento : stream){
                    imprimirRecursivo(elemento, nivel +1);
                }
            } catch (IOException e){
                System.err.println("Error al leer: " + e.getMessage());
            }
        } else if (Files.isRegularFile(ruta)){
            System.out.println(identacion + "Fichero ---> " + ruta.getFileName());
        }
    }
}