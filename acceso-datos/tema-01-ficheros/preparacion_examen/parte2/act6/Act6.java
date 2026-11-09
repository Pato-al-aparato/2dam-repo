package preparacion_examen.parte2.act6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Act6 {
    private static final Path raiz = Path.of(System.getProperty("user.dir"));

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero: ");
        Path ruta = raiz.resolve(sc.nextLine());

        escribirVehiculos(ruta,sc);
        leerVehiculos(ruta);
    }

    private static void escribirVehiculos(Path ruta,Scanner sc) {
        try(OutputStream fos = Files.newOutputStream(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
            DataOutputStream dos = new DataOutputStream(fos)){
            for (int i = 1; i < 3; i++) {

                System.out.println("Datos del vehículo " + i);
                System.out.print("Marca: ");
                String marca = sc.nextLine();

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();

                System.out.print("Año: ");
                int ano = sc.nextInt();
                sc.nextLine();

                System.out.print("Color: ");
                String color = sc.nextLine();

                System.out.print("Pintura metalizada (true/false): ");
                boolean pintura_metalizada = sc.nextBoolean();
                sc.nextLine();

                System.out.print("\n");
                dos.writeUTF(marca);
                dos.writeUTF(modelo);
                dos.writeInt(ano);
                dos.writeUTF(color);
                dos.writeBoolean(pintura_metalizada);
            }

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void leerVehiculos(Path ruta) {
        try(InputStream is = Files.newInputStream(ruta);
            DataInputStream dis = new DataInputStream(is)){
            while(true){
                try {
                    String marca = dis.readUTF();
                    String modelo = dis.readUTF();
                    int ano = dis.readInt();
                    String color = dis.readUTF();
                    boolean pintura_metalizada = dis.readBoolean();
                    System.out.printf("Marca: %-10s Modelo: %-6s Color: %-8s", marca,modelo,color);
                    System.out.print("\n");

                } catch (EOFException eof){
                    System.out.println("Fin de lectura");
                    break;
                }
            }

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
