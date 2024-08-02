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
@Table(name = "companyservices", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyservices.findAll", query = "SELECT c FROM Companyservices c"),
    @NamedQuery(name = "Companyservices.findById", query = "SELECT c FROM Companyservices c WHERE c.id = :id"),
    @NamedQuery(name = "Companyservices.findByServiceTitle", query = "SELECT c FROM Companyservices c WHERE c.serviceTitle = :serviceTitle"),
    @NamedQuery(name = "Companyservices.findByServiceDescription", query = "SELECT c FROM Companyservices c WHERE c.serviceDescription = :serviceDescription")})
public class Companyservices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ServiceTitle", nullable = false, length = 30)
    private String serviceTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ServiceDescription", nullable = false, length = 200)
    private String serviceDescription;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;

    public Companyservices() {
    }

    public Companyservices(Integer id) {
        this.id = id;
    }

    public Companyservices(String serviceTitle, String serviceDescription) {
        this.serviceTitle = serviceTitle;
        this.serviceDescription = serviceDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof Companyservices)) {
            return false;
        }
        Companyservices other = (Companyservices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companyservices[ id=" + id + " ]";
    }
    
}
