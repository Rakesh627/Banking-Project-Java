package edu.irabank.form;

import java.util.Date;

import edu.irabank.dto.TransactionDetailsDTO;
/**
 * @author Rakesh Subramanian
 *
 */


public class RequestDetailsPopulateBean {
	private Integer reqUsedId;
	private String reqDesc;
	private Integer status;
	private Date reqDate;
	private String reqType;
	private Integer isAuthorized;
	private String reqPriority;
	//important since this is the foreign key
	private TransactionDetailsDTO reqTransId;
	
	
	public Integer getReqUsedId() {
		return reqUsedId;
	}
	public void setReqUsedId(Integer reqUsedId) {
		this.reqUsedId = reqUsedId;
	}
	public String getReqDesc() {
		return reqDesc;
	}
	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public Integer getIsAuthorized() {
		return isAuthorized;
	}
	public void setIsAuthorized(Integer isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	public String getReqPriority() {
		return reqPriority;
	}
	public void setReqPriority(String reqPriority) {
		this.reqPriority = reqPriority;
	}
	public TransactionDetailsDTO getReqTransId() {
		return reqTransId;
	}
	public void setReqTransId(TransactionDetailsDTO reqTransId) {
		this.reqTransId = reqTransId;
	}
	
	
	
	
	
	
	

}
