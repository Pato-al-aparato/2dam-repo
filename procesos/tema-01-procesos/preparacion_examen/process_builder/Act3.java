package preparacion_examen.process_builder;

import java.io.IOException;
public class Act3 {
    public static void main(String[] args){
        ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
        try {
            Process p = pb.start();

            int codigo = p.waitFor();
            System.out.println("NotePad se ha cerrado");
            System.out.println("Código: " + codigo);


        } catch (IOException e){
            System.err.println("Error al cargar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
