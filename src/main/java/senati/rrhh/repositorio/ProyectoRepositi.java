package senati.rrhh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.rrhh.modelo.Proyecto;

public interface ProyectoRepositi extends JpaRepository<Proyecto, Integer> {
}
