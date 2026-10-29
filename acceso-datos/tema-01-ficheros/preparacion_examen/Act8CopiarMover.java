package preparacion_examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Act8CopiarMover {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Path raiz = Path.of("operaciones");
        Path carpetaOrigen = raiz.resolve("origen");
        Path ficheroOrigen = carpetaOrigen.resolve("datos.txt");
        Path carpetaDestino = raiz.resolve("destino");

        try {
            Files.createDirectory(raiz);
            Files.createDirectory(carpetaOrigen);
            Files.createFile(ficheroOrigen);
            Files.createDirectory(carpetaDestino);

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }

        //copiarFichero(ficheroOrigen,carpetaDestino,sc);
        moverFichero(ficheroOrigen,carpetaDestino);
    }

    private static void moverFichero(Path ficheroOrigen, Path carpetaDestino, Scanner sc) {
        try {
            Files.move(ficheroOrigen,carpetaDestino);
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void moverFichero(Path ficheroOrigen, Path carpetaDestino) {
        Path ficheroDestino = carpetaDestino.resolve(ficheroOrigen.getFileName());

        try {
            Files.move(ficheroOrigen, ficheroDestino);
            System.out.println("Fichero movido correctamente a: " + ficheroDestino);
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
