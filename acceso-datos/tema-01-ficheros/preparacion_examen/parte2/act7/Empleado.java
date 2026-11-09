package preparacion_examen.parte2.act7;

import java.io.Serializable;

public class Empleado implements Serializable {
    String nombre;
    int departamento;
    double salario;

    public Empleado(String nombre, int departamento, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;    }

    @Override
    public String toString() {
        return String.format("Nombre: %-10s Departamento: %-5d Salario: %-8.2f",nombre,departamento,salario);
    }
}