package preparacion_examen.parte2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerEscribirTiposPrimitivos {
    public static void main(String[] args){
        Path ruta = Path.of("personas.dat");

        String[] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés"};
        int[] edades = {14,15,13,15,16,12};

        escribirPersonas(ruta,nombres,edades);
        leerPersonas(ruta);

    }

    private static void leerPersonas(Path ruta) {
        try(InputStream is = Files.newInputStream(ruta);
            DataInputStream dis = new DataInputStream(is)){

            while (true){
                try {
                    String nombre = dis.readUTF();
                    int edad = dis.readInt();

                    System.out.printf("Nombre: %-15s Edad: %d%n", nombre, edad);

                } catch (EOFException eof){
                    break;
                }
            }

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void escribirPersonas(Path ruta, String[] nombres, int[] edades) {
        try(OutputStream fos = Files.newOutputStream(ruta);
            DataOutputStream dos = new DataOutputStream(fos)){

            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i]);
                dos.writeInt(edades[i]);
            }

            System.out.println("Datos escritos correctamente en: " + ruta.toAbsolutePath());

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
