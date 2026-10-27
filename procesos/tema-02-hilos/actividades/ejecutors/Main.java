package actividades.ejecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Felicitar felicitar = new Felicitar("David");

        ScheduledExecutorService programador =
                Executors.newScheduledThreadPool(1);

        programador.scheduleAtFixedRate(
                felicitar,
                0,
                365,
                TimeUnit.DAYS
        );
    }
}