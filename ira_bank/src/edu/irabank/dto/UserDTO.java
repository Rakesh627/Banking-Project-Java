/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.irabank.dto;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "user", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDTO.findAll", query = "SELECT u FROM UserDTO u"),
    @NamedQuery(name = "UserDTO.findByUserId", query = "SELECT u FROM UserDTO u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDTO.findByUserName", query = "SELECT u FROM UserDTO u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserDTO.findByPassword", query = "SELECT u FROM UserDTO u WHERE u.password = :password"),
    @NamedQuery(name = "UserDTO.findByEmailId", query = "SELECT u FROM UserDTO u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserDTO.findByCreateTime", query = "SELECT u FROM UserDTO u WHERE u.createTime = :createTime"),
    @NamedQuery(name = "UserDTO.findByFirstName", query = "SELECT u FROM UserDTO u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserDTO.findByLastName", query = "SELECT u FROM UserDTO u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserDTO.findByAddress", query = "SELECT u FROM UserDTO u WHERE u.address = :address"),
    @NamedQuery(name = "UserDTO.findByDob", query = "SELECT u FROM UserDTO u WHERE u.dob = :dob"),
    @NamedQuery(name = "UserDTO.findByContactNum", query = "SELECT u FROM UserDTO u WHERE u.contactNum = :contactNum"),
    @NamedQuery(name = "UserDTO.findBySecQue1", query = "SELECT u FROM UserDTO u WHERE u.secQue1 = :secQue1"),
    @NamedQuery(name = "UserDTO.findBySecAns1", query = "SELECT u FROM UserDTO u WHERE u.secAns1 = :secAns1"),
    @NamedQuery(name = "UserDTO.findBySecQue2", query = "SELECT u FROM UserDTO u WHERE u.secQue2 = :secQue2"),
    @NamedQuery(name = "UserDTO.findBySecAns2", query = "SELECT u FROM UserDTO u WHERE u.secAns2 = :secAns2"),
    @NamedQuery(name = "UserDTO.findByPkiPath", query = "SELECT u FROM UserDTO u WHERE u.pkiPath = :pkiPath"),
    @NamedQuery(name = "UserDTO.findByPkiCerti", query = "SELECT u FROM UserDTO u WHERE u.pkiCerti = :pkiCerti"),
    @NamedQuery(name = "UserDTO.findByPkiNumber", query = "SELECT u FROM UserDTO u WHERE u.pkiNumber = :pkiNumber"),
    @NamedQuery(name = "UserDTO.findByPublicKey", query = "SELECT u FROM UserDTO u WHERE u.publicKey = :publicKey"),
    @NamedQuery(name = "UserDTO.findByOtp", query = "SELECT u FROM UserDTO u WHERE u.otp = :otp"),
    @NamedQuery(name = "UserDTO.findBySsn", query = "SELECT u FROM UserDTO u WHERE u.ssn = :ssn"),
    @NamedQuery(name = "UserDTO.findByLoginAttempts", query = "SELECT u FROM UserDTO u WHERE u.loginAttempts = :loginAttempts"),
    @NamedQuery(name = "UserDTO.findByAcctLockedStatus", query = "SELECT u FROM UserDTO u WHERE u.acctLockedStatus = :acctLockedStatus"),
    @NamedQuery(name = "UserDTO.findByActiveStatus", query = "SELECT u FROM UserDTO u WHERE u.activeStatus = :activeStatus"),
    @NamedQuery(name = "UserDTO.findBySitekey", query = "SELECT u FROM UserDTO u WHERE u.sitekey = :sitekey")})
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 560)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTACT_NUM")
    private String contactNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "SEC_QUE1")
    private String secQue1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEC_ANS1")
    private String secAns1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "SEC_QUE2")
    private String secQue2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEC_ANS2")
    private String secAns2;
    @Size(max = 45)
    @Column(name = "PKI_PATH")
    private String pkiPath;
    @Size(max = 45)
    @Column(name = "PKI_CERTI")
    private String pkiCerti;
    @Size(max = 45)
    @Column(name = "PKI_NUMBER")
    private String pkiNumber;
    @Size(max = 2048)
    @Column(name = "PUBLIC_KEY")
    private String publicKey;
    @Size(max = 45)
    private String otp;
    @Size(max = 10)
    private String ssn;
    @Column(name = "LOGIN_ATTEMPTS")
    private Integer loginAttempts;
    @Column(name = "ACCT_LOCKED_STATUS")
    private Boolean acctLockedStatus;
    @Column(name = "ACTIVE_STATUS")
    private Boolean activeStatus;
    @Size(max = 45)
    private String sitekey;
    @Column(name = "IS_OK_PII")
    private Boolean is_ok_pii;
    @Column(name = "ACTIVE_STATUS")
    @OneToMany(mappedBy = "reqUserId")
    private List<RequestDetailsDTO> requestDetailsDTOList;
    @OneToMany(mappedBy = "merchantId")
    private List<BillPayDTO> billPayDTOList;
    @OneToMany(mappedBy = "uId")
    private List<AccountDetailsDTO> accountDetailsDTOList;
    @OneToMany(mappedBy = "notificationUserId")
    private List<NotificationDetailsDTO> notificationDetailsDTOList;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne
    private RolesDTO roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantId")
    private List<UserBillpayDTO> userBillpayDTOList;

    public UserDTO() {
    }

    public UserDTO(Integer userId) {
        this.userId = userId;
    }

    public UserDTO(Integer userId, String userName, String password, String emailId, String firstName, String lastName, Date dob, String contactNum, String secQue1, String secAns1, String secQue2, String secAns2) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.contactNum = contactNum;
        this.secQue1 = secQue1;
        this.secAns1 = secAns1;
        this.secQue2 = secQue2;
        this.secAns2 = secAns2;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getSecQue1() {
        return secQue1;
    }

    public void setSecQue1(String secQue1) {
        this.secQue1 = secQue1;
    }

    public String getSecAns1() {
        return secAns1;
    }

    public void setSecAns1(String secAns1) {
        this.secAns1 = secAns1;
    }

    public String getSecQue2() {
        return secQue2;
    }

    public void setSecQue2(String secQue2) {
        this.secQue2 = secQue2;
    }

    public String getSecAns2() {
        return secAns2;
    }

    public void setSecAns2(String secAns2) {
        this.secAns2 = secAns2;
    }

    public String getPkiPath() {
        return pkiPath;
    }

    public void setPkiPath(String pkiPath) {
        this.pkiPath = pkiPath;
    }

    public String getPkiCerti() {
        return pkiCerti;
    }

    public void setPkiCerti(String pkiCerti) {
        this.pkiCerti = pkiCerti;
    }

    public String getPkiNumber() {
        return pkiNumber;
    }

    public void setPkiNumber(String pkiNumber) {
        this.pkiNumber = pkiNumber;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Boolean getAcctLockedStatus() {
        return acctLockedStatus;
    }

    public void setAcctLockedStatus(Boolean acctLockedStatus) {
        this.acctLockedStatus = acctLockedStatus;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getSitekey() {
        return sitekey;
    }

    public void setSitekey(String sitekey) {
        this.sitekey = sitekey;
    }

    @XmlTransient
    public List<RequestDetailsDTO> getRequestDetailsDTOList() {
        return requestDetailsDTOList;
    }

    public void setRequestDetailsDTOList(List<RequestDetailsDTO> requestDetailsDTOList) {
        this.requestDetailsDTOList = requestDetailsDTOList;
    }

    @XmlTransient
    public List<BillPayDTO> getBillPayDTOList() {
        return billPayDTOList;
    }

    public void setBillPayDTOList(List<BillPayDTO> billPayDTOList) {
        this.billPayDTOList = billPayDTOList;
    }

    @XmlTransient
    public List<AccountDetailsDTO> getAccountDetailsDTOList() {
        return accountDetailsDTOList;
    }

    public void setAccountDetailsDTOList(List<AccountDetailsDTO> accountDetailsDTOList) {
        this.accountDetailsDTOList = accountDetailsDTOList;
    }

    @XmlTransient
    public List<NotificationDetailsDTO> getNotificationDetailsDTOList() {
        return notificationDetailsDTOList;
    }

    public void setNotificationDetailsDTOList(List<NotificationDetailsDTO> notificationDetailsDTOList) {
        this.notificationDetailsDTOList = notificationDetailsDTOList;
    }

    public RolesDTO getRoleId() {
        return roleId;
    }

    public void setRoleId(RolesDTO roleId) {
        this.roleId = roleId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDTO)) {
            return false;
        }
        UserDTO other = (UserDTO) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.UserDTO[ userId=" + userId + " ]";
    }

	public Boolean getIs_ok_pii() {
		return is_ok_pii;
	}

	public void setIs_ok_pii(Boolean is_ok_pii) {
		this.is_ok_pii = is_ok_pii;
	}
    
}
