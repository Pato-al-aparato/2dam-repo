public class HiloSimple2 extends Thread {
    private int x;

    public HiloSimple2(int x) {
        this.x = x;
    }

    public void run(){
        for (int i = 0; i < x; i++){
            System.out.println("Dentro del hilo");
        }
    }
}
//