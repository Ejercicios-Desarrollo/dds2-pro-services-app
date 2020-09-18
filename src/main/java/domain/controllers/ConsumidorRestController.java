package domain.controllers;

import com.google.gson.Gson;
import domain.entities.actores.Consumidor;
import domain.repositories.Repository;
import domain.repositories.daos.DAOHibernate;
import spark.Request;
import spark.Response;

public class ConsumidorRestController extends BaseController{
    public static String detalle(Request request, Response response){
        Integer idUsuario = new Integer(request.queryParams("id"));
        Repository<Consumidor> repoConsumidores = new Repository<>(new DAOHibernate(), Consumidor.class);

        /*
        Integer idUsuario = null;

        if (request.queryParams("id") != null){
            idUsuario = new Integer(request.queryParams("id"));
        }
        else {
            idUsuario = BaseController.obtenerIdUsuarioSegun(request);
        }
        */
        Consumidor consumidor = repoConsumidores.find(idUsuario);

        Gson gson = new Gson();

        return gson.toJson(consumidor);
    }

    public static String modificar(Request request, Response response){
        return null;
    }
}
