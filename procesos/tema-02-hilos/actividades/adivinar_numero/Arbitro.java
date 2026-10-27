package actividades.adivinar_numero;

public class Arbitro {
    private int numeroJugadores;
    private int turno;
    private int numeroAdivinar;
    private boolean juegoAcabado;

    public Arbitro(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        this.turno = 1;
        this.numeroAdivinar = 1 + (int) (10 * Math.random());
        this.juegoAcabado = false;

        System.out.println("NÚMERO A ADIVINAR: " + numeroAdivinar);
    }

    public int getTurno() {
        return turno;
    }

    public boolean isJuegoAcabado() {
        return juegoAcabado;
    }

    public synchronized void comprobarJugada(int jugador, int numero) {

        System.out.println("Jugador" + jugador + " dice: " + numero);

        if (numero == numeroAdivinar) {
            System.out.println("Jugador " + jugador + " gana, adivinó el número!");
            juegoAcabado = true;
        } else {
            turno++;

            if (turno > numeroJugadores) {
                turno = 1;
            }

            System.out.println("Le toca a Jug" + turno);
        }
    }
}
