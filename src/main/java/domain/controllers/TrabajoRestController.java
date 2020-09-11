package domain.controllers;

import com.google.gson.Gson;
import domain.entities.servicios.Servicio;
import domain.entities.trabajos.Trabajo;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;

import java.util.List;

public class TrabajoRestController {
    public static String listar(Request request, spark.Response response){
        //busco todos los servicios
        Repository<Trabajo> repoTrabajos = new Repository<>(new DAOHibernate(), Trabajo.class);
        List<Trabajo> trabajos = repoTrabajos.findAll();

        Gson gson = new Gson();

        return gson.toJson(trabajos);
    }
}
