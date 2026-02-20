package operaciones;

import modelos.Empresa;
import java.util.List;

public interface IOperacionEmpresa {
    void agregar(Empresa empresa);
    List<Empresa> listar();
    Empresa buscar(String nit);
}
