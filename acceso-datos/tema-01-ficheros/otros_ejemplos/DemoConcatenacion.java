package otros_ejemplos;

public class DemoConcatenacion {
    public static void main(String[] args) {
        // StringBuffer
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Me encanta");

        for (int i = 0; i < 100000; i++) {
            sb.append(" el módulo de Acceso a Datos");
        }

        System.out.println("Tiempo empleado por StringBuffered: "
                + (System.currentTimeMillis() - startTime) + " ms");

        // StringBuilder
        StringBuilder sb2 = new StringBuilder("Me encanta");
        for (int i = 0; i < 100000; i++) {
            sb2.append(" el módulo de Acceso a Datos");
        }

        System.out.println("Tiempo empleado por StringBuilder: "
                + (System.currentTimeMillis() - startTime) + " ms");

        // String normal
        String cadena = "Me encanta";
        for (int i = 0; i < 100000; i++) {
            cadena += " el módulo de Acceso a Datos";
        }

        System.out.println("Tiempo empleado por StringBuffered: "
                + (System.currentTimeMillis() - startTime) + " ms");

    }
}
