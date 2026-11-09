package preparacion_examen.parte2.act7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Act7 {
    private static final Path raiz = Path.of(System.getProperty("user.dir"));
    private static final Path ruta = raiz.resolve("empleados.dat");
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        escribirEmpleados(ruta,sc);
        leerEmpleados(ruta,sc);
    }

    static void escribirEmpleados(Path ruta,Scanner sc){
        try(OutputStream os = Files.newOutputStream(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
            ObjectOutputStream oos = Files.exists(ruta) && Files.size(ruta) > 0
                    ? new MiObjectOutputStream(os) :
                    new ObjectOutputStream(os)){
            for (int i = 1; i <=2; i++) {
                System.out.println("Datos empleado " + i);
                System.out.print("Introduce el nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Departamento: ");
                int departamento = sc.nextInt();

                System.out.print("Salario: ");
                double salario = sc.nextDouble();
                sc.nextLine();

                Empleado emp = new Empleado(nombre,departamento,salario);

                oos.writeObject(emp);
            }

        } catch(IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    static void leerEmpleados(Path ruta,Scanner sc){
        try(InputStream is = Files.newInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(is)){
            while(true){
                try{
                    Empleado emp = (Empleado) ois.readObject();
                    System.out.println(emp);

                } catch(EOFException eof){
                    System.out.println("Fin de la lectura");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e){
            System.err.println("Error al leer los empleados: " + e.getMessage());
        }
    }
}
