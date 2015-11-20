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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "roles", catalog = "sbs", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesDTO.findAll", query = "SELECT r FROM RolesDTO r"),
    @NamedQuery(name = "RolesDTO.findByRoleId", query = "SELECT r FROM RolesDTO r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RolesDTO.findByRoleName", query = "SELECT r FROM RolesDTO r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "RolesDTO.findByRoleDesc", query = "SELECT r FROM RolesDTO r WHERE r.roleDesc = :roleDesc"),
    @NamedQuery(name = "RolesDTO.findByCreatedDate", query = "SELECT r FROM RolesDTO r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RolesDTO.findByIsActive", query = "SELECT r FROM RolesDTO r WHERE r.isActive = :isActive")})
public class RolesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Size(max = 60)
    @Column(name = "ROLE_DESC")
    private String roleDesc;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "IS_ACTIVE")
    private Short isActive;
    @OneToMany(mappedBy = "roleId")
    private List<UserDTO> userDTOList;

    public RolesDTO() {
    }

    public RolesDTO(Integer roleId) {
        this.roleId = roleId;
    }

    public RolesDTO(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesDTO)) {
            return false;
        }
        RolesDTO other = (RolesDTO) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.irabank.dto.RolesDTO[ roleId=" + roleId + " ]";
    }
    
}
