package ExProccesBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Padre1 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"),
                SumaNumeros.class.getName()
        );

        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write("5\n3\n".getBytes());
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
