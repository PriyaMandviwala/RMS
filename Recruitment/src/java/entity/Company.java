/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "company", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByPassword", query = "SELECT c FROM Company c WHERE c.password = :password"),
    @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email"),
    @NamedQuery(name = "Company.findByContactNumber", query = "SELECT c FROM Company c WHERE c.contactNumber = :contactNumber"),
    @NamedQuery(name = "Company.findByNoOfEmployee", query = "SELECT c FROM Company c WHERE c.noOfEmployee = :noOfEmployee")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Name", nullable = false, length = 30)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Password", nullable = false, length = 300)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Email", nullable = false, length = 150)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactNumber", nullable = false)
    private int contactNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfEmployee", nullable = false)
    private int noOfEmployee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Jobdetails> jobdetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Companyservices> companyservicesCollection;
    @JoinColumn(name = "UnitId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Unit unitId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Companystages> companystagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<Companyphotos> companyphotosCollection;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(String name, String password, String email, int contactNumber, int noOfEmployee) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.noOfEmployee = noOfEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Jobdetails> getJobdetailsCollection() {
        return jobdetailsCollection;
    }

    public void setJobdetailsCollection(Collection<Jobdetails> jobdetailsCollection) {
        this.jobdetailsCollection = jobdetailsCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Companyservices> getCompanyservicesCollection() {
        return companyservicesCollection;
    }

    public void setCompanyservicesCollection(Collection<Companyservices> companyservicesCollection) {
        this.companyservicesCollection = companyservicesCollection;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Companystages> getCompanystagesCollection() {
        return companystagesCollection;
    }

    public void setCompanystagesCollection(Collection<Companystages> companystagesCollection) {
        this.companystagesCollection = companystagesCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Companyphotos> getCompanyphotosCollection() {
        return companyphotosCollection;
    }

    public void setCompanyphotosCollection(Collection<Companyphotos> companyphotosCollection) {
        this.companyphotosCollection = companyphotosCollection;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Company[ id=" + id + " ]";
    }
    
}
