package preparacion_examen.process_builder.tarea_06;

import java.util.Scanner;

public class LanzadorRepetidor {
    public static void main(String[] args){
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

        try {
            pb.inheritIO();

            Process p = pb.start();

            int codigo = p.waitFor();

            System.out.println("Código de finalización: " + codigo);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


    }
}
