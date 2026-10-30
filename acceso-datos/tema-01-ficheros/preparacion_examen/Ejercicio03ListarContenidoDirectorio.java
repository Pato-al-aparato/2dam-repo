package preparacion_examen;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/* Implementación de metodos que comprueban si una ruta pertenece a un fichero o a una carpeta*/

public class Ejercicio03ListarContenidoDirectorio {
    public static void main (String[] args){
        try {
            Path ruta1 = Path.of("practica");
            Path ruta2 = ruta1.resolve("tema1");
            Path ruta3 = ruta1.resolve("tema2");
            Path ruta4 = ruta1.resolve("notas.txt");
            Path ruta5 = ruta1.resolve("resumen.txt");

            Files.createDirectory(ruta1);
            Files.createDirectory(ruta2);
            Files.createDirectory(ruta3);
            Files.createFile(ruta4);
            Files.createFile(ruta5);
            /*
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta1)){
                for (Path elemento : stream){
                    if (Files.isDirectory(elemento)){
                        System.out.println("Direcorio --> " + elemento.getFileName());
                    } else {
                        System.out.println("Fichero --> " + elemento.getFileName());
                    }
                }
            }*/

            //Usando también isRegularFile
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta1)){
                for (Path elemento : stream){
                    if (Files.isDirectory(elemento)){
                        System.out.println("Direcorio --> " + elemento.getFileName());
                    }

                    if (Files.isRegularFile(elemento)){
                        System.out.println("Fichero --> " + elemento.getFileName());
                    }
                }
            }

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
