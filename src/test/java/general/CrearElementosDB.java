package general;

import domain.entities.actores.Consumidor;
import domain.entities.actores.Disponibilidad;
import domain.entities.actores.Prestador;
import domain.entities.actores.TipoDeDocumento;
import domain.entities.servicios.Servicio;
import domain.entities.servicios.ServicioOfrecido;
import domain.entities.servicios.Tarea;
import domain.entities.trabajos.EstadoTrabajo;
import domain.entities.trabajos.Trabajo;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class CrearElementosDB {
    public static void main(String[] args){
        Repository<Servicio> repositorioDeServicios = new Repository<>(new DAOHibernate(), Servicio.class);
        Servicio instalacionReparacionAiresAcondicionados = new Servicio("Instalación y reparacion de Aires Acondicionados");

        Tarea cargaDeGas = new Tarea("Carga de gas");
        instalacionReparacionAiresAcondicionados.agregarTareas(cargaDeGas, new Tarea("Cambio de\n" +
                        "mangueras"), new Tarea("Limpieza de filtros"), new Tarea("Reparación del motor"),
                new Tarea("Instalación de equipo"));

        Servicio mantenimientoDeJardin = new Servicio("Mantenimiento de jardín");
        mantenimientoDeJardin.agregarTareas(new Tarea("Cortar el pasto"), new Tarea("Podar los árboles"), new Tarea("Regar las\n" +
                "plantas"), new Tarea("Remover la tierra"), new Tarea("Decorar el jardín"));

        repositorioDeServicios.insert(instalacionReparacionAiresAcondicionados);
        repositorioDeServicios.insert(mantenimientoDeJardin);

        EstadoTrabajo enEspera = new EstadoTrabajo("En espera de confirmación");
        Repository<EstadoTrabajo> repositorioEstadoTrabajo = new Repository<>(new DAOHibernate(), EstadoTrabajo.class);
        repositorioEstadoTrabajo.insert(enEspera);
        repositorioEstadoTrabajo.insert(new EstadoTrabajo("Confirmado"));
        repositorioEstadoTrabajo.insert(new EstadoTrabajo("Rechazado"));
        repositorioEstadoTrabajo.insert(new EstadoTrabajo("No realizado"));
        repositorioEstadoTrabajo.insert(new EstadoTrabajo("Realizado"));

        Repository<Prestador> repositorioDePrestadores = new Repository<>(new DAOHibernate(), Prestador.class);
        Prestador joseCastillo = new Prestador("Jose", "Castillo");
        joseCastillo.setFechaDeNacimiento(LocalDate.of(1983, 8, 20));
        joseCastillo.setTipoDeDocumento(TipoDeDocumento.DNI);
        joseCastillo.setNumeroDeIdentificacion(31777999);
        joseCastillo.setCuitCuil("21-31777999-8");
        joseCastillo.setUsuario(1);

        repositorioDePrestadores.insert(joseCastillo);
        Repository<Consumidor> repositorioDeConsumidores = new Repository<>(new DAOHibernate(), Consumidor.class);

        Consumidor melisaContreras = new Consumidor("Melisa Jesica", "Contreras");
        melisaContreras.setUsuario(2);
        repositorioDeConsumidores.insert(melisaContreras);

        Repository<Trabajo> repositorioDeTrabajos = new Repository<>(new DAOHibernate(), Trabajo.class);
        Trabajo trabajo = new Trabajo(melisaContreras, joseCastillo);
        //trabajo.agregarTareas(cargaDeGas);
        //trabajo.setLugar("Avenida del Libertador 3580 CABA");
        trabajo.setFecha(LocalDate.of(2020,9,14));
        trabajo.setHoraInicio(LocalTime.of(8,0,0,0));
        trabajo.setHoraFin(LocalTime.of(10,0,0,0));
        trabajo.setEstado(enEspera);
        repositorioDeTrabajos.insert(trabajo);
    }
}
