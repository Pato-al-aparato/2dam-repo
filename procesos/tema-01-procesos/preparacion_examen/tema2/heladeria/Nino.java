package preparacion_examen.tema2.heladeria;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Hilo consumidor: intenta retirar helados de la nevera compartida. */
public class Nino extends Thread {
    private String nombre;
    private Nevera nevera;

    public Nino(String nombre, Nevera nevera) {
        this.nombre = nombre;
        this.nevera = nevera;
    }

    public Nino() { }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public void run() {
        long esperaAcumulada = 0;

        // El niño se marcha cuando acumula al menos 10 segundos
        // de esperas debidas a encontrar la nevera vacía.
        while (esperaAcumulada < 10_000) {
            try {
                Helado helado = nevera.retirarHelado(nombre);

                if (helado == null) {
                    // Nevera vacía: espera hasta menos de 5 segundos y reintenta.
                    long esperaActual = (long) (Math.random() * 5000);
                    Thread.sleep(esperaActual);
                    esperaAcumulada += esperaActual;
                } else {
                    // Ha conseguido un helado: reinicia el contador de espera.
                    esperaAcumulada = 0;
                    // Simula que se come el helado durante 1 a menos de 5 segundos.
                    Thread.sleep((long) (Math.random() * 4000 + 1000));
                }
            } catch (InterruptedException e) {
                // Se conserva la política original: registrar y seguir.
                Logger.getLogger(Nino.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        System.out.println("Niño " + nombre
                + " se cansa de esperar y se va al Burguer King a por un McFlurry.");
    }

    @Override
    public String toString() { return "Nino{nombre=" + nombre + '}'; }
}
