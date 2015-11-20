package edu.irabank.form;

import java.util.Date;

import javax.annotation.Nonnegative;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.xml.internal.ws.developer.StreamingAttachment;

public class AccountFormBean {
	@Basic(optional = false)
	@NotNull @Nonnegative @Min(value = 0)
	private String amount;
    
	@NotNull
	private String accountNumber;
	@Basic(optional = false)
	@NotNull 
	private String CreditDebit; 
   
    public void setAccountNumber(String accountNumber){
    	this.accountNumber = accountNumber;
    }
	
    public String getAccountNumber() {
		return accountNumber;
	}
    
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setCreditDebit(String CreditDebit) {
			this.CreditDebit = CreditDebit;
		}
	
    public String getCreditDebit() {
		return CreditDebit;
	}
    
 
		
    
    
}
