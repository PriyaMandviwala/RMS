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
@Table(name = "testinstruction", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testinstruction.findAll", query = "SELECT t FROM Testinstruction t"),
    @NamedQuery(name = "Testinstruction.findById", query = "SELECT t FROM Testinstruction t WHERE t.id = :id"),
    @NamedQuery(name = "Testinstruction.findByAptitudeTestId", query = "SELECT t FROM Testinstruction t WHERE t.aptitudeTestId = :aptitudeTestId"),
    @NamedQuery(name = "Testinstruction.findByMessage", query = "SELECT t FROM Testinstruction t WHERE t.message = :message")})
public class Testinstruction implements Serializable {

      private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "Message")
    private String message;
    @JoinColumn(name = "AptitudeTestId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Aptitudetest aptitudeTestId;

    public Testinstruction() {
    }

    public Testinstruction(Integer id) {
        this.id = id;
    }

    public Testinstruction(String message) {        
        this.message = message;
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

    public Aptitudetest getAptitudeTestId() {
        return aptitudeTestId;
    }

    public void setAptitudeTestId(Aptitudetest aptitudeTestId) {
        this.aptitudeTestId = aptitudeTestId;
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
        if (!(object instanceof Testinstruction)) {
            return false;
        }
        Testinstruction other = (Testinstruction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Testinstruction[ id=" + id + " ]";
    }
    
}
