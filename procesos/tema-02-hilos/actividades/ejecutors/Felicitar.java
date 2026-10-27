package actividades.ejecutors;

public class Felicitar implements Runnable {
    private String nombre;

    public Felicitar(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Feliz cumpleaños " + nombre);
    }
}