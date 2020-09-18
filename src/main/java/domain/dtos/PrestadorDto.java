package domain.dtos;

import domain.entities.actores.Prestador;
import domain.entities.actores.TipoDeDocumento;
import domain.entities.servicios.ServicioOfrecido;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrestadorDto {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private String cuitCuil;
    private Integer usuario;
    private TipoDeDocumento tipoDeDocumento;
    private Integer numeroDeIdentificacion;
    private Set<String> emails;
    private Set<Integer> telefonos;
    private List<ServicioOfrecidoDto> serviciosOfrecidos;

    public PrestadorDto(Prestador prestador){
        this.nombre = prestador.getNombre();
        this.apellido = prestador.getApellido();
        this.fechaDeNacimiento = prestador.getFechaDeNacimiento();
        this.cuitCuil = prestador.getCuitCuil();
        this.usuario = prestador.getUsuario();
        this.tipoDeDocumento = prestador.getTipoDeDocumento();
        this.numeroDeIdentificacion = prestador.getNumeroDeIdentificacion();
        this.emails = prestador.getEmails();
        this.telefonos = prestador.getTelefonos();
        this.serviciosOfrecidos = prestador.getServiciosOfrecidos().stream().map(servicioOfrecido -> new ServicioOfrecidoDto(servicioOfrecido)).collect(Collectors.toList());
    }
}
