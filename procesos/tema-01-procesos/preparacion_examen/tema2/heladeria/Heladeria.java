package preparacion_examen.tema2.heladeria;

/** Punto de entrada: crea un recurso compartido y los hilos que lo utilizan. */
public class Heladeria {
    public static void main(String[] args) {
        // IMPORTANTE: se crea una sola nevera para TODOS los hilos.
        Nevera neveraCompartida = new Nevera();

        for (int i = 0; i < 5; i++) {
            Heladero heladero = new Heladero(String.valueOf(i), neveraCompartida);
            // Se conserva el patrón original del profesor: Thread recibe otro Thread
            // como Runnable. Es válido, aunque heladero.start() bastaría.
            Thread hiloHeladero = new Thread(heladero);
            hiloHeladero.start(); // start() crea ejecución concurrente; run() no.
        }

        for (int i = 0; i < 10; i++) {
            Nino nino = new Nino(String.valueOf(i), neveraCompartida);
            Thread hiloNino = new Thread(nino);

            hiloNino.start();
        }

        // main termina sin esperar a los demás; los hilos iniciados siguen vivos.
        System.out.println("Soy el hilo principal y me mori -.-");
    }
}
