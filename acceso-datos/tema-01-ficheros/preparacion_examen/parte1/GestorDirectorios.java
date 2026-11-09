package preparacion_examen.parte1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GestorDirectorios {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----------------------------------------");
            System.out.println("Opciones del gestor de directorios");
            System.out.println("1. Mostrar contenido de un directorio");
            System.out.println("2. Buscar ficheros por extensión");
            System.out.println("3. Copiar un fichero");
            System.out.println("4. Mover un fichero");
            System.out.println("5. Mostrar información de un fichero");
            System.out.println("6. Borrar directorio de forma recursiva");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarContenidoDirectorio(sc);
                    break;

                case 2:
                    busquedaPorExtension(sc);
                    break;

                case 3:
                    copiarFichero(sc);
                    break;

                case 4:
                    moverFichero(sc);
                    break;

                case 5:
                    informacionFichero(sc);
                    break;

                case 6:
                    borradoRecursivo(sc);
                    break;

                case 7:
                    System.out.println("Cerrando...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);

        sc.close();
    }


    // 1. Mostrar contenido de un directorio
    private static void mostrarContenidoDirectorio(Scanner sc) {
        System.out.print("Introduce la ruta del directorio donde quieras buscar: ");
        Path ruta = Path.of(sc.nextLine());

        mostrarContenidoDirectorio(ruta);
    }

    private static void mostrarContenidoDirectorio(Path ruta){
        if (Files.exists(ruta)){
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
                for (Path elemento : stream){
                    if (Files.isRegularFile(elemento)){
                        System.out.println("Fichero --> " + elemento.getFileName());
                    }

                    if (Files.isDirectory(elemento)){
                        System.out.println("Directorio --> " + elemento.getFileName());
                        mostrarContenidoDirectorio(elemento);
                    }
                }

            } catch (IOException e){
                System.err.println("Error de E/S: " + e.getMessage());
            }
        } else {
            System.out.println("El directorio no exite");
        }
    }


    // 2. Buscar ficheros por extensión

    private static void busquedaPorExtension(Scanner sc) {
        System.out.print("Introduce la ruta del directorio donde quieras buscar: ");
        Path ruta = Path.of(sc.nextLine());

        String extension = ".";
        System.out.print("Introduce la extension: ");
        extension += sc.nextLine();

        busquedaPorExtension(ruta, extension);
    }

    private static void busquedaPorExtension(Path ruta, String extension) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
            for (Path elemento : stream){
                if (Files.isRegularFile(elemento) && elemento.getFileName().toString().endsWith(extension)){
                    System.out.println(elemento.getFileName());
                }

                if (Files.isDirectory(elemento)){
                    busquedaPorExtension(elemento,extension);
                }
            }

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }


    // 3. Copiar un fichero
    private static void copiarFichero(Scanner sc) {
        System.out.print("Ruta del origen: ");
        Path rutaOrigen = Path.of(sc.nextLine());

        System.out.print("Ruta del destino: ");
        Path carpetaDestino = Path.of(sc.nextLine());

        Path rutaDestino = carpetaDestino.resolve(rutaOrigen.getFileName());

        copiarFichero(rutaOrigen,rutaDestino);

    }

    private static void copiarFichero(Path rutaOrigen, Path rutaDestino) {
        try {
            Files.copy(rutaOrigen,rutaDestino);
            System.out.println("Fichero copiado con exito");
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    // 4. Mover un fichero
    private static void moverFichero(Scanner sc) {
        System.out.print("Introduce la ruta origen:  ");
        Path rutaOrigen = Path.of(sc.nextLine());

        System.out.print("Introduce la ruta destino:  ");
        Path carpetaDestino = Path.of(sc.nextLine());

        Path rutaDestino = carpetaDestino.resolve(rutaOrigen.getFileName());

        try {
            Files.move(rutaOrigen,rutaDestino);
        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    // 5. Mostrar información de un fichero
    private static void informacionFichero(Scanner sc) {
        System.out.print("Introduce la ruta del fichero: ");
        Path ruta = Path.of(sc.nextLine());

        try {
            if (Files.exists(ruta) && Files.isRegularFile(ruta)){
                System.out.println("Información del fichero");
                System.out.println("Nombre: " + ruta.getFileName());
                System.out.println("Tamaño: " + Files.size(ruta));
                System.out.println("Ruta completa: " + ruta.toAbsolutePath());
            } else {
                System.out.println("La ruta no existe o no pertenece a un fichero");
            }

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    // 6. Borrar directorio de forma recursiva
    private static void borradoRecursivo(Scanner sc) {
        System.out.print("Introduce la ruta de donde quieras hacer el borrado: ");
        Path ruta = Path.of(sc.nextLine());

        borradoRecursivo(ruta);
    }

    private static void borradoRecursivo(Path ruta) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
            for (Path elemento : stream){
                if (Files.isDirectory(elemento)){
                    borradoRecursivo(elemento);
                }

                if (Files.isRegularFile(elemento)){
                    Files.deleteIfExists(elemento);
                }
            }
            Files.deleteIfExists(ruta);

            System.out.println("Borrado recursivo completado");

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}