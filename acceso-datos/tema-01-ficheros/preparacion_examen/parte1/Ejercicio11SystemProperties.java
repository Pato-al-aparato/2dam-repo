package preparacion_examen.parte1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio11SystemProperties {
    public static void main(String[] args){
        Path raiz = Path.of(System.getProperty("user.dir"));
        Path datos = raiz.resolve("datos");
        Path copias = datos.resolve("copias");
        Path informe = copias.resolve("informe.txt");

        try {
            Files.createDirectory(datos);
            Files.createDirectory(copias);
            Files.createFile(informe);
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
