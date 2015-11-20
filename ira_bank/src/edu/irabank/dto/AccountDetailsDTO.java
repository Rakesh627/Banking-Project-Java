/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "account_details", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetailsDTO.findAll", query = "SELECT a FROM AccountDetailsDTO a"),
    @NamedQuery(name = "AccountDetailsDTO.findByAcctId", query = "SELECT a FROM AccountDetailsDTO a WHERE a.acctId = :acctId"),
    @NamedQuery(name = "AccountDetailsDTO.findByAccountNumber", query = "SELECT a FROM AccountDetailsDTO a WHERE a.accountNumber = :accountNumber"),
    @NamedQuery(name = "AccountDetailsDTO.findByBalance", query = "SELECT a FROM AccountDetailsDTO a WHERE a.balance = :balance"),
    @NamedQuery(name = "AccountDetailsDTO.findByTemp1", query = "SELECT a FROM AccountDetailsDTO a WHERE a.temp1 = :temp1"),
    @NamedQuery(name = "AccountDetailsDTO.findByTemp2", query = "SELECT a FROM AccountDetailsDTO a WHERE a.temp2 = :temp2")})
public class AccountDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCT_ID")
    private Integer acctId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Basic(optional = false)
    @NotNull
    private double balance;
    @Size(max = 45)
    @Column(name = "TEMP_1")
    private String temp1;
    @Size(max = 45)
    @Column(name = "TEMP_2")
    private String temp2;
    @JoinColumn(name = "U_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserDTO uId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    private List<UserBillpayDTO> userBillpayDTOList;

    public AccountDetailsDTO() {
    }

    public AccountDetailsDTO(Integer acctId) {
        this.acctId = acctId;
    }

    public AccountDetailsDTO(Integer acctId, String accountNumber, double balance) {
        this.acctId = acctId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public UserDTO getUId() {
        return uId;
    }

    public void setUId(UserDTO uId) {
        this.uId = uId;
    }

    @XmlTransient
    public List<UserBillpayDTO> getUserBillpayDTOList() {
        return userBillpayDTOList;
    }

    public void setUserBillpayDTOList(List<UserBillpayDTO> userBillpayDTOList) {
        this.userBillpayDTOList = userBillpayDTOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acctId != null ? acctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountDetailsDTO)) {
            return false;
        }
        AccountDetailsDTO other = (AccountDetailsDTO) object;
        if ((this.acctId == null && other.acctId != null) || (this.acctId != null && !this.acctId.equals(other.acctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.AccountDetailsDTO[ acctId=" + acctId + " ]";
    }
    
}
