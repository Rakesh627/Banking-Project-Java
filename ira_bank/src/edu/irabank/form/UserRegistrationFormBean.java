package edu.irabank.form;

import java.util.Date;

import javax.annotation.RegEx;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserRegistrationFormBean {
	
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
    private String userName;
	@NotEmpty
    private String password;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60) 
	private String firstName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String emailId;
    @Size(max = 560)
    private String address;
    private Date dob;
    @NotNull
    @Size(min = 1, max = 20)
    private String contactNum;
    @Basic(optional = false)
    @Size(min = 1, max = 128)
    private String secQue1;
    @Basic(optional = false)
    @Size(min = 1, max = 128)
    private String secAns1;
    @Basic(optional = false)
    @Size(min = 1, max = 128)
    private String secQue2;
    @Basic(optional = false)
    @Size(min = 1, max = 128)
    private String secAns2;
    private Integer role;
    
    private String ssn;
    @NotEmpty
    private String sitekey;
    private boolean is_ok_pii;
    
    
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public Integer getRole() {
		
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSitekey() {
		return sitekey;
	}
	public void setSitekey(String sitekey) {
		this.sitekey = sitekey;
	}
	public Boolean getIs_ok_pii() {
		return is_ok_pii;
	}

	public void setIs_ok_pii(Boolean is_ok_pii) {
		this.is_ok_pii = is_ok_pii;
	}
    
}
