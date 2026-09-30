package Actividades;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act4 {
    public static void main(String[] args) {
        Path ruta = Path.of(System.getProperty("user.dir"));

        imprimirRecursivo(ruta);
    }

    public static void imprimirRecursivo(Path ruta){
        try {
            if (Files.isDirectory(ruta)) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
                    for (Path lista : stream) {
                        imprimirRecursivo(lista);

                        if (Files.isRegularFile(lista)){
                            System.out.println("Fichero ---> " + lista.getFileName());
                        }
                        if(Files.isDirectory(lista)){
                            System.out.println("Directorio ---> " + lista.getFileName());
                        }
                    }
                }
            }
            System.out.println("Eliminado con éxito: " + ruta.toAbsolutePath());

        } catch (IOException e){
            System.out.println("No se pudo eliminar " + ruta.getFileName());
        }
    }
}
