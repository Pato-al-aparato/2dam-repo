package preparacion_examen;

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

            switch (opcion) {
                case 1:
                    mostrarContenidoDirectorio(sc);
                    break;

                case 2:
                    // código opción 2
                    break;

                case 3:
                    // código opción 3
                    break;

                case 0:
                    // salir
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);
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
                        System.out.println(elemento.getFileName());
                    }

                    if (Files.isDirectory(elemento)){
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


    // Buscar ficheros por extensión
}
