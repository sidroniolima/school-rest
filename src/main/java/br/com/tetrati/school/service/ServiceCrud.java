package br.com.tetrati.school.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceCrud<T, ID extends Serializable> 
{
	public T save(T entity);
	public void delete(ID id);
	public List<T> listAll();
	public T findById(ID id);
}
