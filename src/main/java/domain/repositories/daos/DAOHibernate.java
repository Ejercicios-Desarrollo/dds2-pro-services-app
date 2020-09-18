package domain.repositories.daos;

import domain.repositories.BusquedaCondicional;

import javax.persistence.Query;
import java.util.List;

public class DAOHibernate implements IDAO{

    @Override
    public boolean exist(int id, Class clase) {
        boolean result = EntityManagerHelper.entityManager().find(clase, id) != null;
        EntityManagerHelper.closeEntityManager();
        return result;
    }

    @Override
    public Object find(int id, Class clase) {
        Object o = EntityManagerHelper.entityManager().find(clase, id);
        return o;
    }

    @Override
    public List<Object> find(BusquedaCondicional condicional) {
        return (List<Object>) EntityManagerHelper.getEntityManager()
                .createQuery(condicional.getCondicionCriterio())
                .getResultList();
    }

    @Override
    public List findAll(Class clase) {
        Query query = EntityManagerHelper.createQuery("from " + clase.getName());
        List result = query.getResultList();
        return result;
    }

    @Override
    public void delete(Object object) {
        EntityManagerHelper.remove(object);
    }

    @Override
    public void update(Object object) {
        EntityManagerHelper.merge(object);
    }

    @Override
    public void insert(Object object) {
        EntityManagerHelper.persist(object);
    }
}