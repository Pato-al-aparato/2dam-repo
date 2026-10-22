package ficheros.caracteres.ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DemoTextoClaseFiles {
    private static final Path ruta = Path.of("fichero.txt");

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,3,4,5);
        List<String> lineas = new ArrayList<>();

        for (int numero : numeros){
            lineas.add("Fila número " + numero);
        }

        escribirFiles(lineas);
        leerFiles();
    }

    private static void escribirFiles(List<String> lineas) {
        try {
            Files.write(ruta,lineas);
            System.out.println("Hemos escrito en el fichero");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

    private static void leerFiles() {
        try {
            List<String> contenido = Files.readAllLines(ruta);
            for (String linea : contenido){
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
}
