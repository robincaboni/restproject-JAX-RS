package com.rc.restproject.services;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.rc.restproject.models.*;


@Path("/transactions")
@Produces("application/json")
@Consumes("application/json")
public class TransactionServices extends AbstractServices<Transaction>{

	//@PersistenceContext(unitName = "TransactionsDB")
    private EntityManager em;
	private List<Transaction> listTrans;
	
	//Get all transactions
	@Override
	protected List<Transaction> getListT() throws NamingException{
	    em = getEntityManager();
	    em.getTransaction().begin();
	    listTrans = em.createQuery("SELECT e FROM Transaction e").getResultList();
	    em.getTransaction().commit();
	    em.close();
	    return listTrans;
	}
	
	//Get one transaction with id
	@Override
	protected List<Transaction> getOneT(int id) throws NamingException{
	  em = getEntityManager();
	  em.getTransaction().begin();
	  listTrans = Collections.singletonList(em.find(Transaction.class, id));
	  em.getTransaction().commit();
	  em.close();
	  return listTrans;
	}

	//Post one transaction
    @Override
    protected void createT(Transaction t) throws SQLException, NamingException{
    	Transaction trans = new Transaction();
    	em = getEntityManager();
    	em.getTransaction().begin();
    	trans.setCreatedDate(t.getCreatedDate());
    	trans.setCurrencyCode(t.getCurrencyCode());
    	trans.setDescription(t.getDescription());
    	trans.setMerchant(t.getMerchant());
    	trans.setModifiedDate(t.getModifiedDate());
    	trans.setTransactionAmount(t.getTransactionAmount());
    	trans.setTransactionDate(t.getTransactionDate());
    	em.persist(trans);
    	em.getTransaction().commit();
    	em.close();
    }
    
    //delete one transaction
    @Override
    protected void deleteT(int id) throws SQLException, NamingException {
    	Transaction trans = new Transaction();
		em = getEntityManager();
		em.getTransaction().begin();
		trans = em.find(Transaction.class, id);
		em.remove(trans);
		em.getTransaction().commit();
		em.close();
    }

    //update one transaction
    @Override
    protected void updateT(Transaction t, int id) throws SQLException, NamingException {
    	Transaction trans = new Transaction();
    	em = getEntityManager();
    	em.getTransaction().begin();
    	trans = em.find(Transaction.class, id);
    	trans.setCreatedDate(t.getCreatedDate());
    	trans.setCurrencyCode(t.getCurrencyCode());
    	trans.setDescription(t.getDescription());
    	trans.setMerchant(t.getMerchant());
    	trans.setModifiedDate(t.getModifiedDate());
    	trans.setTransactionAmount(t.getTransactionAmount());
    	trans.setTransactionDate(t.getTransactionDate());
    	em.persist(trans);
    	em.getTransaction().commit();
    	em.close();
    }

}
