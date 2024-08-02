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
@Table(name = "stages", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stages.findAll", query = "SELECT s FROM Stages s"),
    @NamedQuery(name = "Stages.findById", query = "SELECT s FROM Stages s WHERE s.id = :id"),
    @NamedQuery(name = "Stages.findByType", query = "SELECT s FROM Stages s WHERE s.type = :type")})
public class Stages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Type", nullable = false, length = 20)
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId")
    private Collection<Rejected> rejectedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId")
    private Collection<Companystages> companystagesCollection;

    public Stages() {
    }

    public Stages(Integer id) {
        this.id = id;
    }

    public Stages(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Rejected> getRejectedCollection() {
        return rejectedCollection;
    }

    public void setRejectedCollection(Collection<Rejected> rejectedCollection) {
        this.rejectedCollection = rejectedCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Companystages> getCompanystagesCollection() {
        return companystagesCollection;
    }

    public void setCompanystagesCollection(Collection<Companystages> companystagesCollection) {
        this.companystagesCollection = companystagesCollection;
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
        if (!(object instanceof Stages)) {
            return false;
        }
        Stages other = (Stages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Stages[ id=" + id + " ]";
    }
    
}
