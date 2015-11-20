/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "transaction_details", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetailsDTO.findAll", query = "SELECT t FROM TransactionDetailsDTO t"),
    @NamedQuery(name = "TransactionDetailsDTO.findByTransId", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.transId = :transId"),
    @NamedQuery(name = "TransactionDetailsDTO.findByTransDate", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.transDate = :transDate"),
    @NamedQuery(name = "TransactionDetailsDTO.findByTransAmt", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.transAmt = :transAmt"),
    @NamedQuery(name = "TransactionDetailsDTO.findByFromAcct", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.fromAcct = :fromAcct"),
    @NamedQuery(name = "TransactionDetailsDTO.findByToAcct", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.toAcct = :toAcct"),
    @NamedQuery(name = "TransactionDetailsDTO.findByTemp1", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.temp1 = :temp1"),
    @NamedQuery(name = "TransactionDetailsDTO.findByTemp2", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.temp2 = :temp2"),
    @NamedQuery(name = "TransactionDetailsDTO.findByIsAuthorized", query = "SELECT t FROM TransactionDetailsDTO t WHERE t.isAuthorized = :isAuthorized")})
public class TransactionDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANS_ID")
    private Integer transId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_AMT")
    private double transAmt;
    @Size(max = 45)
    @Column(name = "FROM_ACCT")
    private String fromAcct;
    @Size(max = 45)
    @Column(name = "TO_ACCT")
    private String toAcct;
    @Size(max = 45)
    @Column(name = "TEMP_1")
    private String temp1;
    @Size(max = 45)
    @Column(name = "TEMP_2")
    private String temp2;
    @Column(name = "IS_AUTHORIZED")
    private Boolean isAuthorized;
    @OneToOne(mappedBy = "reqTransId")
    private RequestDetailsDTO requestDetailsDTO;

    public TransactionDetailsDTO() {
    }

    public TransactionDetailsDTO(Integer transId) {
        this.transId = transId;
    }

    public TransactionDetailsDTO(Integer transId, Date transDate, double transAmt) {
        this.transId = transId;
        this.transDate = transDate;
        this.transAmt = transAmt;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }

    public String getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(String fromAcct) {
        this.fromAcct = fromAcct;
    }

    public String getToAcct() {
        return toAcct;
    }

    public void setToAcct(String toAcct) {
        this.toAcct = toAcct;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public Boolean getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(Boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public RequestDetailsDTO getRequestDetailsDTO() {
        return requestDetailsDTO;
    }

    public void setRequestDetailsDTO(RequestDetailsDTO requestDetailsDTO) {
        this.requestDetailsDTO = requestDetailsDTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetailsDTO)) {
            return false;
        }
        TransactionDetailsDTO other = (TransactionDetailsDTO) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.TransactionDetailsDTO[ transId=" + transId + " ]";
    }
    
}
