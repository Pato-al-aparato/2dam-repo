package actividades.act_01;

public class Hilo extends Thread {

    @Override
    public void run() {
        System.out.println("Hola mundo desde el hilo " + getId());
    }
}