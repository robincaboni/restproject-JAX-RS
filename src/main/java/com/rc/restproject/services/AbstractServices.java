package com.rc.restproject.services;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
public abstract class AbstractServices<T> {

    protected abstract List<T> getListT() throws SQLException, NamingException;
    protected abstract List<T> getOneT(int id) throws NamingException;
    protected abstract void createT(T t) throws SQLException, NamingException;
    protected abstract void deleteT(int id) throws SQLException, NamingException;
    protected abstract void updateT(T t, int id) throws SQLException, NamingException;

    protected EntityManager getEntityManager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trans");
        return emf.createEntityManager();
    }
    
    @GET
    public List<T> getList() throws SQLException, NamingException { 
      List<T> records = getListT();
      return records;
    }

	@GET 
    @Path("{id}")
    public List<T> getSingle(@PathParam("id") int id) throws NamingException {
      List<T> records = getOneT(id);
      return records; 
    }

    @POST
    public void insertSingle(T t) throws NamingException, SQLException {
      createT(t); 
    }
    
    @DELETE
    @Path("{id}")
    public void deleteSingle(@PathParam("id") int id) throws SQLException, NamingException {
      deleteT(id);
    }

    @PUT
    @Path("{id}")
    public void updateSingle(T t, @PathParam("id") int id) throws SQLException, NamingException {
      updateT(t,id);
    }
	
}
