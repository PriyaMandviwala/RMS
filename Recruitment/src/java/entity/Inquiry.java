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
@Table(name = "inquiry", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inquiry.findAll", query = "SELECT i FROM Inquiry i"),
    @NamedQuery(name = "Inquiry.findById", query = "SELECT i FROM Inquiry i WHERE i.id = :id"),
    @NamedQuery(name = "Inquiry.findByMessage", query = "SELECT i FROM Inquiry i WHERE i.message = :message"),
    @NamedQuery(name = "Inquiry.findByIsRead", query = "SELECT i FROM Inquiry i WHERE i.isRead = :isRead")})
public class Inquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "Message", nullable = false, length = 800)
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsRead", nullable = false)
    private boolean isRead;
    @JoinColumn(name = "JobId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Jobdetails jobId;
    @JoinColumn(name = "UserName", referencedColumnName = "Username", nullable = false)
    @ManyToOne(optional = false)
    private Register userName;

    public Inquiry() {
    }

    public Inquiry(Integer id) {
        this.id = id;
    }

    public Inquiry(String message, boolean isRead) {
        this.message = message;
        this.isRead = isRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Jobdetails getJobId() {
        return jobId;
    }

    public void setJobId(Jobdetails jobId) {
        this.jobId = jobId;
    }

    public Register getUserName() {
        return userName;
    }

    public void setUserName(Register userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquiry)) {
            return false;
        }
        Inquiry other = (Inquiry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Inquiry[ id=" + id + " ]";
    }
    
}
