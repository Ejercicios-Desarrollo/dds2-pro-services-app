package domain.dtos;

import domain.entities.actores.Consumidor;
import domain.entities.actores.Prestador;
import domain.entities.servicios.Tarea;
import domain.entities.trabajos.EstadoTrabajo;
import domain.entities.trabajos.Trabajo;
import domain.entities.trabajos.direccion.Direccion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TrabajoDto {
    private String nombreConsumidor;
    private String nombrePrestador;
    private LocalDate fechaDeSolicitud;
    private Boolean trabajoAceptado;
    private Direccion direccion;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private List<Tarea> tareas;
    private EstadoTrabajo estado;
    private Boolean finalizadoSegunConsumidor;
    private Boolean finalizadoSegunPrestador;

    public TrabajoDto(Trabajo trabajo){
        this.nombreConsumidor = trabajo.getConsumidor().getNombre() + trabajo.getConsumidor().getApellido();
        this.nombrePrestador = trabajo.getPrestador().getNombre() + trabajo.getPrestador().getApellido();
        this.fechaDeSolicitud = trabajo.getFechaDeSolicitud();
        this.trabajoAceptado = trabajo.getTrabajoAceptado();
        this.direccion = trabajo.getDireccion();
        this.fecha = trabajo.getFecha();
        this.horaInicio = trabajo.getHoraInicio();
        this.horaFin = trabajo.getHoraFin();
        this.tareas = trabajo.getTareas();
        this.estado = trabajo.getEstado();
        this.finalizadoSegunConsumidor = trabajo.getFinalizadoSegunConsumidor();
        this.finalizadoSegunPrestador = trabajo.getFinalizadoSegunPrestador();
    }
}
