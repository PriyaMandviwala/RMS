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
@Table(name = "state", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findById", query = "SELECT s FROM State s WHERE s.id = :id"),
    @NamedQuery(name = "State.findByCountryId", query = "SELECT s FROM State s WHERE s.countryId.id = :countryId"),
    @NamedQuery(name = "State.findByName", query = "SELECT s FROM State s WHERE s.name = :name")})
public class State implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 130)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<City> cityCollection;
    @JoinColumn(name = "CountryId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Country countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Unit> unitCollection;
    @OneToMany(mappedBy = "stateId")
    private Collection<Register> registerCollection;

    public State() {
    }

    public State(Integer id) {
        this.id = id;
    }

    public State(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    @JsonbTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Register> getRegisterCollection() {
        return registerCollection;
    }

    public void setRegisterCollection(Collection<Register> registerCollection) {
        this.registerCollection = registerCollection;
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
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.State[ id=" + id + " ]";
    }
}
