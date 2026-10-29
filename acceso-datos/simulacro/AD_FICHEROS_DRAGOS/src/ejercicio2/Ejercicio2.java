package ejercicio2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio2 {
    private static final Path precios = Path.of("D:\\Users\\Alumno Tarde\\Desktop\\2dam-repo\\acceso-datos\\simulacro\\AD_FICHEROS_DRAGOS\\src\\ficheros\\precios.dat");
    public static void main(String[] args){
        try {
            Files.createFile(precios);

            System.out.println("Tamaño de " + precios.getFileName()
                    + ": " + Files.size(precios) + " bytes");

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }

        escribirFichero(precios);
    }

    private static void escribirFichero(Path precios) {
        try(FileInputStream flujo = new FileInputStream(precios.toFile())){
            double subida = 0.50;
            for (int i = 1; i <= 50; i++) {

            }
        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
