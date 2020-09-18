package domain.controllers;

import com.google.gson.Gson;
import domain.dtos.TrabajoDto;
import domain.entities.trabajos.Trabajo;
import domain.repositories.RepositorioDeTrabajos;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.stream.Collectors;

public class TrabajoRestController {
    public static String listar(Request request, Response response){
        RepositorioDeTrabajos repoTrabajos = new RepositorioDeTrabajos(new DAOHibernate(), Trabajo.class);
        String consumidorId = request.queryParams("consumidorId");
        //List<Trabajo> trabajos = repoTrabajos.findAll();

        List<Trabajo> trabajos = repoTrabajos.buscarTrabajos(Integer.valueOf(consumidorId));

        List<TrabajoDto> trabajosDto = trabajos.stream().map(TrabajoDto::new).collect(Collectors.toList());

        Gson gson = new Gson();

        return gson.toJson(trabajosDto);
    }
}
