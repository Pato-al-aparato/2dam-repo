package preparacion_examen.tema2.tarea_02;

import preparacion_examen.tema2.tarea_01.HiloMensaje;

public class Main {
    public static void main(String[] args){
        Thread h1 = new Thread("Hilo1");
        Thread h2 = new Thread("Hilo2");

        h1.run();
        h2.run();
    }
}
