package preparacion_examen.process_builder.tarea_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try {
            ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;

            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            int codigo = p.waitFor();
            System.out.println("Código de finalización: " + codigo);

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
