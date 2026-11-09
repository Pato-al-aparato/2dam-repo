package preparacion_examen.parte2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

// Escritura y lectura en un fichero byte a byte
public class ByteAByte {
    public static void main(String[] args){
        Path ruta = Path.of("ficheroBytes.dat");
        int j;
        try(FileOutputStream fos = new FileOutputStream(ruta.toFile())){
            for (int i = 1; i <= 100; i++){
                fos.write(i);
            }
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }


        try(FileInputStream fis = new FileInputStream(ruta.toFile())){
            // -1 indica el fin del fichero, cuando ya ha acabado de leer
            while ((j = fis.read()) != -1){
                System.out.println(j);
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
