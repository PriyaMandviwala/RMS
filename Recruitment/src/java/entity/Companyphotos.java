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
@Table(name = "companyphotos", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyphotos.findAll", query = "SELECT c FROM Companyphotos c"),
    @NamedQuery(name = "Companyphotos.findById", query = "SELECT c FROM Companyphotos c WHERE c.id = :id"),
    @NamedQuery(name = "Companyphotos.findByImage", query = "SELECT c FROM Companyphotos c WHERE c.image = :image")})
public class Companyphotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Image", nullable = false, length = 300)
    private String image;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;

    public Companyphotos() {
    }

    public Companyphotos(Integer id) {
        this.id = id;
    }

    public Companyphotos(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof Companyphotos)) {
            return false;
        }
        Companyphotos other = (Companyphotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companyphotos[ id=" + id + " ]";
    }
    
}
