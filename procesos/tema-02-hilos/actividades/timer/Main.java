package actividades.timer;

import java.util.Date;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {

        System.out.println("Inicio despertador");

        Timer temporizador = new Timer();
        Despertador despertador = new Despertador();

        temporizador.schedule(despertador, new Date(), 5000);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temporizador.cancel();

        System.out.println("Finalización del despertador");
    }
}
