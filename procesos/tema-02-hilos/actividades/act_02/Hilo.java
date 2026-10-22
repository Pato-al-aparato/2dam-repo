package actividades.act_02;

public class Hilo implements Runnable {
    private String texto;

    public Hilo(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {

        long id = Thread.currentThread().getId();

        try {
            Thread.sleep(id * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo " + texto + " - Hilo: " + id);
    }
}
