package ficheros.binarios.objetos.Act6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Elige el nombre del fichero binario: ");
        String nombreFichero = sc.nextLine().trim();

        Path ruta = Path.of(System.getProperty("user.dir"), nombreFichero + ".dat");

        escribirVehiculos(ruta, sc, 2);
        leerVehiculos(ruta);

        sc.close();
    }

    private static void escribirVehiculos(Path ruta, Scanner sc, int cantidad) {
        try (DataOutputStream dos = new DataOutputStream((Files.newOutputStream(
                ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)))) {

            for (int i = 1; i <= cantidad; i++) {
                System.out.println("\n--- Datos del Vehículo " + i + " de " + cantidad + " ---");

                System.out.print("Marca: ");
                String marca = sc.nextLine().trim();

                System.out.print("Modelo: ");
                String modelo = sc.nextLine().trim();

                System.out.print("Año: ");
                int ano = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Color: ");
                String color = sc.nextLine().trim();

                System.out.print("¿Pintura metalizada? (true/false): ");
                boolean pinturaMetalizada = Boolean.parseBoolean(sc.nextLine().trim());

                Vehiculo vehiculo = new Vehiculo(marca, pinturaMetalizada, color, ano, modelo);

                dos.writeUTF(vehiculo.getMarca());
                dos.writeUTF(vehiculo.getModelo());
                dos.writeInt(vehiculo.getAno());
                dos.writeUTF(vehiculo.getColor());
                dos.writeBoolean(vehiculo.isPintura_metalizada());
            }

            System.out.println("\nSe han añadido los " + cantidad + " vehículos al fichero binario.");

        } catch (IOException e) {
            System.err.println("Error E/S durante la escritura del fichero: " + e.getMessage());
        }
    }

    private static void leerVehiculos(Path ruta) {
        if (Files.notExists(ruta)) {
            System.out.println("El fichero especificado no existe en la ruta: " + ruta.toAbsolutePath());
            return;
        }

        int registrosLeidos = 0;

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(ruta))) {

            while (true) {
                String marca = dis.readUTF();
                String modelo = dis.readUTF();
                int ano = dis.readInt();
                String color = dis.readUTF();
                boolean pinturaMetalizada = dis.readBoolean();

                registrosLeidos++;

                System.out.printf("%d) Marca: %-12s | Modelo: %-12s | Color: %-10s%n",
                        registrosLeidos, marca, modelo, color);
            }

        } catch (EOFException e) {
            System.out.println("Lectura finalizada. Total de vehículos leídos: " + registrosLeidos);
        } catch (IOException e) {
            System.err.println("Error E/S durante la lectura del fichero: " + e.getMessage());
        }
    }
}