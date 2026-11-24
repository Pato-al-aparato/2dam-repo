package preparacion_examen.tema2.heladeria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Hilo productor: fabrica helados e intenta guardarlos en la nevera compartida. */
public class Heladero extends Thread {
    private String nombre;
    public static int numHeladosPorHacer; // Campo original; no participa en run().
    private Nevera nevera;

    public Heladero(String nombre, Nevera nevera) {
        this.nombre = nombre;
        this.nevera = nevera;
    }

    public Heladero() { }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public static int getNumHeladosPorHacer() { return numHeladosPorHacer; }
    public static void setNumHeladosPorHacer(int cantidad) { numHeladosPorHacer = cantidad; }

    @Override
    public void run() {
        Random random = new Random();
        int heladosPendientes = random.nextInt(5); // Entre 0 y 4, ambos incluidos.
        System.out.println("Soy el heladero " + nombre
                + " y voy a crear estos helados: " + heladosPendientes);

        // Se conserva el do-while original: se fabrica al menos un helado,
        // incluso si heladosPendientes empieza en cero.
        do {
            boolean heladoGuardado = false;
            Helado helado = new Helado();

            // Si la nevera está llena, se reintenta guardar EL MISMO helado.
            while (!heladoGuardado) {
                try {
                    heladoGuardado = nevera.guardarHelado(helado, nombre);

                    if (heladoGuardado) {
                        heladosPendientes--;
                        // Simula una pausa de 1 a menos de 5 segundos.
                        Thread.sleep((long) (Math.random() * 4000 + 1000));
                    } else {
                        // Reintento: sleep NO libera un monitor que el hilo posea.
                        // Aquí ya terminó guardarHelado(), así que su monitor está libre.
                        Thread.sleep((long) (Math.random() * 500));
                    }
                } catch (InterruptedException e) {
                    // Se conserva la política original: registrar y seguir.
                    Logger.getLogger(Heladero.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } while (heladosPendientes > 0);

        System.out.println("Soy el heladero: " + nombre
                + " y ya acabé el trabajo. Me voy al bar.");
    }

    @Override
    public String toString() { return "Heladero{nombre=" + nombre + '}'; }
}
