import java.io.File;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        // Usando File para definir la ruta, de la forma antigua
        File ruta = new File("C:\\Users\\drdy1\\Desktop\\Epsylon\\Estudios\\Grado_Superior_DAM\\2_DAM\\AcesoADatos\\Ejercicios\\fichero1.txt");

        try {
            if(ruta.createNewFile()){
                System.out.println("Fichero creado correctamente");
            } else {
                System.out.println("El fichero ya existía");
            }
        } catch (IOException e){
            System.out.println("Error I/O " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
