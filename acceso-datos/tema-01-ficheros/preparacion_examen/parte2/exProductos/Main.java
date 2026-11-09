package preparacion_examen.parte2.exProductos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Path raiz = Path.of(System.getProperty("user.dir"));
        System.out.print("Introduce el nombre del fichero: ");
        Path ruta = raiz.resolve(sc.nextLine());

        escribirProductos(ruta,sc);
        leerProductos(ruta);
    }

    private static void escribirProductos(Path ruta, Scanner sc) {
        try(OutputStream os = Files.newOutputStream(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
            DataOutputStream dos = new DataOutputStream(os)){
            for (int i = 1; i <=3 ; i++) {
                System.out.print("Nombre del producto: ");
                String nombre = sc.nextLine();

                System.out.print("Precio: ");
                double precio = sc.nextDouble();

                System.out.print("Stock: ");
                int stock = sc.nextInt();
                sc.nextLine();

                System.out.print("Oferta: ");
                boolean oferta = sc.nextBoolean();
                sc.nextLine();

                dos.writeUTF(nombre);
                dos.writeDouble(precio);
                dos.writeInt(stock);
                dos.writeBoolean(oferta);
            }

        } catch (IOException e){
            System.err.println("Error al escribir los productos: "
                    + e.getMessage());
        }
    }

    private static void leerProductos(Path ruta) {
        try(InputStream is = Files.newInputStream(ruta);
            DataInputStream dis = new DataInputStream(is)){

            while (true){
                try{
                    String nombre = dis.readUTF();
                    double precio = dis.readDouble();
                    int stock = dis.readInt();
                    boolean oferta = dis.readBoolean();
                    System.out.printf("Nombre: %-10s Precio: %-5.2f Stock: %-5d"
                            ,nombre
                            ,precio
                            ,stock);
                    System.out.println();
                } catch (EOFException eof){
                    System.out.println("Fin de la lectura");
                    break;
                }
            }


        } catch (IOException e){
            System.err.println("Error al leer los productos: "
                    + e.getMessage());
        }
    }
}
