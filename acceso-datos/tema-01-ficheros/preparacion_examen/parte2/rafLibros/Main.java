package preparacion_examen.parte2.rafLibros;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final int BYTES_INT = 4;
    private static final int LONG_TITULO = 25;
    private static final int BYTES_DOUBLE = 8;
    private static final int BYTES_CHAR = 2;
    private static final int TAM_REGISTRO = BYTES_INT + (LONG_TITULO * BYTES_CHAR) + BYTES_INT + BYTES_DOUBLE;

    private static final int OFFSET_ANO = BYTES_INT + (LONG_TITULO*BYTES_CHAR);
    private static Path raiz = Path.of(System.getProperty("user.dir"));
    private static Path ruta = raiz.resolve("libros.dat");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] titulos = {"Dune", "1984", "El Hobbit", "Fundación", "Dracula"};
        int[] anos = {1965, 1949, 1937, 1951, 1897};
        double[] precios = {19.95, 12.50, 17.80, 14.90, 11.75};

        if (Files.notExists(ruta)) {
            escribirLibros(ruta, titulos, anos, precios);
        }

        //leerLibros(ruta, sc);
        //modificarAno(ruta, sc);
        leerTodosLosLibros(ruta);
    }

    private static void modificarAno(Path ruta, Scanner sc) {
        System.out.print("Introduce el libro que quieras modificar: ");
        int registro = sc.nextInt();

        System.out.print("Introduce el año nuevo: ");
        int anoNuevo = sc.nextInt();


        try(RandomAccessFile raf = new RandomAccessFile(ruta.toFile(),"rw")){
            long inicioRegistro = (long) (registro - 1) * TAM_REGISTRO; // 66 bytes + 54 = 2º fila - año
            long posicion = inicioRegistro + OFFSET_ANO;
            raf.seek(posicion);
            int anoAnterior = raf.readInt();

            raf.seek(posicion);

            raf.writeInt(anoNuevo);

            System.out.printf("Año modificado: %d --> %d%n",
                    anoAnterior,
                    anoNuevo);

        } catch (IOException e){
            System.err.println("Error al modificar el año: " + e.getMessage());
        }
    }

    private static void escribirLibros(Path ruta, String[] titulos, int[] anos, double[] precios) {
        try (RandomAccessFile raf = new RandomAccessFile(ruta.toFile(), "rw")) {
            raf.setLength(0);

            for (int i = 0; i < titulos.length; i++) {
                raf.writeInt(i + 1);
                escribirCadenaFija(raf, titulos[i], LONG_TITULO);
                raf.writeInt(anos[i]);
                raf.writeDouble(precios[i]);
            }

        } catch (IOException e) {
            System.err.println("Error al escribir los libros: " + e.getMessage());
        }
    }

    private static void escribirCadenaFija(RandomAccessFile raf, String texto, int longitud) throws IOException {
        StringBuilder sb = new StringBuilder(texto);

        if (sb.length() > longitud) {
            sb.setLength(longitud);
        } else {
            while (sb.length() < longitud) {
                sb.append(' ');
            }
        }

        for (int i = 0; i < longitud; i++) {
            raf.writeChar(sb.charAt(i));
        }
    }

    private static void leerLibros(Path ruta, Scanner sc) {
        System.out.print("Intoduce el registro que quieras leer: ");
        int registro = sc.nextInt();

        try (RandomAccessFile raf = new RandomAccessFile(ruta.toFile(), "r")) {
            long posicion = (long) (registro - 1) * TAM_REGISTRO;
            raf.seek(posicion);

            int id = raf.readInt();
            String titulo = leerCadenaFija(raf, LONG_TITULO);
            int ano = raf.readInt();
            double precio = raf.readDouble();

            System.out.printf("ID: %d Título: %-25s Año: %d Precio: %.2f%n",
                    id,
                    titulo,
                    ano,
                    precio);


        } catch (IOException e) {
            System.err.println("Error al leer los libros: " + e.getMessage());
        }
    }

    private static void leerTodosLosLibros(Path ruta) {

        try (RandomAccessFile raf = new RandomAccessFile(ruta.toFile(), "r")) {

            raf.seek(0);

            long posicion = raf.getFilePointer();

            while (posicion != raf.length()) {

                int id = raf.readInt();
                String titulo = leerCadenaFija(raf, LONG_TITULO);
                int ano = raf.readInt();
                double precio = raf.readDouble();

                System.out.printf(
                        "ID: %d Título: %-25s Año: %d Precio: %.2f%n",
                        id,
                        titulo,
                        ano,
                        precio
                );

                posicion = raf.getFilePointer();
            }

        } catch (IOException e) {
            System.err.println("Error al leer los libros: " + e.getMessage());
        }
    }







    private static String leerCadenaFija(RandomAccessFile raf, int longitud) throws IOException {
        char[] caracteres = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            caracteres[i] = raf.readChar();
        }
        return new String(caracteres).trim();
    }


}