package tareas.exchanger;

import java.util.concurrent.Exchanger;

public class Intercambio {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        for (int i = 1; i <= 6; i++) {
            Thread hilo = new Thread(
                    new TareaIntercambio(i, exchanger)
            );

            hilo.start();
        }
    }
}