package preparacion_examen.process_builder.tarea_07;

public class Repetidor {
    public static void main(String[] args){
        if (args.length == 0){
            System.err.println("No se ha introducido ninguna cadena");
            System.exit(1);
        }

        String cadena = args[0];

        for (int i = 0; i < 5; i++) {
            System.out.println(cadena);
        }
    }
}
