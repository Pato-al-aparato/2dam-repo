package sistema_ficheros.ejercicios;

public class Ex2 {
    private int id;
    private String name;

    public Ex2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ex2(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ex2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
