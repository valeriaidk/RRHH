package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Empleadito;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.modelo.Proyecto;
import senati.rrhh.servicio.IProyectpServi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class ProyectoController {
    private static final Logger logger =
            LoggerFactory.getLogger(ProyectoController.class);
    @Autowired
    private IProyectpServi proyectpServi;

    //http://localhost:8080/rrhh-app/proyecto
    @GetMapping("/proyecto")
    public List<Proyecto> obtenerproyecto(){
        var proyectos = proyectpServi.ListarProyecto();
        proyectos.forEach(proyecto -> logger.info(proyecto.toString()));
        return proyectos;
    }

    //agregar es un post
    @PostMapping("/proyecto")
    public Proyecto agregarProyecto(@RequestBody Proyecto proyecto){
        return proyectpServi.guardarproyecto(proyecto);
    }
    @GetMapping("/proyecto/{id}")
    public ResponseEntity<Proyecto> buscarProyectoId (@PathVariable Integer id){
        Proyecto proyecto = proyectpServi.buscarproyecto(id);
        return ResponseEntity.ok(proyecto);
    }
    @PutMapping("proyecto/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Integer id,
                                                       @RequestBody Proyecto proyectoUpdate){
        Proyecto proyecto = proyectpServi.buscarproyecto(id);
        proyecto.setNombrep(proyectoUpdate.getNombrep());
        proyecto.setApellidop(proyectoUpdate.getApellidop());
        proyecto.setEmail(proyectoUpdate.getEmail());
        proyecto.setFecha_contratacion(proyectoUpdate.getFecha_contratacion());
        proyecto.setRol(proyectoUpdate.getRol());
        proyecto.setSalario(proyectoUpdate.getSalario());

        proyectpServi.guardarproyecto(proyecto);
        return ResponseEntity.ok(proyecto);
    }
    @DeleteMapping("proyecto/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProyecto(@PathVariable Integer id){
        Proyecto proyecto = proyectpServi.buscarproyecto(id);
        proyectpServi.eliminarProyecto(proyecto);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("proyecto Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
