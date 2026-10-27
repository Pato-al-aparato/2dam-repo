package actividades.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class Despertador extends TimerTask {

    @Override
    public void run() {
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");

        System.out.println("Despierta! ya son las " + formato.format(calendario.getTime()));
    }
}