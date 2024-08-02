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
@Table(name = "companystages", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companystages.findAll", query = "SELECT c FROM Companystages c"),
    @NamedQuery(name = "Companystages.findById", query = "SELECT c FROM Companystages c WHERE c.id = :id"),
    @NamedQuery(name = "Companystages.findByOrderNo", query = "SELECT c FROM Companystages c WHERE c.orderNo = :orderNo")})
public class Companystages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderNo", nullable = false)
    private int orderNo;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "StageId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Stages stageId;

    public Companystages() {
    }

    public Companystages(Integer id) {
        this.id = id;
    }

    public Companystages(int orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Stages getStageId() {
        return stageId;
    }

    public void setStageId(Stages stageId) {
        this.stageId = stageId;
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
        if (!(object instanceof Companystages)) {
            return false;
        }
        Companystages other = (Companystages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companystages[ id=" + id + " ]";
    }
    
}
