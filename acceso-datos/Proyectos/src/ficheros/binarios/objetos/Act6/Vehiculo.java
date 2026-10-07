package ficheros.binarios.objetos.Act6;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String color;
    private boolean pintura_metalizada;

    public Vehiculo(String marca, boolean pintura_metalizada, String color, int ano, String modelo) {
        this.marca = marca;
        this.pintura_metalizada = pintura_metalizada;
        this.color = color;
        this.ano = ano;
        this.modelo = modelo;
    }

    public boolean isPintura_metalizada() {
        return pintura_metalizada;
    }

    public void setPintura_metalizada(boolean pintura_metalizada) {
        this.pintura_metalizada = pintura_metalizada;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("Marca %-10s Modelo %-10s color %-10s",marca, modelo, color);
    }
}