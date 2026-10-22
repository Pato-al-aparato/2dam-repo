package ExProccesBuilder.Palindromo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindromo {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String cadena = br.readLine();

        if (cadena.length() == 0) {
            System.err.println("La cadena esta vacia.");
            System.exit(1);
        }

        String inversa = new StringBuilder(cadena).reverse().toString();

        if (cadena.equals(inversa)) {
            System.out.println("La cadena es palindromo.");
        } else {
            System.out.println("La cadena no es palindromo.");
        }
    }
}