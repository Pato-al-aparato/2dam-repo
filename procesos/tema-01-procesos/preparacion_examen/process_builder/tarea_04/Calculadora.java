package preparacion_examen.process_builder.tarea_04;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce el primer número: ");
            int num1 = sc.nextInt();

            System.out.println("Introduce el segundo número: ");
            int num2 = sc.nextInt();

            System.out.println("Introduce la operación: ");
            String operacion = sc.next();

            int resultado = 0;


            if (operacion.equals("+")){
                resultado = num1 + num2;
            } else if (operacion.equals("-")){
                resultado = num1 - num2;
            } else {
                System.out.println("Operación no valida");
                System.exit(1);
            }

            System.out.println("Resultado: " + resultado);

        } catch (Exception e){
            System.err.println("Datos no validos: " + e.getMessage());
            System.exit(1);
        }
    }
}
