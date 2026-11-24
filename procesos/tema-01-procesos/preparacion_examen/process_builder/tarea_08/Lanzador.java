package preparacion_examen.process_builder.tarea_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        String classpath = System.getProperty("java.class.path");

        Path entrada = Path.of(System.getProperty("user.dir"), "entrada.txt");

        try {
            // Guardamos la cadena introducida en el fichero
            Files.writeString(entrada, cadena, StandardCharsets.UTF_8);

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    Palindromo.class.getName()
            );

            // El System.in del hijo leerá desde entrada.txt
            pb.redirectInput(ProcessBuilder.Redirect.from(entrada.toFile()));

            // El System.err del hijo se enviará a errores.txt
            pb.redirectError(ProcessBuilder.Redirect.to(new File("errores.txt")));

            Process p = pb.start();

            // Leemos el System.out del hijo
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            int codigo = p.waitFor();

            System.out.println("Código de finalización: " + codigo);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}