package senati.rrhh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.rrhh.modelo.Proyecto;
import senati.rrhh.repositorio.ProyectoRepositi;

import java.util.List;

@Service
public class ProyectoServici implements IProyectpServi {

    @Autowired
    private ProyectoRepositi proyectoRepositorio;

    @Override
    public List<Proyecto> ListarProyecto() {
        return proyectoRepositorio.findAll();
    }

    @Override
    public Proyecto buscarproyecto(Integer idProyecto) {
        return proyectoRepositorio.findById(idProyecto).orElse(null);
    }

    @Override
    public Proyecto guardarproyecto(Proyecto proyecto) {
        return proyectoRepositorio.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) {
        proyectoRepositorio.delete(proyecto);
    }
}
