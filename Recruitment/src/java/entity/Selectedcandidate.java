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
@Table(name = "selectedcandidate", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Selectedcandidate.findAll", query = "SELECT s FROM Selectedcandidate s"),
    @NamedQuery(name = "Selectedcandidate.findById", query = "SELECT s FROM Selectedcandidate s WHERE s.id = :id"),
    @NamedQuery(name = "Selectedcandidate.findByJobId", query = "SELECT s FROM Selectedcandidate s WHERE s.jobId = :jobId"),
    @NamedQuery(name = "Selectedcandidate.findByUsername", query = "SELECT s FROM Selectedcandidate s WHERE s.username = :username"),
    @NamedQuery(name = "Selectedcandidate.findBySalary", query = "SELECT s FROM Selectedcandidate s WHERE s.salary = :salary"),
    @NamedQuery(name = "Selectedcandidate.findByDesignation", query = "SELECT s FROM Selectedcandidate s WHERE s.designation = :designation"),
    @NamedQuery(name = "Selectedcandidate.findByIsConfirmed", query = "SELECT s FROM Selectedcandidate s WHERE s.isConfirmed = :isConfirmed")})
public class Selectedcandidate implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsConfirmed")
    private boolean isConfirmed;
    @JoinColumn(name = "JobId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Jobdetails jobId;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Register username;

    public Selectedcandidate() {
    }

    public Selectedcandidate(Integer id) {
        this.id = id;
    }

    public Selectedcandidate(int salary, String designation, boolean isConfirmed) {        
        this.salary = salary;
        this.designation = designation;
        this.isConfirmed = isConfirmed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
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
        if (!(object instanceof Selectedcandidate)) {
            return false;
        }
        Selectedcandidate other = (Selectedcandidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Selectedcandidate[ id=" + id + " ]";
    }
}
