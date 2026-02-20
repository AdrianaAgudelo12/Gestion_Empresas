package principal;

import modelos.*;
import operaciones.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IOperacionEmpresa opEmpresas = new OperacionEmpresa();
        IOperacionEmpleado opEmpleados = new OperacionEmpleado();

        int opcion = 0;

        do {
            System.out.println("\n--- GESTIÓN DE EMPRESAS Y EMPLEADOS ---");
            System.out.println("1. Agregar Empresa de Desarrollo");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Buscar Empresa");
            System.out.println("4. Agregar Empleado (Desarrollador / Admin / Gestor de Proyectos)");
            System.out.println("5. Listar Empleados");
            System.out.println("6. Buscar Empleado");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese NIT de la Empresa: ");
                    String nit = scanner.nextLine();
                    System.out.print("Ingrese Nombre de la Empresa: ");
                    String nombreEmp = scanner.nextLine();

                    EmpresaDesarrollo empresa = new EmpresaDesarrollo(nit, nombreEmp);
                    opEmpresas.agregar(empresa);
                    System.out.println("Empresa registrada exitosamente.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE EMPRESAS ---");
                    for (Empresa emp : opEmpresas.listar()) {
                        System.out.println(emp.toString());
                    }
                    if (opEmpresas.listar().isEmpty()) {
                        System.out.println("No hay empresas registradas.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese NIT a buscar: ");
                    String nitBuscado = scanner.nextLine();
                    Empresa empBuscada = opEmpresas.buscar(nitBuscado);
                    if (empBuscada != null) {
                        System.out.println("Encontrada: " + empBuscada.toString());
                    } else {
                        System.out.println("Empresa no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese Cédula del Empleado: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombreEmpld = scanner.nextLine();
                    System.out.print("Ingrese Sueldo por Hora: ");
                    double sueldoHora = Double.parseDouble(scanner.nextLine());

                    System.out.print("Ingrese el NIT de la Empresa a la que pertenece: ");
                    String nitEmpresa = scanner.nextLine();

                    Empresa empReferencia = opEmpresas.buscar(nitEmpresa);
                    if (empReferencia == null) {
                        System.out.println("No existe la empresa con ese NIT. No se puede crear el empleado.");
                        break;
                    }

                    System.out.println("Tipo de empleado:");
                    System.out.println("1. Desarrollador");
                    System.out.println("2. Admin");
                    System.out.println("3. Gestor de Proyectos");
                    System.out.print("Opción: ");
                    String tipo = scanner.nextLine();

                    switch (tipo) {
                        case "1":
                            Desarrollador dev = new Desarrollador(cedula, nombreEmpld, sueldoHora, empReferencia);
                            opEmpleados.agregar(dev);
                            System.out.println("Desarrollador registrado.");
                            break;
                        case "2":
                            Admin admin = new Admin(cedula, nombreEmpld, sueldoHora, empReferencia);
                            opEmpleados.agregar(admin);
                            System.out.println("Admin registrado.");
                            break;
                        case "3":
                            System.out.print("Ingrese el área del gestor: ");
                            String area = scanner.nextLine();
                            GestorProyectos gestor = new GestorProyectos(cedula, nombreEmpld, sueldoHora, empReferencia,
                                    area);
                            opEmpleados.agregar(gestor);
                            System.out.println("Gestor de Proyectos registrado.");
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("\n--- LISTA DE EMPLEADOS ---");
                    for (Empleado emp : opEmpleados.listar()) {
                        System.out.println(emp.toString());
                    }
                    if (opEmpleados.listar().isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese Cédula a buscar: ");
                    String cedBuscada = scanner.nextLine();
                    Empleado eBuscado = opEmpleados.buscar(cedBuscada);
                    if (eBuscado != null) {
                        System.out.println("Encontrado: " + eBuscado.toString());
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }
}
