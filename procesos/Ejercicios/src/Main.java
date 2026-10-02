public class Main {
    public static void main(String[] args) {
        HiloSimple hs = new HiloSimple();
        hs.start();

        for (int i = 0; i < 25; i++)
            System.out.println("En el programa padre");
    }
}
