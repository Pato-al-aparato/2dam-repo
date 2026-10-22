package ficheros.binarios.objetos.ExObjectStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex2ObjectStreams {

    public static void main(String[] args) {
        Path ruta = Path.of("objetos.dat");

        Persona[] listaPersonas = {
                new Persona("Pepe", 40),
                new Persona("Lola", 23),
                new Persona("Raul", 19),
                new Persona("María", 36)
        };

        escribirObjetos(ruta, listaPersonas);
        leerObjetos(ruta);
    }

    private static void escribirObjetos(Path ruta, Persona[] personas) {

        try (OutputStream os = Files.newOutputStream(ruta);
             DataOutputStream dos = new DataOutputStream(os)) {

            for (Persona p : personas) {
                dos.writeUTF(p.getNombre());
                dos.writeInt(p.getEdad());
            }

            System.out.println("Datos escritos correctamente en: " + ruta.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error en la escritura: " + e.getMessage());
        }
    }

    private static void leerObjetos(Path ruta) {
        try (InputStream is = Files.newInputStream(ruta);
             DataInputStream dis = new DataInputStream(is)) {

            System.out.println("Leyendo datos desde: " + ruta.toAbsolutePath());

            while (true) {
                try {
                    String nombre = dis.readUTF();
                    int edad = dis.readInt();
                    System.out.printf("Nombre: %-10s Edad: %d%n", nombre, edad);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error en la lectura: " + e.getMessage());
        }
    }
}
