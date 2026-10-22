package ficheros.acceso_aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class accesoAleatorio {
    private static final int LONG_APELLIDO = 20; // 20 caracteres
    private static final int BYTES_INT = 4;
    private static final int BYTES_DOUBLE = 8;
    private static final int BYTES_CHAR = 2;
    private static final int TAMANO_REGISTRO = BYTES_INT + (LONG_APELLIDO * BYTES_CHAR) + BYTES_INT + BYTES_DOUBLE; // Cada registro ocupa 56 bytes
    private static final Path RUTA = Path.of("ficheros_prueba", "fichero_aleatorio_v2.dat");

    public static void main(String[] args) {
        try {
            if (RUTA.getParent() != null) {
                Files.createDirectories(RUTA.getParent());
            }

            String[] apellidos = {"FERNÁNDEZ", "GIL", "LÓPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
            int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
            double[] salarios = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

            // 1) Escribir los registros en el fichero
            try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {
                // Sobreescribimos
                raf.setLength(0);

                for (int i = 0; i < apellidos.length; i++) {
                    escribirRegistros(raf, i, i + 1, apellidos[i], departamentos[i], salarios[i]
                    );
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 1) Escribir los registros en el fichero
        //escribirRegistros();

        // 2) Modificar el departamento del tercer empleado
        //modificarDepartamento(3);

        // 3) Sumar los salarios de todos los empleados
        //sumarSalarios();

        //4) Leer y mostrar por consola los datos del 5º empleado
        //mostrarEmpleado(5);

        // 5) Actualizar el salario del 3º registro y mostrarlo
        //actualizarSalario(3);

        // 6) Mostrar todos los registros
        //leerRegsitros();
    }


    // 1) Escribir los registros en el fichero
    private static void escribirRegistros(RandomAccessFile raf, int indice, int id, String apellido, int departamento, double salario) throws IOException {
        long posicion = (long) indice * TAMANO_REGISTRO;
        raf.seek(posicion);

        raf.writeInt(id);
        escribirCadenaFija(raf, apellido, LONG_APELLIDO);
        raf.writeInt(departamento);
        raf.writeDouble(salario);
    }


    // 2) Modificar el departamento del tercer empleado
    private static void modificarDepartamento(int numEmpleado) {
        try (Scanner sc = new Scanner(System.in);
             RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            System.out.print("Introduce el nuevo departamento: ");
            int nuevoDept = sc.nextInt();

            // Colocar el puntero
            long posicion = (long) (numEmpleado - 1) * TAMANO_REGISTRO + (BYTES_INT + LONG_APELLIDO * BYTES_CHAR);

            raf.seek(posicion);
            // Escribir
            raf.writeInt(nuevoDept);

        } catch (IOException e) {
            System.err.println("Error de I/O al modificar el departamento");
        }
    }

    // 3-v1) Sumar los salarios de todos los empleados
    /*
    private static void sumarSalarios() {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")){
            double sumaSalarios = 0.0;

            for (int i = 1; i < 8; i++) {
                long posicion = (long) (i*TAMANO_REGISTRO) - BYTES_DOUBLE;
                raf.seek(posicion);
                sumaSalarios += raf.readDouble();
            }

            System.out.println("Suma de los salarios: " + sumaSalarios);

        } catch(IOException e){
            System.err.println("Error de I/O al modificar el departamento");
        }
    }*/

    // 3-v2) Sumar los salarios de todos los empleados
    private static void sumarSalarios() {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")) {
            double sumaSalarios = 0.0;

            for (long pos = (TAMANO_REGISTRO - BYTES_DOUBLE); pos < raf.length(); pos += TAMANO_REGISTRO) {

                raf.seek(pos);
                sumaSalarios += raf.readDouble();
            }

            System.out.println("Suma de los salarios: " + sumaSalarios);

        } catch (IOException e) {
            System.err.println("Error de I/O al modificar el departamento");
        }
    }


    // 4) Leer y mostrar por consola los datos del 5º empleado
    private static void mostrarEmpleado(int numEmpleado) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")) {
            raf.seek((long) (numEmpleado - 1) * TAMANO_REGISTRO);

            System.out.printf("ID: %-4d Apellido: %-10s Departamento: %-3d Salario: %-12.2f%n"
                    , raf.readInt(), leerCadenaFija(raf, LONG_APELLIDO), raf.readInt(), raf.readDouble());

        } catch (IOException e) {
            System.err.println("Error de I/O al modificar el departamento");
        }
    }

    // 5) Actualizar el salario del 3º registro y mostrarlo
    private static void actualizarSalario(int numEmpleado) {
        try (Scanner sc = new Scanner(System.in);
             RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "rw")) {

            // Colocar el puntero
            long posicion = (long) (numEmpleado - 1) * TAMANO_REGISTRO + (BYTES_INT + LONG_APELLIDO * BYTES_CHAR) + BYTES_INT;
            raf.seek(posicion);
            double salarioActual = raf.readDouble();

            raf.seek(posicion);
            System.out.print("Introduce el nuevo salario: ");
            double nuevoSalario = sc.nextDouble();
            raf.writeDouble(nuevoSalario);

            System.out.print("Salario nuevo: " + nuevoSalario + " ---> Salario antiguo: " + salarioActual);

        } catch (IOException e) {
            System.err.println("Error de I/O al modificar el departamento");
        }
    }

    // 6) Mostrar todos los registros
    private static void leerRegsitros() {
        int id, departamento;
        String apellido;
        double salario;

        try (RandomAccessFile raf = new RandomAccessFile(RUTA.toFile(), "r")) {
            long posicion = raf.getFilePointer(); // 0
            //raf.seek(0);

            while (posicion != raf.length()) {
                id = raf.readInt();
                apellido = leerCadenaFija(raf, LONG_APELLIDO);
                departamento = raf.readInt();
                salario = raf.readDouble();

                System.out.printf("ID: %-4d Apellido: %-20s Departamento: %-3d Salario: %-12.2f%n"
                        , id, apellido, departamento, salario);

                posicion = raf.getFilePointer();
            }

        } catch (IOException e) {
            System.err.println("Error de I/O en leerRegistros" + e.getMessage());
        }

    }

    private static String leerCadenaFija(RandomAccessFile raf, int longApellido) throws IOException {
        char[] chars = new char[longApellido];
        for (int i = 0; i < longApellido; i++) {
            chars[i] = raf.readChar();
        }

        return new String(chars).trim();
    }


    private static void escribirCadenaFija(RandomAccessFile raf, String apellido, int longApellido) throws IOException {
        if (apellido == null) {
            apellido = "";
        }

        StringBuilder sb = new StringBuilder(apellido);

        // Apellido tiene más de 20 caracteres
        if (sb.length() > longApellido) {
            sb.setLength(longApellido);
        } else {
            while (sb.length() < longApellido) {
                sb.append(' ');
            }
        }

        for (int i = 0; i < longApellido; i++) {
            raf.writeChar(sb.charAt(i));
        }
    }
}