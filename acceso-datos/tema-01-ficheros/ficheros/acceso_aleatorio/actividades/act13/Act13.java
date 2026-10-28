package ficheros.acceso_aleatorio.actividades.act13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.Random;

public class Act13 {
    private static final int BYTES_INT = 4;
    private static final int BYTES_DOUBLE = 8;

    private static final int TAMANO_REGISTRO =
            BYTES_INT + BYTES_DOUBLE;

    private static final int NUM_PRODUCTOS = 25;
    private static final Path RUTA =
            Path.of("productos.dat");

    public static void main(String[] args) {
        // 1. Crear y rellenar el fichero
        rellenarFichero();

        // 2. Mostrar el fichero
        System.out.println("----- FICHERO ORIGINAL -----");
        mostrarFichero();

        // 3. Modificar los precios
        modificarPrecios();

        // 4. Mostrar de nuevo
        System.out.println("\n----- FICHERO MODIFICADO -----");
        mostrarFichero();
    }

    // 1. Rellenar el fichero con 25 productos
    private static void rellenarFichero() {
        Random random = new Random();

        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {
            raf.setLength(0);

            for (int i = 0; i < NUM_PRODUCTOS; i++) {
                int referencia = i + 1;

                double precio = 1 + random.nextDouble() * 199;

                raf.writeInt(referencia);
                raf.writeDouble(precio);
            }

        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    // 2 y 4. Mostrar el contenido completo
    private static void mostrarFichero() {

        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")) {
            while (raf.getFilePointer() < raf.length()) {
                int referencia = raf.readInt();
                double precio = raf.readDouble();

                System.out.printf("Referencia: %-3d Precio: %.2f €%n", referencia, precio
                );
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }


    // 3. Modificar todos los precios
    private static void modificarPrecios() {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            for (long posicion = 0;
                 posicion < raf.length();
                 posicion += TAMANO_REGISTRO) {

                // Nos colocamos al inicio del registro
                raf.seek(posicion);

                // Leer referencia
                int referencia = raf.readInt();

                // Leer precio
                double precio = raf.readDouble();

                // Modificar precio
                if (precio > 100) {
                    precio = precio * 0.90;
                } else {
                    precio = precio * 1.10;
                }

                raf.seek(posicion + BYTES_INT);
                raf.writeDouble(precio);
            }

        } catch (IOException e) {
            System.err.println("Error al modificar el fichero: " + e.getMessage());
        }
    }
}
