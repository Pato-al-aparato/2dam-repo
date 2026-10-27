package ficheros.acceso_aleatorio.act12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.Scanner;

public class Act12 {
    private static final int BYTES_FLOAT = 4;
    private static final Path RUTA = Path.of("fichero.dat");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Crear el fichero si no existe
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }

        do {
            System.out.println("\n---------- MENÚ ----------");
            System.out.println("1. Añadir número");
            System.out.println("2. Buscar y sustituir número");
            System.out.println("3. Sustituir número por posición");
            System.out.println("4. Mostrar fichero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    anadirNumero(sc);
                    break;

                case 2:
                    buscarYSustituir(sc);
                    break;

                case 3:
                    sustituirPosicion(sc);
                    break;

                case 4:
                    mostrarFichero();
                    break;

                case 5:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 5);

        sc.close();
    }


    // 1. Añadir número de tipo float al final
    private static void anadirNumero(Scanner sc) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            System.out.print("Introduce el número: ");
            float numero = sc.nextFloat();

            raf.seek(raf.length());
            raf.writeFloat(numero);

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }


    // 2. Buscar un número y sustituir la primera aparición
    private static void buscarYSustituir(Scanner sc) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            System.out.print("Introduce el número que quieres buscar: ");
            float numeroBuscar = sc.nextFloat();

            System.out.print("Introduce el nuevo número: ");
            float numeroNuevo = sc.nextFloat();

            boolean encontrado = false;

            raf.seek(0);

            while (raf.getFilePointer() < raf.length() && !encontrado) {
                long posicion = raf.getFilePointer();

                float numero = raf.readFloat();

                if (numero == numeroBuscar) {

                    raf.seek(posicion);
                    raf.writeFloat(numeroNuevo);

                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("Número sustituido correctamente.");
            } else {
                System.out.println("El número no se encuentra en el fichero.");
            }

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }


    // 3. Sustituir el número de una posición concreta
    private static void sustituirPosicion(Scanner sc) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            System.out.print("Introduce la posición: ");
            int posicionUsuario = sc.nextInt();

            long numeroElementos = raf.length() / BYTES_FLOAT;

            if (posicionUsuario >= 1 && posicionUsuario <= numeroElementos) {

                System.out.print("Introduce el nuevo número: ");
                float numeroNuevo = sc.nextFloat();

                long posicion = (long) (posicionUsuario - 1) * BYTES_FLOAT;

                raf.seek(posicion);
                raf.writeFloat(numeroNuevo);

                System.out.println("Número sustituido correctamente.");

            } else {
                System.out.println("La posición indicada no existe.");
            }

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }


    // 4. Mostrar el contenido completo
    private static void mostrarFichero() {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")) {
            raf.seek(0);

            int posicion = 1;

            System.out.println("\n----- CONTENIDO DEL FICHERO -----");

            while (raf.getFilePointer() < raf.length()) {
                float numero = raf.readFloat();

                System.out.println("Posición " + posicion + ": " + numero);

                posicion++;
            }

        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }
}
