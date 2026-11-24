package preparacion_examen.process_builder.tarea_05;

import java.io.File;
import java.nio.file.Path;

public class ListadorDirectorio {
    public static void main(String[] args){
        Path raiz = Path.of(System.getProperty("user.dir"));

        ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIRR");
        pb.directory(new File("C:\\Users\\drdy1\\Desktop\\Epsylon\\Estudios\\DAM\\2damrepo\\procesos\\tema-01-procesos"));

        try {
            pb.redirectOutput(new File(raiz.toFile(),"listado.txt"));
            pb.redirectError(new File(raiz.toFile(),"errores.txt"));

            Process p = pb.start();

            int codigo = p.waitFor();

            if (codigo == 0){
                System.out.println("El directorio se ha listado correctamente.");
            } else {
                System.out.println("Ha ocurrido un error. Consulta errores.txt.");
            }

        } catch(Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}
