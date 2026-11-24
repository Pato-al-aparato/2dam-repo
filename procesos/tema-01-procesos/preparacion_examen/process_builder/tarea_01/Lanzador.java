package preparacion_examen.process_builder.tarea_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Lanzador {
    public static void main(String[] args){
        String classpath = System.getProperty("java.class.path");

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java"
                    ,"-cp"
                    ,classpath
                    ,Sumador.class.getName());

            Process p = pb.start();
            OutputStream os = p.getOutputStream();

            os.write("5\n".getBytes(StandardCharsets.UTF_8));
            os.write("7\n".getBytes(StandardCharsets.UTF_8));

            os.flush();
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),StandardCharsets.UTF_8));
            String linea;

            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }


            // Leer los errores que pueda tener el proceso hijo
            BufferedReader errores = new BufferedReader(
                    new InputStreamReader(p.getErrorStream())
            );

            String error;

            while ((error = errores.readLine()) != null) {
                System.err.println(error);
            }

            int codigo = p.waitFor();
            System.out.println("Código de finalización: " + codigo);


        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
