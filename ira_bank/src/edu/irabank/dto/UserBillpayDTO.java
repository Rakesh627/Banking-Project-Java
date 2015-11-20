/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "user_billpay", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBillpayDTO.findAll", query = "SELECT u FROM UserBillpayDTO u"),
    @NamedQuery(name = "UserBillpayDTO.findByUserBillId", query = "SELECT u FROM UserBillpayDTO u WHERE u.userBillId = :userBillId")})
public class UserBillpayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_BILL_ID")
    private Integer userBillId;
    @JoinColumn(name = "MERCHANT_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private UserDTO merchantId;
    @JoinColumn(name = "ACCOUNT_NUMBER", referencedColumnName = "ACCOUNT_NUMBER")
    @ManyToOne(optional = false)
    private AccountDetailsDTO accountNumber;

    public UserBillpayDTO() {
    }

    public UserBillpayDTO(Integer userBillId) {
        this.userBillId = userBillId;
    }

    public Integer getUserBillId() {
        return userBillId;
    }

    public void setUserBillId(Integer userBillId) {
        this.userBillId = userBillId;
    }

    public UserDTO getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UserDTO merchantId) {
        this.merchantId = merchantId;
    }

    public AccountDetailsDTO getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountDetailsDTO accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userBillId != null ? userBillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBillpayDTO)) {
            return false;
        }
        UserBillpayDTO other = (UserBillpayDTO) object;
        if ((this.userBillId == null && other.userBillId != null) || (this.userBillId != null && !this.userBillId.equals(other.userBillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.UserBillpayDTO[ userBillId=" + userBillId + " ]";
    }
    
}
