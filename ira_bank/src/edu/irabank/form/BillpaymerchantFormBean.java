package edu.irabank.form;

import java.util.Date;

import javax.annotation.Nonnegative;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BillpaymerchantFormBean {
	
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String account;
	@Basic(optional = false)
	@NotNull @Nonnegative @Min(value = 0)
    private String amount;

   
    public void setAccount(String account){
    	this.account = account;
    }
	
    public String getAccount() {
		return account;
	}
    
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}
			
    
    
}
