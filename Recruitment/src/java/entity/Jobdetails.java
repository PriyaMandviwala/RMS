/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "jobdetails", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobdetails.findAll", query = "SELECT j FROM Jobdetails j"),
    @NamedQuery(name = "Jobdetails.findById", query = "SELECT j FROM Jobdetails j WHERE j.id = :id"),
    @NamedQuery(name = "Jobdetails.findByTitle", query = "SELECT j FROM Jobdetails j WHERE j.title = :title"),
    @NamedQuery(name = "Jobdetails.findByDetails", query = "SELECT j FROM Jobdetails j WHERE j.details = :details"),
    @NamedQuery(name = "Jobdetails.findByNoOfVacancy", query = "SELECT j FROM Jobdetails j WHERE j.noOfVacancy = :noOfVacancy"),
    @NamedQuery(name = "Jobdetails.findByPackage1", query = "SELECT j FROM Jobdetails j WHERE j.package1 = :package1"),
    @NamedQuery(name = "Jobdetails.findByLastDate", query = "SELECT j FROM Jobdetails j WHERE j.lastDate = :lastDate"),
    @NamedQuery(name = "Jobdetails.findByJobType", query = "SELECT j FROM Jobdetails j WHERE j.jobType = :jobType"),
    @NamedQuery(name = "Jobdetails.findByBondYear", query = "SELECT j FROM Jobdetails j WHERE j.bondYear = :bondYear")})
public class Jobdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Details", nullable = false, length = 150)
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfVacancy", nullable = false)
    private int noOfVacancy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Package", nullable = false, length = 30)
    private String package1;
    @Column(name = "LastDate")
    @Temporal(TemporalType.DATE)
    private Date lastDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "JobType", nullable = false, length = 36)
    private String jobType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BondYear", nullable = false)
    private int bondYear;
    @ManyToMany(mappedBy = "jobdetailsCollection")
    private Collection<Register> registerCollection;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Rejected> rejectedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Inquiry> inquiryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Aptitudetest> aptitudetestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Jobskillset> jobskillsetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private Collection<Personalinterview> personalinterviewCollection;

    public Jobdetails() {
    }

    public Jobdetails(Integer id) {
        this.id = id;
    }

    public Jobdetails(String title, String details, int noOfVacancy, String package1, String jobType, int bondYear) {
        this.title = title;
        this.details = details;
        this.noOfVacancy = noOfVacancy;
        this.package1 = package1;
        this.jobType = jobType;
        this.bondYear = bondYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getNoOfVacancy() {
        return noOfVacancy;
    }

    public void setNoOfVacancy(int noOfVacancy) {
        this.noOfVacancy = noOfVacancy;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getBondYear() {
        return bondYear;
    }

    public void setBondYear(int bondYear) {
        this.bondYear = bondYear;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Register> getRegisterCollection() {
        return registerCollection;
    }

    public void setRegisterCollection(Collection<Register> registerCollection) {
        this.registerCollection = registerCollection;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
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
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Inquiry> getInquiryCollection() {
        return inquiryCollection;
    }

    public void setInquiryCollection(Collection<Inquiry> inquiryCollection) {
        this.inquiryCollection = inquiryCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Aptitudetest> getAptitudetestCollection() {
        return aptitudetestCollection;
    }

    public void setAptitudetestCollection(Collection<Aptitudetest> aptitudetestCollection) {
        this.aptitudetestCollection = aptitudetestCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Jobskillset> getJobskillsetCollection() {
        return jobskillsetCollection;
    }

    public void setJobskillsetCollection(Collection<Jobskillset> jobskillsetCollection) {
        this.jobskillsetCollection = jobskillsetCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Personalinterview> getPersonalinterviewCollection() {
        return personalinterviewCollection;
    }

    public void setPersonalinterviewCollection(Collection<Personalinterview> personalinterviewCollection) {
        this.personalinterviewCollection = personalinterviewCollection;
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
        if (!(object instanceof Jobdetails)) {
            return false;
        }
        Jobdetails other = (Jobdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jobdetails[ id=" + id + " ]";
    }
    
}
