package com.redbridge.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.redbridge.entity.CatalogoImagenEntity;
import com.redbridge.entity.ProductoEntity;
import com.redbridge.service.CRUDService;

public class CatalogoImagenConverter extends HttpServlet {

	@Autowired
	private CRUDService crudService;
	
	
	/**
	 * Constructor of the object.
	 */
	public CatalogoImagenConverter() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String tipo = request.getParameter("tipo");
		ProductoEntity productoEntity = null;
				
        if(id!=null){
        	 productoEntity = crudService.GetUniqueEntityByNamedQuery("Producto.findProductoByProductoID", id);
             response.setContentType("image/jpeg");
             
             if(tipo.equalsIgnoreCase("icono_front"))              
                 response.getOutputStream().write(productoEntity.getIconoFront());
             
             if(tipo.equalsIgnoreCase("icono_back"))              
                 response.getOutputStream().write(productoEntity.getIconoBack());
             
             if(tipo.equalsIgnoreCase("icono_right"))              
                 response.getOutputStream().write(productoEntity.getIconoRight());
             
             if(tipo.equalsIgnoreCase("icono_left"))              
                 response.getOutputStream().write(productoEntity.getIconoLeft());
             
             if(tipo.equalsIgnoreCase("imagen_front"))              
                 response.getOutputStream().write(productoEntity.getImagenFront());
             
             if(tipo.equalsIgnoreCase("imagen_back"))              
                 response.getOutputStream().write(productoEntity.getImagenBack());
             
             if(tipo.equalsIgnoreCase("imagen_right"))              
                 response.getOutputStream().write(productoEntity.getImagenRight());
             
             if(tipo.equalsIgnoreCase("imagen_left"))              
                 response.getOutputStream().write(productoEntity.getImagenLeft());
                           
             //response.getOutputStream().write( Files.readAllBytes(new File(getServletContext().getRealPath("****.jpg")).toPath()));
             response.getOutputStream().close();
        }else {
             response.getWriter().println("NO EXISTE IMAGEN EN BASE DE DATOS.");
             response.getWriter().close();
        }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	}

	public void setCrudService(CRUDService crudService) {
		this.crudService = crudService;
	}
	
	

}
