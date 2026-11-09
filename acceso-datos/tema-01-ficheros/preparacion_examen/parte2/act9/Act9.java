package preparacion_examen.parte2.act9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Act9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Path raiz = Path.of(System.getProperty("user.dir"));
        Path ruta = raiz.resolve("deportistas.txt");

        escribirDeportistas(ruta,sc);
        leerDeportistas(ruta);
    }

    private static void escribirDeportistas(Path ruta,Scanner sc) {
        System.out.print("Introduce el número de deportistas: ");
        int numDeportistas = sc.nextInt();
        sc.nextLine();

        try(BufferedWriter bfw = Files.newBufferedWriter(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)){
            for (int i = 1; i <=numDeportistas ; i++) {
                System.out.println("Datos del atleta " + i);
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Edad: ");
                int edad = sc.nextInt();

                System.out.print("Altura: ");
                double altura = sc.nextDouble();
                sc.nextLine();

                String linea = nombre + " " + edad + " " + altura;

                bfw.write(linea);
                bfw.newLine();
            }

        } catch (IOException e){
            System.err.println("Error al escribir los deportistas");
        }
    }

    private static void leerDeportistas(Path ruta) {
        try(BufferedReader bfr = Files.newBufferedReader(ruta)){
            String linea;
            while ((linea = bfr.readLine()) != null){
                System.out.printf(linea);
                System.out.println();
            }
        } catch (IOException e){
            System.err.println("Error al escribir los deportistas");
        }
    }
}
