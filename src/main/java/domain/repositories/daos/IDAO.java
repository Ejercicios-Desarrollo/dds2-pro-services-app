package domain.repositories.daos;

import java.util.List;

public interface IDAO<T> {
    boolean exist(int id, Class<T> clase);
    T find(int id, Class<T> clase);
    List<T> find(BusquedaCondicional condicional);
    List<T> findAll(Class<T> clase);
    void delete(T object);
    void update(T object);
    void insert(T object);
}
