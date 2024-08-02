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
@Table(name = "aptituderesult", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aptituderesult.findAll", query = "SELECT a FROM Aptituderesult a"),
    @NamedQuery(name = "Aptituderesult.findById", query = "SELECT a FROM Aptituderesult a WHERE a.id = :id"),
    @NamedQuery(name = "Aptituderesult.findByMarks", query = "SELECT a FROM Aptituderesult a WHERE a.marks = :marks"),
    @NamedQuery(name = "Aptituderesult.findByMarksRange", query = "SELECT a FROM Aptituderesult a WHERE a.marks >= :smarks and a.marks <= :emarks"),
    @NamedQuery(name = "Aptituderesult.findByIsSelected", query = "SELECT a FROM Aptituderesult a WHERE a.isSelected = :isSelected")})
public class Aptituderesult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marks", nullable = false)
    private double marks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSelected", nullable = false)
    private boolean isSelected;
    @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false)
    @ManyToOne(optional = false)
    private Register username;
    @JoinColumn(name = "AptitudeTestId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Aptitudetest aptitudeTestId;

    public Aptituderesult() {
    }

    public Aptituderesult(Integer id) {
        this.id = id;
    }

    public Aptituderesult(double marks, boolean isSelected) {
        this.marks = marks;
        this.isSelected = isSelected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Register getUsername() {
        return username;
    }

    public void setUsername(Register username) {
        this.username = username;
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
        if (!(object instanceof Aptituderesult)) {
            return false;
        }
        Aptituderesult other = (Aptituderesult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aptituderesult[ id=" + id + " ]";
    }
    
}
