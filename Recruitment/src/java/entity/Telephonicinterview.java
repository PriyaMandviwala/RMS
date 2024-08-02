/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "telephonicinterview", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telephonicinterview.findAll", query = "SELECT t FROM Telephonicinterview t"),
    @NamedQuery(name = "Telephonicinterview.findByTeleId", query = "SELECT t FROM Telephonicinterview t WHERE t.teleId = :teleId"),
    @NamedQuery(name = "Telephonicinterview.findByJobId", query = "SELECT t FROM Telephonicinterview t WHERE t.jobId = :jobId"),
    @NamedQuery(name = "Telephonicinterview.findByUsername", query = "SELECT t FROM Telephonicinterview t WHERE t.username = :username"),
    @NamedQuery(name = "Telephonicinterview.findByIsSelected", query = "SELECT t FROM Telephonicinterview t WHERE t.isSelected = :isSelected")})
public class Telephonicinterview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TeleId")
    private Integer teleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSelected")
    private boolean isSelected;
    @JoinColumn(name = "JobId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Jobdetails jobId;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Register username;

    public Telephonicinterview() {
    }

    public Telephonicinterview(Integer teleId) {
        this.teleId = teleId;
    }

    public Telephonicinterview(boolean isSelected) {        
        this.isSelected = isSelected;
    }

    public Integer getTeleId() {
        return teleId;
    }

    public void setTeleId(Integer teleId) {
        this.teleId = teleId;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Jobdetails getJobId() {
        return jobId;
    }

    public void setJobId(Jobdetails jobId) {
        this.jobId = jobId;
    }

    public Register getUsername() {
        return username;
    }

    public void setUsername(Register username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teleId != null ? teleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telephonicinterview)) {
            return false;
        }
        Telephonicinterview other = (Telephonicinterview) object;
        if ((this.teleId == null && other.teleId != null) || (this.teleId != null && !this.teleId.equals(other.teleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Telephonicinterview[ teleId=" + teleId + " ]";
    }
    
}
