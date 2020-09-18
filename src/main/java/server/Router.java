package server;

// import domain.middlewares.JwtMiddleware;
import domain.controllers.ConsumidorRestController;
import domain.controllers.PrestadorRestController;
import domain.controllers.ServicioRestController;
import domain.controllers.TrabajoRestController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
// import spark.utils.EqualsHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        Spark.before("/api/*", ((request, response) -> response.type("application/json")));

        Spark.get("/api/servicios", ServicioRestController::listar);
        Spark.get("/api/servicio/:id", ServicioRestController::detalle);

        //Spark.get("/api/prestador/:id", PrestadorRestController::detalle);
        Spark.get("/api/prestador", PrestadorRestController::detalle);
        Spark.put("/api/prestador", PrestadorRestController::modificar);

        Spark.get("/api/consumidor", ConsumidorRestController::detalle);
        Spark.put("/api/consumidor", ConsumidorRestController::modificar);

        Spark.get("/api/trabajos", TrabajoRestController::listar);
    }
}
