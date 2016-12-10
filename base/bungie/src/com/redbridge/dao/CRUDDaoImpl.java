package com.redbridge.dao;

import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CRUDDaoImpl implements CRUDDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> klass) {
		return getCurrentSession().createQuery("from " + klass.getName())
				.list();
	}
	

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public <T> void Save(T klass) {
		getCurrentSession().saveOrUpdate(klass);
	}

	public <T> void delete(T klass) {
		getCurrentSession().delete(klass);

	}

	@SuppressWarnings("unchecked")
	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {

 		Query q = getCurrentSession().getNamedQuery(query);
		int i = 0;

		for (Object o : params) {
			q.setParameter(i, o);
		}

		List<T> results = q.list();
		 
		T foundentity = null;
		if (!results.isEmpty()) {
			// ignores multiple results
			foundentity = results.get(0);
		}
		return foundentity;
	}

	@Override
	public <T> List<T> queryByProducto(Class<T> klass,String nombreProducto,String marca,String color,String capacidad, String displaySize) {		
		  
		nombreProducto = (nombreProducto!=null?nombreProducto.trim():"");
		marca = (marca!=null?marca.trim():"");
		color = (color!=null?color.trim():"");
		capacidad = (capacidad!=null?capacidad.trim():"");
		displaySize = (displaySize!=null?displaySize.trim():"");
        		
		StringBuffer queryStmt = new StringBuffer();
        
        queryStmt.append("SELECT p FROM ProductoEntity p  ");
		   
        if(!marca.equals("") || !color.equals("") || !capacidad.equals("") || !nombreProducto.equals("") || !displaySize.equals("")){
			   queryStmt.append("WHERE "); 
		   }
		   if(!nombreProducto.equals("")){
			   queryStmt.append("     p.nombre LIKE '%"+nombreProducto+"%'");
			   if(!marca.equals("") || !color.equals("") || !capacidad.equals("") || !displaySize.equals("") ){
				   queryStmt.append(" AND "); 
			   }		   
		   }
		   if(!marca.equals("")){
			   queryStmt.append("     p.marca LIKE '%"+marca+"%'");
			   if(!color.equals("") || !capacidad.equals("") || !displaySize.equals("")){
				   queryStmt.append(" AND "); 
			   }		   
		   }
		   if(!color.equals("")){
			   queryStmt.append("     p.color LIKE '%"+color+"%'");
			   if(!capacidad.equals("") || !displaySize.equals("")){
				   queryStmt.append(" AND "); 
			   }
		   }
		   if(!capacidad.equals("")){
			   queryStmt.append("     p.capacidad LIKE '%"+capacidad+"%'"); 
			   if(!displaySize.equals("")){
				   queryStmt.append(" AND "); 
			   }
		   }
           if(!displaySize.equals("")){
			   
			   StringTokenizer token = new StringTokenizer(displaySize,"-");
			   String unidadPatern   = ".";
			   
			   String size1 = token.nextToken();
			   String size2 = token.nextToken();
			   
			   queryStmt.append("     p.displaySize BETWEEN "+size1+" AND "+size2);	
			   
			   
		   }
		   
		   System.out.println("SQL Producto:"+queryStmt);
		   Query query = getCurrentSession().createQuery( queryStmt.toString());
		   List<T> productos = query.list();
		   System.out.println("Numero de Productos Encontrados:"+productos.size());
		   
		return productos;
	}

	
	
	
}
