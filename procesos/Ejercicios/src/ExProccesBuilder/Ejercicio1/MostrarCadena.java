package ExProccesBuilder.Ejercicio1;

public class MostrarCadena {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No se ha recibido ninguna cadena.");
            System.exit(1);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(args[0]);
        }
    }
}