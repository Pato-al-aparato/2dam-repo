package tareas.exchanger;

import java.util.concurrent.Exchanger;

public class TareaIntercambio implements Runnable {
    private final int id;
    private final Exchanger<String> exchanger;

    public TareaIntercambio(int id, Exchanger<String> exchanger) {
        this.id = id;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String mensaje = "Mensaje enviado por el hilo " + id;

            String mensajeRecibido = exchanger.exchange(mensaje);

            System.out.println("Hilo " + id + " ha recibido: "
                    + mensajeRecibido);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo " + id + " interrumpido.");
        }
    }
}

