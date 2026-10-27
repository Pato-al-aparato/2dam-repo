package ficheros.acceso_aleatorio.act11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class Act11 {
    private static final int BYTES_INT = 4;
    private static final Path RUTA = Path.of("fichero.dat");

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            // a) Crear el fichero y dejarlo vacío
            raf.setLength(0);

            // b) Mostrar el tamaño inicial
            System.out.println("La longitud actual del fichero es " + raf.length());

            // c) Escribir los números del 0 al 199
            System.out.println("Escribimos los números del 0 al 199 en el fichero...");

            for (int i = 0; i < 200; i++) {
                raf.writeInt(i);
            }

            // d) Mostrar de nuevo el tamaño
            System.out.println("La longitud actual del fichero es " + raf.length());

            // e) Mostrar el primer número
            raf.seek(0);
            System.out.println("El primer número es: " + raf.readInt());

            // f) Mostrar el segundo número
            raf.seek(BYTES_INT);
            System.out.println("El segundo número es: " + raf.readInt());

            // g) Mostrar el décimo número
            raf.seek((long) (10 - 1) * BYTES_INT);
            System.out.println("El décimo número es: " + raf.readInt());

            // h) Modificar el undécimo número por 555
            System.out.println("Modificamos el undécimo valor (lo cambiamos por 555)...");

            raf.seek((long) (11 - 1) * BYTES_INT);
            raf.writeInt(555);

            // i) Añadir 999 al final del fichero
            System.out.println("Añadimos 999 al final del fichero...");

            raf.seek(raf.length());
            raf.writeInt(999);

            // j) Mostrar de nuevo el tamaño
            System.out.println("La nueva longitud del fichero es: " + raf.length());

            // k) Mostrar el undécimo número
            raf.seek((long) (11 - 1) * BYTES_INT);
            System.out.println("El undécimo número es: " + raf.readInt());

            // l) Mostrar el contenido completo del fichero
            System.out.println("------------ CONTENIDO FICHERO ------------");

            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                System.out.println("Número " + raf.readInt());
            }

            System.out.println("---------------- FIN FICHERO ----------------");

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }
}