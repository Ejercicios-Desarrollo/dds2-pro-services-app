package domain.controllers;

import com.google.gson.Gson;
import domain.dtos.TrabajoDto;
import domain.entities.trabajos.Trabajo;
import domain.repositories.RepositorioDeTrabajos;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrabajoRestController {
    public static String listar(Request request, Response response){
        RepositorioDeTrabajos repoTrabajos = new RepositorioDeTrabajos(new DAOHibernate(), Trabajo.class);

        List<Trabajo> trabajos = new ArrayList<>();

        String criterio = request.queryParams("criterio");
        Integer id = Integer.valueOf(request.queryParams("id"));

        if (criterio.equals("consumidor")){
            trabajos = repoTrabajos.buscarTrabajosPorConsumidor(id);
        }
        else {
            trabajos = repoTrabajos.buscarTrabajosPorPrestador(id);
        }
        
        List<TrabajoDto> trabajosDto = trabajos.stream().map(TrabajoDto::new).collect(Collectors.toList());

        Gson gson = new Gson();

        return gson.toJson(trabajosDto);
    }
}
