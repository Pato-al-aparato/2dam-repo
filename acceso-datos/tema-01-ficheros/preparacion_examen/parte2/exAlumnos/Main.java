package preparacion_examen.parte2.exAlumnos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Path raiz = Path.of(System.getProperty("user.dir"));
        Path ruta = raiz.resolve("alumnos.dat");

        escribirAlumnos(ruta,sc);
        leerAlumnos(ruta);
    }

    private static void escribirAlumnos(Path ruta, Scanner sc) {
        try(OutputStream os = Files.newOutputStream(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
            ObjectOutputStream oos = Files.exists(ruta) && Files.size(ruta) > 0 ?
                    new MiObjectOutputStream(os) :
                    new ObjectOutputStream(os)){
            for (int i = 1; i <=3 ; i++) {
                System.out.print("Nombre del alumno: ");
                String nombre = sc.nextLine();

                System.out.print("Curso: ");
                String curso = sc.nextLine();

                System.out.print("Nota media: ");
                double notaMedia = sc.nextDouble();

                System.out.print("Repetidor: ");
                boolean repetidor = sc.nextBoolean();
                sc.nextLine();

                Alumno a = new Alumno(nombre,curso,notaMedia,repetidor);

                oos.writeObject(a);
            }

        } catch (IOException e){
            System.err.println("Error al escribir los alumnos: "
                    + e.getMessage());
        }
    }

    private static void leerAlumnos(Path ruta) {
        try(InputStream is = Files.newInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(is)){

            while (true){
                try{
                    Alumno a = (Alumno) ois.readObject();
                    System.out.println(a);
                } catch (EOFException eof){
                    System.out.println("Fin de lectura");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e){
            System.err.println("Error al leer los alumnos: "
                    + e.getMessage());
        }
    }
}
