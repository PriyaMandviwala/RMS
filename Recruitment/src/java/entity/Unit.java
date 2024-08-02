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
@Table(name = "unit", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findById", query = "SELECT u FROM Unit u WHERE u.id = :id"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name"),
    @NamedQuery(name = "Unit.findByAddress", query = "SELECT u FROM Unit u WHERE u.address = :address"),
    @NamedQuery(name = "Unit.findByStateId", query = "SELECT u FROM Unit u WHERE u.stateId = :stateId"),
    @NamedQuery(name = "Unit.findByCityId", query = "SELECT u FROM Unit u WHERE u.cityId = :cityId"),
    @NamedQuery(name = "Unit.findByZipCode", query = "SELECT u FROM Unit u WHERE u.zipCode = :zipCode")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZipCode")
    private int zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId")
    private Collection<Company> companyCollection;
    @JoinColumn(name = "CountryId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "StateId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private State stateId;
    @JoinColumn(name = "CityId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private City cityId;

    public Unit() {
    }

    public Unit(Integer id) {
        this.id = id;
    }

    public Unit(String name, String address, int zipCode) {        
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
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
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Unit[ id=" + id + " ]";
    }
}
