package preparacion_examen.parte2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

// Escitura y lectura de un fichero byte a byte usando a forma moderna
public class ByteAByte_v2 {
    public static void main(String[] args){
        Path ruta = Path.of("ficheroBytes.dat");
        int j;

        try(OutputStream os = Files.newOutputStream(ruta)){
            for (int i = 0; i <= 100; i++) {
                os.write(i);
            }
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }

        try(InputStream is = Files.newInputStream(ruta)){
            while (( j = is.read()) != -1){
                System.out.println(j);
            }
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}