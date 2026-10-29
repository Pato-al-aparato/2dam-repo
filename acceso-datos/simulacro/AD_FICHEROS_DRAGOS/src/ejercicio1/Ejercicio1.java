package ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    public static void main(String[] args){
        String texto = "Los PRODUCTOS de la TIENDA incluyen " +
                "ORDENADORES, TECLADOS y RATONES de alta CALIDAD";

        Path carpetaFicheros = Path.of("src/ficheros");
        //Mirar al final
        //Path carpetaFicheros = Path.of(System.getProperty("user.dir") + "src/ficheros");
        Path productos = carpetaFicheros.resolve("productos.txt");

        try {
            Files.createDirectory(carpetaFicheros);
            Files.createFile(productos);

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }

        escribirFichero(productos,texto);
        leerFichero(productos);
    }

    private static void leerFichero(Path productos) {
        try(BufferedReader bfr = new BufferedReader(new FileReader(productos.toFile()))){
            String linea;
            while((linea = bfr.readLine()) != null){
                System.out.println(linea.toLowerCase());
            }
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void escribirFichero(Path productos, String texto) {
        try(BufferedWriter btw = new BufferedWriter(new FileWriter(productos.toFile()))){
            btw.write(texto);
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
