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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "personalinterview", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personalinterview.findAll", query = "SELECT p FROM Personalinterview p"),
    @NamedQuery(name = "Personalinterview.findById", query = "SELECT p FROM Personalinterview p WHERE p.id = :id"),
    @NamedQuery(name = "Personalinterview.findByIsSelected", query = "SELECT p FROM Personalinterview p WHERE p.isSelected = :isSelected")})
public class Personalinterview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSelected", nullable = false)
    private boolean isSelected;
    @JoinColumn(name = "JobId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Jobdetails jobId;
    @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false)
    @ManyToOne(optional = false)
    private Register username;

    public Personalinterview() {
    }

    public Personalinterview(Integer id) {
        this.id = id;
    }

    public Personalinterview(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalinterview)) {
            return false;
        }
        Personalinterview other = (Personalinterview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Personalinterview[ id=" + id + " ]";
    }
    
}
