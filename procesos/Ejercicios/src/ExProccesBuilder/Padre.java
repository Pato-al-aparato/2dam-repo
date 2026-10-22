package ExProccesBuilder;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Padre {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"),
                MostrarCadena.class.getName(), cadena
        );

        pb.redirectErrorStream(true);
        Process p = pb.start();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream())
        );

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        p.waitFor();
    }
}