package repositories;

import java.util.List;

public interface EntityRepository<T>{
    void create(T t);
    void delete(T t);
    void update(T t);
    List<T> getAll();
    T find(long id);
}

