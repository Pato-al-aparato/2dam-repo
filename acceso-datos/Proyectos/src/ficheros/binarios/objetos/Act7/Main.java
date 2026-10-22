
package ficheros.binarios.objetos.Act7;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path ruta = Path.of(System.getProperty("user.dir"), "empleados.dat");

        escribirEmpleados(ruta, sc);
        leerEmpleados(ruta);

        sc.close();
    }

    private static void escribirEmpleados(Path ruta, Scanner sc) {
        try {
            boolean existe = Files.exists(ruta) && Files.size(ruta) > 0;

            ObjectOutputStream oos;

            if (existe) {
                oos = new MiObjectOutputStream(
                        Files.newOutputStream(ruta, StandardOpenOption.APPEND));
            } else {
                oos = new ObjectOutputStream(
                        Files.newOutputStream(ruta, StandardOpenOption.CREATE,
                                StandardOpenOption.APPEND));
            }

            try (oos) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("\nEmpleado " + i);

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Departamento: ");
                    int departamento = Integer.parseInt(sc.nextLine());

                    System.out.print("Salario: ");
                    double salario = Double.parseDouble(sc.nextLine());

                    oos.writeObject(new Empleado(nombre, departamento, salario));
                }
            }

            System.out.println("Empleados guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    private static void leerEmpleados(Path ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(ruta))) {

            while (true) {
                Empleado empleado = (Empleado) ois.readObject();

                System.out.printf(
                        "Nombre: %-20s Depto: %4d Salario: %.2f €%n",
                        empleado.getNombre(),
                        empleado.getDepartamento(),
                        empleado.getSalario());
            }

        } catch (EOFException e) {
            System.out.println("Fin de la lectura.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    private static class MiObjectOutputStream extends ObjectOutputStream {

        public MiObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}