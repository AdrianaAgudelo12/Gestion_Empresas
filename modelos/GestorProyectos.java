package modelos;

public class GestorProyectos  extends Empleado {
    private String proyecto;

    public GestorProyectos(String nombre, String documento, double sueldoBase, String proyectoAsignado) {
        super(nombre, documento, sueldoBase);
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return super.toString() + " | Rol: Gestor de Proyectos (" + proyecto + ")";
    }
}
