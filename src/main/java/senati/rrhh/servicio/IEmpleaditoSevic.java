package senati.rrhh.servicio;

import senati.rrhh.modelo.Empleadito;

import java.util.List;
public interface IEmpleaditoSevic {
    List<Empleadito> ListarEmpleadito();
    Empleadito buscarIDEmpleadito(Integer idEmpleadito);
    Empleadito guardarEmpleadito(Empleadito empleadito);
    void eliminarEmpleadito(Empleadito empleadito);
}
