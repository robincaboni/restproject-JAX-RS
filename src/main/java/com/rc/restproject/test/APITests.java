package com.rc.restproject.test;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.rc.restproject.models.*;

public class APITests {
	public static void main(String[] args) {
		/* POSTING TRANSACTION TESTING */
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/restproject/api/transactions/");
			
			Transaction transaction = new Transaction();
			transaction.setCreatedDate("12-11-2013");
			transaction.setCurrencyCode("EUR");
			transaction.setDescription("test");
			transaction.setMerchant("test");
			transaction.setModifiedDate("12-12-2013");
	    	transaction.setTransactionAmount(1205);
	    	transaction.setTransactionDate("12-01-2014");
			
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, transaction);

			StringBuilder builder = new StringBuilder("=== New Transaction ===\n");
		        builder.append("Created Date: ").append(transaction.getCreatedDate()).append(", ")
		        		.append("Transaction Date: ").append(transaction.getTransactionDate()).append(", ")
		        		.append("Description: ").append(transaction.getDescription()).append(", ")
		        		.append("Transaction Ammount: ").append(transaction.getTransactionAmount()).append(", ")
		        		.append("Currency code: ").append(transaction.getCurrencyCode()).append(", ")
		        		.append("Modified Date: ").append(transaction.getModifiedDate()).append(", ")
		        		.append("Merchant: ").append(transaction.getMerchant()).append(", ")
		        		.append("Id: ").append(transaction.getTransactionId()).append("\n"); 
		        
			System.out.println("Output from Server .... \n");
			System.out.println("GET POSTING TRANSACTION \n");
			System.out.println(builder.toString());

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		
		/* GET ALL TRANSACTIONS TESTING */
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/restproject/api/transactions/");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			List<Transaction> transactions
            = response.getEntity(new GenericType<List<Transaction>>(){});
			
			StringBuilder builder = new StringBuilder("=== Transactions ===\n");
		    for (Transaction transaction: transactions) {
		        builder.append("Created Date: ").append(transaction.getCreatedDate()).append(", ")
		        		.append("Transaction Date: ").append(transaction.getTransactionDate()).append(", ")
		        		.append("Description: ").append(transaction.getDescription()).append(", ")
		        		.append("Transaction Ammount: ").append(transaction.getTransactionAmount()).append(", ")
		        		.append("Currency code: ").append(transaction.getCurrencyCode()).append(", ")
		        		.append("Modified Date: ").append(transaction.getModifiedDate()).append(", ")
		        		.append("Merchant: ").append(transaction.getMerchant()).append(", ")
		        		.append("Id: ").append(transaction.getTransactionId()).append("\n");          
		    }

			System.out.println("Output from Server .... \n");
			System.out.println("GET ALL TRANSACTIONS \n");
			System.out.println(builder.toString());

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		
		/* GET ONE TRANSACTION TESTING */
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/restproject/api/transactions/1");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			List<Transaction> transactions
            = response.getEntity(new GenericType<List<Transaction>>(){});
			
			StringBuilder builder = new StringBuilder("=== Transaction with id=1 ===\n");
		    for (Transaction transaction: transactions) {
		        builder.append("Created Date: ").append(transaction.getCreatedDate()).append(", ")
		        		.append("Transaction Date: ").append(transaction.getTransactionDate()).append(", ")
		        		.append("Description: ").append(transaction.getDescription()).append(", ")
		        		.append("Transaction Ammount: ").append(transaction.getTransactionAmount()).append(", ")
		        		.append("Currency code: ").append(transaction.getCurrencyCode()).append(", ")
		        		.append("Modified Date: ").append(transaction.getModifiedDate()).append(", ")
		        		.append("Merchant: ").append(transaction.getMerchant()).append(", ")
		        		.append("Id: ").append(transaction.getTransactionId()).append("\n");          
		    }

			System.out.println("Output from Server .... \n");
			System.out.println("GET ONE TRANSACTION \n");
			System.out.println(builder.toString());

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
}
