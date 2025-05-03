package senati.rrhh.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Empleadito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmpleadito;
    String nombree;
    String descripcion;
    String fecha_inicio;
    String fecha_fin;
    String presupuesto;
    String status;
    String nombre_cliente;

}
