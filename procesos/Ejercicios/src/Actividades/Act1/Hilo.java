package Actividades.Act1;

public class Hilo extends Thread {

    @Override
    public void run() {
        System.out.println("Hola mundo desde el hilo " + getId());
    }
}