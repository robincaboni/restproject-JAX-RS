package com.rc.restproject.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="transactions_table")
public class Transaction implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private int TransactionId;
	@NotNull
	@Column(name = "transactiondate")
	private String TransactionDate;
	@Column(name = "description")
	private String Description;
	@NotNull
	@Column(name = "transactionamount")
	private int TransactionAmount;
	@NotNull
	@Column(name = "createddate")
	private String CreatedDate;
	@NotNull
	@Column(name = "modifieddate")
	private String ModifiedDate;
	@NotNull
	@Column(name = "currencycode")
	private String CurrencyCode;
	@Column(name = "merchant")
	private String Merchant;

	public Transaction(){
	}

	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		this.TransactionId = transactionId;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.TransactionDate = transactionDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public int getTransactionAmount() {
		return TransactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.TransactionAmount = transactionAmount;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		this.CreatedDate = createdDate;
	}
	public String getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.ModifiedDate = modifiedDate;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.CurrencyCode = currencyCode;
	}
	public String getMerchant() {
		return Merchant;
	}
	public void setMerchant(String merchant) {
		this.Merchant = merchant;
	}
		 	
	
	@Override
	public String toString() {
		return "Transaction [TransactionId=" + TransactionId
				+ ", TransactionDate=" + TransactionDate + ", Description="
				+ Description + ", TransactionAmount=" + TransactionAmount
				+ ", CreatedDate=" + CreatedDate + ", ModifiedDate="
				+ ModifiedDate + ", CurrencyCode=" + CurrencyCode
				+ ", Merchant=" + Merchant + "]";
	}
	
}
