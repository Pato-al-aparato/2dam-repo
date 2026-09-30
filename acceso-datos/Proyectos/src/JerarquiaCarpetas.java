import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JerarquiaCarpetas {
    public static void main(String[] args) {
        Path ruta = Path.of("Carpeta1/Carpeta2/Carpeta3");

        try {
            Files.createDirectories(ruta);
            System.out.println("Carpetas creadas correctamente");

        } catch (IOException e){
            System.out.println();
        }
    }
}
