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

public class TransferFormBean {
	
    private String fromaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String toaccount; 
    @Basic(optional = false)
    @NotNull @Nonnegative @Min(value = 0)
    private String amount;
    private String pki;
   
    public void setFromaccount(String fromaccount){
    	this.fromaccount = fromaccount;
    }
	
    public String getFromaccount() {
		return fromaccount;
	}
    
    public void setToaccount(String toaccount){
    	this.toaccount = toaccount;
    }
	
    public String getToaccount() {
		return toaccount;
	}
    
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}

	public String getPki() {
		return pki;
	}

	public void setPki(String pki) {
		this.pki = pki;
	}
				
    
    
}
