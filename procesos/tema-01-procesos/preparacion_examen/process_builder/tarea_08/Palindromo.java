package preparacion_examen.process_builder.tarea_08;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadena = sc.nextLine().toLowerCase();

        if (cadena.length() == 0) {
            System.err.println("La cadena está vacía.");
            System.exit(1);
        }

        String invertida = new StringBuilder(cadena)
                .reverse()
                .toString();

        if (cadena.equals(invertida)) {
            System.out.println("La cadena es palíndroma.");
        } else {
            System.out.println("La cadena no es palíndroma.");
        }
    }
}
