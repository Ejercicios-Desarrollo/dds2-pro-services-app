package domain.controllers;

import spark.Request;

public abstract class BaseController {
    protected static Integer obtenerIdUsuarioSegun(Request request){
        return 1;
    }
}
