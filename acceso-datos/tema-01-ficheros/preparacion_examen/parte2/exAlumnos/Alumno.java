package preparacion_examen.parte2.exAlumnos;

import java.io.Serializable;

public class Alumno implements Serializable {
    String nombre;
    String curso;
    double notaMedia;
    boolean repetidor;

    public Alumno(String nombre, String curso, double notaMedia, boolean repetidor) {
        this.nombre = nombre;
        this.curso = curso;
        this.notaMedia = notaMedia;
        this.repetidor = repetidor;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-10s Curso: %-5s Nota media: %-5.2f Repetidor %b"
                ,nombre
                ,curso
                ,notaMedia
                ,repetidor);
    }
}
