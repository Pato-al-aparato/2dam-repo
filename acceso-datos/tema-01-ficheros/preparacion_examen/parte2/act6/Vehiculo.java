package preparacion_examen.parte2.act6;

public class Vehiculo {
    String marca;
    String modelo;
    int ano;
    String color;
    boolean pintura_metalizada;

    public Vehiculo(String marca,String modelo, int ano, String color, boolean pintura_metalizada) {
        this.marca = marca;
        this.pintura_metalizada = pintura_metalizada;
        this.color = color;
        this.ano = ano;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("Marca: %-15s Modelo: %-10s Color: %-10s", marca,modelo,color);
    }
}
