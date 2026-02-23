package modelos;

public class   Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String nombre, String documento, double sueldoBase, String lenguajePrincipal) {
        super(nombre, documento, sueldoBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: Desarrollador (" + lenguajePrincipal + ")";
    }
}
