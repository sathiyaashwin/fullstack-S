package com.example.ifaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
	
	public int add(T obj);
	public List<T> findAll();
	public int remove(int id);
	public Optional<T> findById(int id);
	public int update(int Id,T obj);
}
