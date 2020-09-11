package domain.controllers;

import spark.Request;
import spark.Response;

public class ConsumidorRestController {
    public static String detalle(Request request, Response response){
        if (request.params("id") != null){

        }
        else {
            // Integer idUsuario = BaseController.idUsuarioSegunRequest(request);
            // Prestador prestador = repoUsuarios.buscar(idUsuario);
        }
        return null;
    }

    public static String modificar(Request request, Response response){
        return null;
    }
}
