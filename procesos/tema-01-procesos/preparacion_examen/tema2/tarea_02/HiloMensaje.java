package preparacion_examen.tema2.tarea_02;

public class HiloMensaje implements Runnable {
    String nombre;

    public HiloMensaje(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Soy " + Thread.currentThread().getName() + " -- iteración " + (i+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " ha sido interrumpido");
            }
        }
    }
}

