package domain.dtos;

import domain.entities.servicios.Servicio;
import domain.entities.servicios.ServicioOfrecido;

import java.util.List;

public class ServicioOfrecidoDto {
    private Servicio servicio;
    private String experiencia;
    private List<String> fotos;

    public ServicioOfrecidoDto(ServicioOfrecido servicioOfrecido){
        this.servicio = servicioOfrecido.getServicio();
        this.experiencia = servicioOfrecido.getExperiencia();
        this.fotos = servicioOfrecido.getFotos();
    }
}
