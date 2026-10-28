package ficheros.sistema_ficheros.ejemplos;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CrearCarpeta {
    public static void main(String[] args) {
        Path carpeta = Path.of("carpeta");
        try {
            Files.createDirectory(carpeta);
            System.out.println("Carpeta creada correctamente");

        } catch (FileAlreadyExistsException e){
            System.out.println("La carpeta ya existe " + e.getMessage());
        } catch (IOException e){
            System.out.println("La carpeta no se ha podido crear " + e.getMessage());
        }
    }
}