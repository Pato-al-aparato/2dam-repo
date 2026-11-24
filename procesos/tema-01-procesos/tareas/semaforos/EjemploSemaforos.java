package tareas.semaforos;
import java.util.concurrent.Semaphore;

public class EjemploSemaforos implements Runnable {

    private static final Semaphore semaforo1 = new Semaphore(2);
    private static final Semaphore semaforo2 = new Semaphore(2);

    public void metodo1() throws InterruptedException {
        semaforo1.acquire();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " entra en el método 1");

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName()
                    + " sale del método 1");

        } finally {
            semaforo1.release();
        }
    }

    public void metodo2() throws InterruptedException {
        semaforo2.acquire();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " entra en el método 2");

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName()
                    + " sale del método 2");

        } finally {
            semaforo2.release();
        }
    }

    @Override
    public void run() {
        try {
            metodo1();
            metodo2();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        EjemploSemaforos tarea = new EjemploSemaforos();
        for (int i = 1; i <= 6; i++) {
            Thread hilo = new Thread(tarea, "Hilo " + i);
            hilo.start();
        }
    }
}

