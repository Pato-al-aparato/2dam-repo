package preparacion_examen.process_builder.tarea_01;

import java.util.Scanner;

public class Sumador {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce el primer número: ");
            int num1 = sc.nextInt();

            System.out.println("Introduce el segundo número: ");
            int num2 = sc.nextInt();

            int resultado = num1 + num2;

            System.out.println("Resultado: " + resultado);


        } catch (Exception e){
            System.err.println("Debes introducir dos números enteros");
        }
    }
}
