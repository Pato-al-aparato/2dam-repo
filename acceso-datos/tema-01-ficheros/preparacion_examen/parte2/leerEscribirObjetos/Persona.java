package preparacion_examen.parte2.leerEscribirObjetos;

import java.io.Serializable;

public class Persona implements Serializable {
    String nombre;
    int edad;

    Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-16s Edad: %d", nombre, edad);
    }
}
