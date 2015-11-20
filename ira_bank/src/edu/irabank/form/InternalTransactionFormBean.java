package edu.irabank.form;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Rakesh Subramanian
 *
 */

public class InternalTransactionFormBean {
	 @Size(max = 45)
	 @Column(name = "TO_ACCT")
	private String to_account;
	 @Size(max = 45)
	 @Column(name = "FROM_ACCT")
	private String from_account;
	 @Basic(optional = false)
	 @NotNull
	 @Column(name = "TRANS_AMT")
	private Double amount;

	public String getFrom_account() {
		return from_account;
	}

	public void setFrom_account(String from_account) {
		this.from_account = from_account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTo_account() {
		return to_account;
	}

	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}
	

}
