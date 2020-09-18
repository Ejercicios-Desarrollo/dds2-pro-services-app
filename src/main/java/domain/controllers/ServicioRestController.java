package domain.controllers;

import com.google.gson.Gson;
import domain.entities.servicios.Servicio;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;
import spark.Response;

import java.util.List;

public class ServicioRestController {
    public static String listar(Request request, Response response){
        //busco todos los servicios
        Repository<Servicio> repoServicios = new Repository<>(new DAOHibernate(), Servicio.class);
        List<Servicio> servicios = repoServicios.findAll();

        Gson gson = new Gson();

        return gson.toJson(servicios);
    }

    public static String detalle(Request request, Response response){
        Integer idServicioBuscado = new Integer(request.params("id"));
        Repository<Servicio> repoServicios = new Repository<>(new DAOHibernate(), Servicio.class);
        Servicio servicioBuscado = repoServicios.find(idServicioBuscado);

        Gson gson = new Gson();

        return gson.toJson(servicioBuscado);
    }
}
