package preparacion_examen.parte2.leerEscribirObjetos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreams_v1 {
    private static final Path raiz = Path.of(System.getProperty("user.dir"));
    private static final Path RUTA_FICHERO = raiz.resolve("personas_objetos.dat");

    public static void main(String[] args){
        escribirObjetosPersona();
        leerObjetosPersona();
    }

    private static void escribirObjetosPersona() {
        List<Persona> personas = new ArrayList<>();
        personas.add( new Persona( "Ana" , 14 ));
        personas.add( new Persona( "Luis Miguel" , 15 ));
        personas.add( new Persona( "Alicia" , 13 ));
        personas.add( new Persona( "Pedro" , 15 ));
        personas.add( new Persona( "Manuel" , 16 ));
        personas.add( new Persona( "Andrés" , 12 ));
        personas.add( new Persona( "Julio" , 16 ));
        personas.add( new Persona( "Antonio" , 14 ));
        personas.add( new Persona( "María Jesús" , 13 ));

        try(OutputStream fos = Files.newOutputStream(RUTA_FICHERO);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            int contador = 1;

            for (Persona p : personas){
                oos.writeObject(p);
                System.out.println("Escribiendo datos de persona " + contador);
                contador++;
            }

            System.out.println();

        } catch (IOException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void leerObjetosPersona() {
        try(InputStream is = Files.newInputStream(RUTA_FICHERO);
            ObjectInputStream ois = new ObjectInputStream(is)){
            int contador = 1;

            while(true){
                try{
                    Persona p = (Persona) ois.readObject();
                    System.out.println("Número: " + contador + " - " + p);
                    contador++;
                } catch (EOFException eof){
                    System.out.println("Fin de lectura");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e){
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
