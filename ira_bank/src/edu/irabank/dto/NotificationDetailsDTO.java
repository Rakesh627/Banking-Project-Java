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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramki Subramanian
 */
@Entity
@Table(name = "notification_details", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationDetailsDTO.findAll", query = "SELECT n FROM NotificationDetailsDTO n"),
    @NamedQuery(name = "NotificationDetailsDTO.findByNotificationId", query = "SELECT n FROM NotificationDetailsDTO n WHERE n.notificationId = :notificationId"),
    @NamedQuery(name = "NotificationDetailsDTO.findByNotificationName", query = "SELECT n FROM NotificationDetailsDTO n WHERE n.notificationName = :notificationName"),
    @NamedQuery(name = "NotificationDetailsDTO.findByNotificationDescription", query = "SELECT n FROM NotificationDetailsDTO n WHERE n.notificationDescription = :notificationDescription"),
    @NamedQuery(name = "NotificationDetailsDTO.findByNotificationStatus", query = "SELECT n FROM NotificationDetailsDTO n WHERE n.notificationStatus = :notificationStatus"),
    @NamedQuery(name = "NotificationDetailsDTO.findByBillid", query = "SELECT n FROM NotificationDetailsDTO n WHERE n.notificationBillid = :notificationBillid")})
public class NotificationDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NOTIFICATION_ID")
    private Integer notificationId;
	@Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "NOTIFICATION_NAME")
    private String notificationName;
    @Size(max = 128)
    @Column(name = "NOTIFICATION_DESCRIPTION")
    private String notificationDescription;
    @Column(name = "NOTIFICATION_STATUS")
    private String notificationStatus;
    @JoinColumn(name = "NOTIFICATION_USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserDTO notificationUserId;
    @JoinColumn(name = "NOTIFICATION_BILL_ID", referencedColumnName = "BILL_ID")
    @OneToOne
    private BillPayDTO notificationBillid;

    
	public NotificationDetailsDTO() {
    }

    public NotificationDetailsDTO(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationDetailsDTO(Integer notificationId, String notificationName) {
        this.notificationId = notificationId;
        this.notificationName = notificationName;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public UserDTO getNotificationUserId() {
        return notificationUserId;
    }

    public void setNotificationUserId(UserDTO notificationUserId) {
        this.notificationUserId = notificationUserId;
    }
    
    public BillPayDTO getNotificationBillid() {
		return notificationBillid;
	}

	public void setNotificationBillid(BillPayDTO notificationBillid) {
		this.notificationBillid = notificationBillid;
	}


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationDetailsDTO)) {
            return false;
        }
        NotificationDetailsDTO other = (NotificationDetailsDTO) object;
        if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.NotificationDetailsDTO[ notificationId=" + notificationId + " ]";
    }
    
}
