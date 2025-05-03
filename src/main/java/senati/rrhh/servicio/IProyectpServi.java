package senati.rrhh.servicio;

import senati.rrhh.modelo.Proyecto;
import java.util.List;

public interface IProyectpServi {
    List<Proyecto> ListarProyecto();
    Proyecto buscarproyecto(Integer idProyecto);
    Proyecto guardarproyecto(Proyecto proyecto);
    void eliminarProyecto(Proyecto proyecto);
}
