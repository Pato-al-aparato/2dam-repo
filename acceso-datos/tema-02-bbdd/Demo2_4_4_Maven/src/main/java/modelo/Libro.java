package modelo;

public class Libro {
    private final String isbn;
    private final String titulo;
    private final String anio;

    public Libro(String anio, String isbn, String titulo) {
        this.anio = anio;
        this.isbn = isbn;
        this.titulo = titulo;
    }
}
