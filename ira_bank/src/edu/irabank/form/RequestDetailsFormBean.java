package edu.irabank.form;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;

public class RequestDetailsFormBean {

	    @Size(max = 90)
	    @Column(name = "REQ_DESC")
	    private String reqDesc;
	   private Integer reqId;
	   private Date reqDate;
	    
		private Integer reqUsedId;
		private String fromAccount;
		private String toAccount;
		private Double amount;

	public String getFromAccount() {
			return fromAccount;
		}
		public void setFromAccount(String fromAccount) {
			this.fromAccount = fromAccount;
		}
		public String getToAccount() {
			return toAccount;
		}
		public void setToAccount(String toAccount) {
			this.toAccount = toAccount;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
	public Integer getReqUsedId() {
			return reqUsedId;
		}
		public void setReqUsedId(Integer reqUsedId) {
			this.reqUsedId = reqUsedId;
		}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public String getReqDesc() {
		return reqDesc;
	}
	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
}