package preparacion_examen.process_builder.tarea_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Lanzador {
    public static void main(String[] args){
        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder(
                "java"
                ,"-cp"
                ,classpath
                , Calculadora.class.getName());

        try {
            Process p = pb.start();
            OutputStream os = p.getOutputStream();
            os.write("8\n".getBytes(StandardCharsets.UTF_8));
            os.write("5\n".getBytes(StandardCharsets.UTF_8));
            os.write("-\n".getBytes(StandardCharsets.UTF_8));

            os.flush();
            os.close();


            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea2;

            while((linea = br2.readLine()) != null){
                System.err.println(linea);
            }


            int codigo = p.waitFor();
            System.out.println("Código de finalización: " + codigo);

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
