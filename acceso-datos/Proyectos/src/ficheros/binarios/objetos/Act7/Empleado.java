package ficheros.binarios.objetos.Act7;

import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int departamento;
    private double salario;

    public Empleado(String nombre, int departamento, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }
}
