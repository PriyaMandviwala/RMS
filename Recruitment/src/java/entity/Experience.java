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
@Table(name = "experience", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e"),
    @NamedQuery(name = "Experience.findById", query = "SELECT e FROM Experience e WHERE e.id = :id"),
    @NamedQuery(name = "Experience.findByNoOfYears", query = "SELECT e FROM Experience e WHERE e.noOfYears = :noOfYears"),
    @NamedQuery(name = "Experience.findByCompanyName", query = "SELECT e FROM Experience e WHERE e.companyName = :companyName"),
    @NamedQuery(name = "Experience.findByDesignation", query = "SELECT e FROM Experience e WHERE e.designation = :designation"),
    @NamedQuery(name = "Experience.findBySalary", query = "SELECT e FROM Experience e WHERE e.salary = :salary"),
    @NamedQuery(name = "Experience.findByCompanyAddress", query = "SELECT e FROM Experience e WHERE e.companyAddress = :companyAddress"),
    @NamedQuery(name = "Experience.findByExperienceLetter", query = "SELECT e FROM Experience e WHERE e.experienceLetter = :experienceLetter")})
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfYears", nullable = false)
    private int noOfYears;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CompanyName", nullable = false, length = 30)
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Designation", nullable = false, length = 30)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary", nullable = false)
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "CompanyAddress", nullable = false, length = 300)
    private String companyAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ExperienceLetter", nullable = false, length = 500)
    private String experienceLetter;
    @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false)
    @ManyToOne(optional = false)
    private Register username;

    public Experience() {
    }

    public Experience(Integer id) {
        this.id = id;
    }

    public Experience(int noOfYears, String companyName, String designation, int salary, String companyAddress, String experienceLetter) {
        this.noOfYears = noOfYears;
        this.companyName = companyName;
        this.designation = designation;
        this.salary = salary;
        this.companyAddress = companyAddress;
        this.experienceLetter = experienceLetter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getExperienceLetter() {
        return experienceLetter;
    }

    public void setExperienceLetter(String experienceLetter) {
        this.experienceLetter = experienceLetter;
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
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Experience[ id=" + id + " ]";
    }
    
}
