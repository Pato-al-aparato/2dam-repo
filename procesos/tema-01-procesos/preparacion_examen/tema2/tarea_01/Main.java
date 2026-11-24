package preparacion_examen.tema2.tarea_01;

public class Main {
    public static void main(String[] args){
        HiloMensaje h1 = new HiloMensaje("Hilo1");
        HiloMensaje h2 = new HiloMensaje("Hilo2");

        h1.start();
        h2.start();
    }
}
