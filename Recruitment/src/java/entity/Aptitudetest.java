/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "aptitudetest", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aptitudetest.findAll", query = "SELECT a FROM Aptitudetest a"),
    @NamedQuery(name = "Aptitudetest.findById", query = "SELECT a FROM Aptitudetest a WHERE a.id = :id"),
    @NamedQuery(name = "Aptitudetest.findByExamName", query = "SELECT a FROM Aptitudetest a WHERE a.examName = :examName"),
    @NamedQuery(name = "Aptitudetest.findByExamDetails", query = "SELECT a FROM Aptitudetest a WHERE a.examDetails = :examDetails"),
    @NamedQuery(name = "Aptitudetest.findByCutOff", query = "SELECT a FROM Aptitudetest a WHERE a.cutOff = :cutOff")})
public class Aptitudetest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ExamName", nullable = false, length = 50)
    private String examName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ExamDetails", nullable = false, length = 500)
    private String examDetails;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CutOff", nullable = false)
    private int cutOff;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptitudeTestId")
    private Collection<Aptituderesult> aptituderesultCollection;
    @JoinColumn(name = "JobId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Jobdetails jobId;

    public Aptitudetest() {
    }

    public Aptitudetest(Integer id) {
        this.id = id;
    }

    public Aptitudetest(String examName, String examDetails, int cutOff) {
        this.examName = examName;
        this.examDetails = examDetails;
        this.cutOff = cutOff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDetails() {
        return examDetails;
    }

    public void setExamDetails(String examDetails) {
        this.examDetails = examDetails;
    }

    public int getCutOff() {
        return cutOff;
    }

    public void setCutOff(int cutOff) {
        this.cutOff = cutOff;
    }

    @XmlTransient
    public Collection<Aptituderesult> getAptituderesultCollection() {
        return aptituderesultCollection;
    }

    public void setAptituderesultCollection(Collection<Aptituderesult> aptituderesultCollection) {
        this.aptituderesultCollection = aptituderesultCollection;
    }

    public Jobdetails getJobId() {
        return jobId;
    }

    public void setJobId(Jobdetails jobId) {
        this.jobId = jobId;
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
        if (!(object instanceof Aptitudetest)) {
            return false;
        }
        Aptitudetest other = (Aptitudetest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aptitudetest[ id=" + id + " ]";
    }
    
}
