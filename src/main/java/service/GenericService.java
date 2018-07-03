package service;

import java.util.List;


public interface GenericService < T > {

	T add(T object);
    void delete(Integer id);    
    T updateObject(T object);
    List<T> getAll();
		
}
