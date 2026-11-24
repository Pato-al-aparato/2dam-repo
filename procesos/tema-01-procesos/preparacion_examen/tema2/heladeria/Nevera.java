package preparacion_examen.tema2.heladeria;

import java.util.Stack;

/** Recurso compartido por todos los heladeros y niños. */
public class Nevera {
    private static final int CAPACIDAD_MAXIMA = 25;
    private final Stack<Helado> helados;

    public Nevera() {
        helados = new Stack<>();
    }

    /**
     * synchronized: un solo hilo a la vez puede ejecutar métodos sincronizados
     * sobre ESTA misma nevera. La comprobación y la inserción son indivisibles
     * respecto a otros métodos sincronizados del mismo objeto.
     * @return true si se guardó el helado; false si la nevera está llena.
     */
    public synchronized boolean guardarHelado(Helado helado, String nombreHeladero) {
        if (helados.size() < CAPACIDAD_MAXIMA) {
            helados.push(helado);
            System.out.println("Soy el heladero: " + nombreHeladero
                    + " y he metido el helado " + helado + ". Hay " + helados.size() + " helados.");
            return true;
        }

        System.out.println("Nevera llena, el heladero " + nombreHeladero + " tiene que esperar.");
        return false;
    }

    /** Devuelve un helado o null si la nevera está vacía. */
    public synchronized Helado retirarHelado(String nombreNino) {
        if (!helados.isEmpty()) {
            Helado helado = helados.pop(); // Stack: último en entrar, primero en salir (LIFO).
            System.out.println("Soy el niño: " + nombreNino + " y he sacado el helado "
                    + helado + ". Quedan " + helados.size() + " helados.");
            return helado;
        }

        System.out.println("Nevera vacía, no hay helados para el niño " + nombreNino);
        return null;
    }

    @Override
    public String toString() {
        return "Nevera{}";
    }
}
