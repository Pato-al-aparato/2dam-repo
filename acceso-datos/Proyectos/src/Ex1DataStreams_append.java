import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ex1DataStreams_append {
    public static void main(String[] args) {
        Path ruta = Path.of("personas.dat");

        String[] nombres = {"Dragos","Ana","Pepe","Jose"};
        int[] edades = {21,34,18,40};

        escribirPersona(ruta,nombres,edades);
        leerPersonas(ruta);

    }

    private static void leerPersonas(Path ruta) {
        try (InputStream os = Files.newInputStream(ruta); DataInputStream dis = new DataInputStream(os)){
            System.out.println("Leyendo datos desde: " + ruta.toAbsolutePath());
            while (true){
                try {
                    String nombre = dis.readUTF();
                    int edad = dis.readInt();
                    System.out.printf("Nombre: %-10s Edad: %d%n", nombre, edad);
                } catch (EOFException e){
                    break;
                }
            }

        } catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void escribirPersona(Path ruta, String[] nombres, int[] edades) {
        try (OutputStream os = Files.newOutputStream(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
                );
                DataOutputStream dos = new DataOutputStream(os)){
            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i]);
                dos.writeInt(edades[i]);
            }

            System.out.println("Datos escritos correctamente en: " + ruta.toAbsolutePath());
        } catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
