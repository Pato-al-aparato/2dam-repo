package ficheros.caracteres;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoTextoPathBuffered {
    private static final Path ruta = Path.of("fichero.txt");

    public static void main(String[] args) {
        escribirBuffered();
        leerBuffered();
    }

    private static void escribirBuffered() {

        //try (BufferedWriter bfw = new BufferedWriter(new FileWriter(ruta))) {

        try (BufferedWriter bfw = Files.newBufferedWriter(ruta)) {
            for (int i = 1; i <= 10; i++) {
                bfw.write("Fila número: " + i + "\n");
                // Metodo newLine() que imprime un salto de línea
                //bfw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

    private static void leerBuffered() {
        //try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
}
