package operaciones;
import modelos.Empleado;

public interface IOperacionEmpleado {
    void agregarEmpleado(Empleado emp);
    void listarTodos();
    Empleado consultarPorDoc(String doc);
    double calcularSueldo(Empleado emp);
}
