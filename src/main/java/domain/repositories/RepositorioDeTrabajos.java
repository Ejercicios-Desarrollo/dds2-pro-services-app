package domain.repositories;

import domain.entities.trabajos.Trabajo;
import domain.repositories.daos.IDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositorioDeTrabajos extends Repository<Trabajo>{

    public RepositorioDeTrabajos(IDAO<Trabajo> dao, Class<Trabajo> classToManage) {
        super(dao, classToManage);
    }

    public List<Trabajo> buscarTrabajos(Integer consumidorId){
        return this.dao.find(condicionConsumidorId(consumidorId));
    }

    private BusquedaCondicional condicionConsumidorId(Integer consumidorId) {
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Trabajo> trabajoQuery = criteriaBuilder.createQuery(Trabajo.class);

        Root<Trabajo> condicionRaiz = trabajoQuery.from(Trabajo.class);
        // SELECT t.* FROM trabajo

        Predicate condicionConsumidorId = criteriaBuilder.equal(condicionRaiz.get("consumidor"), consumidorId);
        // t.consumidorId = ''

        trabajoQuery.where(condicionConsumidorId);
        // SELECT t.* FROM trabajo u WHERE t.consumidor_id = ''

        return new BusquedaCondicional(trabajoQuery, null);
    }
}
