package preparacion_examen.tema2.heladeria;

/** Representa un helado: es un dato que producen y consumen los hilos. */
public class Helado {
    private String sabor;
    private double precio;

    private enum Sabor { Naranja, Limon, Almendra, Nata, Fresa, Chocolate, Oreo }

    public Helado(String sabor, double precio) {
        this.sabor = sabor;
        this.precio = precio;
    }

    public Helado() {
        // Se conserva el cálculo original: redondea a euros enteros.
        precio = Math.round(Math.random() * 2.55 + 0.45);
        // El código original selecciona únicamente los tres primeros sabores.
        sabor = Sabor.values()[(int) (Math.random() * 3)].toString();
    }

    public String getSabor() { return sabor; }
    public void setSabor(String sabor) { this.sabor = sabor; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "{sabor=" + sabor + ", precio=" + precio + '}';
    }
}
