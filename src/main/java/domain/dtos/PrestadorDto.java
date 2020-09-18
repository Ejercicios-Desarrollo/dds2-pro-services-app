package domain.dtos;

import domain.entities.actores.Prestador;
import domain.entities.actores.TipoDeDocumento;

import java.time.LocalDate;

public class PrestadorDto {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private String cuitCuil;
    private Integer usuario;
    private TipoDeDocumento tipoDeDocumento;
    private Integer numeroDeIdentificacion;

    public PrestadorDto(Prestador prestador){
        this.nombre = prestador.getNombre();
        this.apellido = prestador.getApellido();
        this.fechaDeNacimiento = prestador.getFechaDeNacimiento();
        this.cuitCuil = prestador.getCuitCuil();
        this.usuario = prestador.getUsuario();
        this.tipoDeDocumento = prestador.getTipoDeDocumento();
        this.numeroDeIdentificacion = prestador.getNumeroDeIdentificacion();
    }
}
