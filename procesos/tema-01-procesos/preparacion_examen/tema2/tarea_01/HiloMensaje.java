package preparacion_examen.tema2.tarea_01;

public class HiloMensaje  extends Thread {

    public HiloMensaje(String nombre){
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Soy " + getName() + " -- iteración " + (i+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " ha sido interrumpido");
            }
        }
    }
}
