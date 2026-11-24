package preparacion_examen.process_builder;

import java.io.IOException;

public class Act1 {
    public static void main(String[] args){
        ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
        try {
            Process p = pb.start();

        } catch (IOException e){
            System.err.println("Error al cargar el proceso: " + e.getMessage());
        }

    }
}