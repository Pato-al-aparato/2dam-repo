
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
        boolean existe = false;
        try {
            existe = Files.exists(ruta) && Files.size(ruta) > 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectOutputStream oos = existe
                ? new MiObjectOutputStream(Files.newOutputStream(
                ruta, StandardOpenOption.APPEND))
                : new ObjectOutputStream(Files.newOutputStream(
                ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND))) {

            for (int i = 1; i <= 3; i++) {
                System.out.println("\n--- Datos del Empleado " + i + " de 3 ---");

                System.out.print("Nombre: ");
                String nombre = sc.nextLine().trim();

                System.out.print("Departamento: ");
                int departamento = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Salario: ");
                double salario = Double.parseDouble(sc.nextLine().trim());

                Empleado empleado = new Empleado(nombre, departamento, salario);

                oos.writeObject(empleado);
            }

            System.out.println("\nSe han añadido los 3 empleados al fichero binario.");

        } catch (IOException e) {
            System.err.println("Error E/S durante la escritura: " + e.getMessage());
        }
    }

    private static void leerEmpleados(Path ruta) {
        if (Files.notExists(ruta)) {
            System.out.println("El fichero especificado no existe.");
            return;
        }

        int empleadosLeidos = 0;

        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(ruta))) {

            while (true) {
                Empleado empleado = (Empleado) ois.readObject();

                empleadosLeidos++;

                System.out.printf(
                        "Nombre: %-20s Depto: %4d   Salario: %.2f €%n",
                        empleado.getNombre(),
                        empleado.getDepartamento(),
                        empleado.getSalario());
            }

        } catch (EOFException e) {
            System.out.println(
                    "\nLectura finalizada. Total de empleados leídos: "
                            + empleadosLeidos);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error durante la lectura: " + e.getMessage());
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
