package br.com.tetrati.school.rest;

import java.io.Serializable;
import java.util.List;

import javax.websocket.server.PathParam;

public interface SimpleController<T, ID extends Serializable>
{
	public T create(T entity);
	public T getById(@PathParam("id") ID id);
	public List<T> getAll();
	public void delete(@PathParam("id") ID id);
}
