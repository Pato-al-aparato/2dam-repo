package sistema_ficheros.ejercicios;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex3 {
    public static void main(String[] args) {
        Path ruta = Path.of("C:\\Users\\drdy1\\Desktop\\Epsylon\\Estudios\\Grado_Superior_DAM\\2_DAM\\AccesoADatos\\Ejercicios\\fichero.txt");
        //Path ruta = Path.of("fichero2.txt"); <--- Toma como raíz la carpeta actual
        // Path ruta = Path.get(""); <--- Java 8 y versiones anteriores

        try {
            Files.createFile(ruta);
            System.out.println("Fichero creado");

        } catch (FileAlreadyExistsException e){
            System.out.println("El fichero ya existe " + e.getMessage());

        } catch (IOException e){
            System.out.println("No se ha podido crear el fichero" + e);
        }

        try {
            System.out.println("Tamaño del fichero " + Files.size(ruta) + " bytes");
            // Si el fichero está vacío mostrará 0 bytes
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}