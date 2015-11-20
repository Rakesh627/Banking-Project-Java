package edu.irabank.form;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditProfileFormBean {
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String emailId;
    @Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60) 
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60) 
    private String lastName;
    @Size(max = 560)
    private String address;
    @NotNull
    @Size(min = 1, max = 20)
    private String contactNum;
    
    public String getemailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getcontactNum() {
		return contactNum;
	}
	public void setcontactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	}
	
    

