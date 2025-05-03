package senati.rrhh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.rrhh.modelo.Empleadito;
import senati.rrhh.repositorio.EmpleaditoReposit;

import java.util.List;

@Service
public class EmpleaditoServici implements IEmpleaditoSevic {

    @Autowired
    private EmpleaditoReposit empleaditoRepositorio;

    @Override
    public List<Empleadito> ListarEmpleadito() {
        return empleaditoRepositorio.findAll();
    }

    @Override
    public Empleadito buscarIDEmpleadito(Integer idEmpleadito) {
        return empleaditoRepositorio.findById(idEmpleadito).orElse(null);
    }

    @Override
    public Empleadito guardarEmpleadito(Empleadito empleadito) {
        return empleaditoRepositorio.save(empleadito);
    }

    @Override
    public void eliminarEmpleadito(Empleadito empleadito) {
        empleaditoRepositorio.delete(empleadito);
    }
}
