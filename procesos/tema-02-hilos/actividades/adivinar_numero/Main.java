package actividades.adivinar_numero;

public class Main {

    public static void main(String[] args) {

        Arbitro arbitro = new Arbitro(3);

        Jugador jugador1 = new Jugador(1, arbitro);
        Jugador jugador2 = new Jugador(2, arbitro);
        Jugador jugador3 = new Jugador(3, arbitro);

        jugador1.start();
        jugador2.start();
        jugador3.start();
    }
}
