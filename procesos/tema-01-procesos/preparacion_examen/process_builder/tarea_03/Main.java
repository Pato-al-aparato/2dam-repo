package preparacion_examen.process_builder.tarea_03;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args){
        Path raiz = Path.of(System.getProperty("user.dir"));

        ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
        pb.directory(new File("C:\\Users\\drdy1\\Desktop\\Epsylon\\Estudios\\DAM\\2damrepo\\procesos\\tema-01-procesos"));

        pb.redirectOutput(new File(raiz.toFile(),"salida.txt"));
        pb.redirectError(new File(raiz.toFile(),"errores.txt"));

        try {
            Process p = pb.start();

            int código = p.waitFor();

            System.out.println("Proceso terminado con código: " + código);


        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
