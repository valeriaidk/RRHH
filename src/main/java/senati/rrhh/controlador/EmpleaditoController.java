package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Empleadito;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IEmpleaditoSevic;
import senati.rrhh.servicio.IEmpleadoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class EmpleaditoController {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleaditoController.class);
    @Autowired
    private IEmpleaditoSevic empleaditoSevic;

    //http://localhost:8080/rrhh-app/empleadito
    @GetMapping("/empleadito")
    public List<Empleadito> obtenerempleaditto(){
        var empleaditos = empleaditoSevic.ListarEmpleadito();
        empleaditos.forEach(empleadito -> logger.info(empleadito.toString()));
        return empleaditos;
    }

    @PostMapping("/empleadito")
    public Empleadito agregarEmpleadito(@RequestBody Empleadito empleadito){
        return empleaditoSevic.guardarEmpleadito(empleadito);
    }
    @GetMapping("/empleadito/{id}")
    public ResponseEntity<Empleadito> buscarEmpleaditoId (@PathVariable Integer id){
        Empleadito empleadito = empleaditoSevic.buscarIDEmpleadito(id);
        return ResponseEntity.ok(empleadito);
    }
    @PutMapping("empleadito/{id}")
    public ResponseEntity<Empleadito> actualizarEmpleadito(@PathVariable Integer id,
                                                       @RequestBody Empleadito empleaditoUpdate){
        Empleadito empleadito = empleaditoSevic.buscarIDEmpleadito(id);
        empleadito.setNombree(empleaditoUpdate.getNombree());
        empleadito.setDescripcion(empleaditoUpdate.getDescripcion());
        empleadito.setFecha_inicio(empleaditoUpdate.getFecha_inicio());
        empleadito.setFecha_fin(empleaditoUpdate.getFecha_fin());
        empleadito.setPresupuesto(empleaditoUpdate.getPresupuesto());
        empleadito.setStatus(empleaditoUpdate.getStatus());
        empleadito.setNombre_cliente(empleaditoUpdate.getNombre_cliente());

        empleaditoSevic.guardarEmpleadito(empleadito);
        return ResponseEntity.ok(empleadito);
    }
    @DeleteMapping("empleadito/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleadito(@PathVariable Integer id){
        Empleadito empleadito = empleaditoSevic.buscarIDEmpleadito(id);
        empleaditoSevic.eliminarEmpleadito(empleadito);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("empleado Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
