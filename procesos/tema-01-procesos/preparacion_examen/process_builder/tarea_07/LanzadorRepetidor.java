package preparacion_examen.process_builder.tarea_07;
import java.io.File;

import java.util.Scanner;

public class LanzadorRepetidor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                classpath,
                Repetidor.class.getName(),
                cadena
        );

        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("salida.txt")));


        try {
            Process p = pb.start();

            int codigo = p.waitFor();

            if (codigo == 0) {
                System.out.println("Proceso terminado correctamente.");
            } else {
                System.out.println("El proceso terminó con código: " + codigo);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}