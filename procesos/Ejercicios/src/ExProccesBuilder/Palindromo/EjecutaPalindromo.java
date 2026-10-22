package ExProccesBuilder.Palindromo;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class EjecutaPalindromo {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"),
                Palindromo.class.getName()
        );

        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write((cadena + "\n").getBytes());
        os.flush();
        os.close();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream())
        );

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        p.waitFor();
    }
}
