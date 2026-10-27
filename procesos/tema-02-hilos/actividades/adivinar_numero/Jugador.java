package actividades.adivinar_numero;

public class Jugador extends Thread {

    private int idJugador;
    private Arbitro arbitro;

    public Jugador(int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {

        while (!arbitro.isJuegoAcabado()) {

            if (arbitro.getTurno() == idJugador) {

                int numero = 1 + (int) (10 * Math.random());

                arbitro.comprobarJugada(idJugador, numero);
            }
        }
    }
}
