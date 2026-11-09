package preparacion_examen.parte2.act8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act8 {
    public static void main(String[] args){
        Path raiz = Path.of(System.getProperty("user.dir"));
        Path ruta = raiz.resolve("caracteres.txt");

        escribirEnFichero(ruta);
        leerFichero(ruta);
    }

    private static void escribirEnFichero(Path ruta) {
        try(BufferedWriter bfw = Files.newBufferedWriter(ruta)){
            String texto = "Este es un método que añade contenido a un fichero de texto carácter a carácter o utilizando buffers.";
            bfw.write(texto);

        } catch (IOException e){
            System.err.println("Error al escribir en el fichero: "
                    + e.getMessage());
        }
    }

    private static void leerFichero(Path ruta) {
        try(BufferedReader bfr = Files.newBufferedReader(ruta)){
            String linea;
            String reemplazo;
            while((linea = bfr.readLine()) != null){
                System.out.println(linea.replace(" ", "").toUpperCase());
            }

        } catch (IOException e){
            System.err.println("Error al leer en el fichero: "
                    + e.getMessage());
        }
    }
}
