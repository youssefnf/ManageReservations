package dao;

import java.util.List;

public interface IDAO<T> {

    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    T findById(int id);

    List<T> findAll();

}
