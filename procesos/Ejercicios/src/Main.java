public class Main {
    public static void main(String[] args) {
        HiloSimple hs = new HiloSimple();
        hs.start();

        /*
        Thread t = new Thread(hs);

         */
        HiloSimple2 hs2 = new HiloSimple2(15);
        hs2.start();



        for (int i = 0; i < 25; i++)
            System.out.println("En el programa padre");
    }
}
//