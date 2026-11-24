package preparacion_examen.process_builder;

public class PruebaWaitFor {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "timeout /t 30");
        Process p = pb.start();

        System.out.println("Proceso iniciado");

        p.waitFor();

        System.out.println("Proceso terminado");
    }
}
