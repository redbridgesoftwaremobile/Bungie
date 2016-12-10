package com.redbridge.dao;

import java.util.List;

public interface CRUDDao {
	<T> List<T> getAll(Class<T> klass);

	<T> void Save(T klass);

	<T> T GetUniqueEntityByNamedQuery(String query, Object... params);
	
	<T> void delete(T klass);
	
	<T> List<T> queryByProducto(Class<T> klass,String nombreProducto,
			                   String marca,String color,String capacidad,String displaySize);
}
