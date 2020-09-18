package domain.controllers;

import com.google.gson.Gson;
import domain.dtos.PrestadorDto;
import domain.entities.actores.Prestador;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;
import spark.Response;

public class PrestadorRestController extends BaseController{
    public static String detalle(Request request, Response response){
        Integer idUsuario = new Integer(request.params("id"));
        Repository<Prestador> repoPrestadores = new Repository<>(new DAOHibernate(), Prestador.class);

        /*
        Integer idUsuario = null;

        if (request.queryParams("id") != null){
            idUsuario = new Integer(request.queryParams("id"));
        }
        else {
            idUsuario = BaseController.obtenerIdUsuarioSegun(request);
        }
        */
        Prestador prestador = repoPrestadores.find(idUsuario);

        PrestadorDto prestadorDto = new PrestadorDto(prestador);

        Gson gson = new Gson();

        return gson.toJson(prestadorDto);
    }

    public static String modificar(Request request, Response response){
        return null;
    }
}
