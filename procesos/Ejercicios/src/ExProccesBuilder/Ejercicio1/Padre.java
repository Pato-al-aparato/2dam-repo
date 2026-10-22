package ExProccesBuilder.Ejercicio1;

import java.util.Scanner;
import java.io.File;

public class Padre {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"),
                MostrarCadena.class.getName(), cadena
        );

        File fichero = new File("cadena.txt");
        pb.redirectOutput(fichero);

        Process p = pb.start();

        p.waitFor();
    }
}