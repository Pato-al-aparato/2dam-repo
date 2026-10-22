public class HiloSimple extends Thread {
    public void run(){
        for (int i = 0; i < 25; i++){
            System.out.println("Dentro del hilo");
        }
    }
}
//