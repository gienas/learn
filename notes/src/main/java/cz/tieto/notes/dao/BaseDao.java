package cz.tieto.notes.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * Add object to data store
	 * 
	 * @param t
	 */
	void add(T t);

	/**
	 * Get all objects from data stor
	 * @return
	 */
	List<T> getAll();

}
