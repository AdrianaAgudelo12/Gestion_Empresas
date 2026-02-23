package operaciones;

import java.util.ArrayList;
import modelos.Empleado;

public class OperacionEmpleado implements IOperacionEmpleado {

private ArrayList<Empleado> listaEmpleados;

public OperacionEmpleado() {
    this.listaEmpleados = new ArrayList<>();
}

@Override
public void agregarEmpleado(Empleado emp) {
    listaEmpleados.add(emp);
    System.out.println("Empleado agregado exitosamente.");
}

@Override
public void listarTodos() {
    if (listaEmpleados.isEmpty()) {
        System.out.println("No hay empleados registrados.");
    } else {
        for (Empleado e : listaEmpleados) {
            System.out.println(e.toString());
        }
    }
}

@Override
public Empleado consultarPorDoc(String doc) {
    for (Empleado e : listaEmpleados) {
        if (e.getDocumento().equals(doc)) {
            return e;
        }
    }
    return null;
}

@Override
public double calcularSueldo(Empleado emp) {
    
    return emp.getSueldoBase();
    }

}