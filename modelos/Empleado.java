package modelos;

public abstract class Empleado {
    protected String cedula;
    protected String nombre;
    protected double sueldoHora;
    protected Empresa empresa;

    public Empleado(String cedula, String nombre, double sueldoHora, Empresa empresa) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.empresa = empresa;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getSueldoHora() { return sueldoHora; }
    public void setSueldoHora(double sueldoHora) { this.sueldoHora = sueldoHora; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }

    public abstract double calcularSalario(int horasTrabajadas);

    @Override
    public String toString() {
        return "Empleado [cedula=" + cedula + ", nombre=" + nombre + ", sueldoHora=" + sueldoHora + ", empresa=" + (empresa != null ? empresa.getNombre() : "Ninguna") + "]";
    }
}
