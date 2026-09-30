package Actividades;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Act3 {
    public static void main(String[] args) {
        Path ruta = Path.of(System.getProperty("user.dir"));

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
            for (Path lista : stream ){
                if (Files.isRegularFile(lista)){
                    System.out.println("Fichero ---> " + lista.getFileName());
                }
                if(Files.isDirectory(lista)){
                    System.out.println("Directorio ---> " + lista.getFileName());
                }
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}


