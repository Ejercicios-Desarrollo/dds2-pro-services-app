package domain.repositories;

import domain.repositories.daos.EntityManagerHelper;
import domain.repositories.daos.IDAO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Repository<T> {
    protected IDAO<T> dao;
    protected Class<T> classToManage;

    public Repository(IDAO<T> dao, Class<T> classToManage) {
        this.dao = dao;
        this.classToManage = classToManage;
    }

    public void setDao(IDAO<T> dao) {
        this.dao = dao;
    }

    public boolean exist(int id){
        return this.dao.exist(id, this.classToManage);
    }

    public T find(int id){
        return this.dao.find(id, this.classToManage);
    }

    public List<T> findAll(){
        return this.dao.findAll(this.classToManage);
    }

    public void delete(T object){
        this.dao.delete(object);
    }

    public void update(T object){
        this.dao.update(object);
    }

    public void insert(T object){
        this.dao.insert(object);
    }

    public CriteriaBuilder criteriaBuilder(){
        return EntityManagerHelper.getEntityManager().getCriteriaBuilder();
    }
}