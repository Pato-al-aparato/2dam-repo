package ficheros.caracteres.ejemplos;

import java.io.*;

public class DemoTextoBuffered {
    private static final String ruta = "fichero.txt";

    public static void main(String[] args) {
        escribirBuffered();
        leerBuffered();
    }

    private static void escribirBuffered() {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(ruta))) {
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
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
}
