package tareas.executor_service;

import java.util.concurrent.*;

public class Executor {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            Callable<Double> proveedor1 = () -> {
                Thread.sleep(3000);
                return 100.0;
            };

            Callable<Double> proveedor2 = () -> {
                Thread.sleep(3000);
                return 95.0;
            };

            Callable<Double> proveedor3 = () -> {
                Thread.sleep(3000);
                return 110.0;
            };

            Callable<Double> proveedor4 = () -> {
                Thread.sleep(3000);
                return 90.0;
            };

            Callable<Double> proveedor5 = () -> {
                Thread.sleep(3000);
                return 105.0;
            };

            Future<Double> futuro1 = executor.submit(proveedor1);
            Future<Double> futuro2 = executor.submit(proveedor2);
            Future<Double> futuro3 = executor.submit(proveedor3);
            Future<Double> futuro4 = executor.submit(proveedor4);
            Future<Double> futuro5 = executor.submit(proveedor5);

            System.out.println("Consultando precios...");

            double precio1 = futuro1.get();
            double precio2 = futuro2.get();
            double precio3 = futuro3.get();
            double precio4 = futuro4.get();
            double precio5 = futuro5.get();

            System.out.println("Proveedor 1: " + precio1 + " €");
            System.out.println("Proveedor 2: " + precio2 + " €");
            System.out.println("Proveedor 3: " + precio3 + " €");
            System.out.println("Proveedor 4: " + precio4 + " €");
            System.out.println("Proveedor 5: " + precio5 + " €");

        } finally {
            executor.shutdown();
        }
    }
}

