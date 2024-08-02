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
@Table(name = "resume", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resume.findAll", query = "SELECT r FROM Resume r"),
    @NamedQuery(name = "Resume.findById", query = "SELECT r FROM Resume r WHERE r.id = :id"),
    @NamedQuery(name = "Resume.findByUsername", query = "SELECT r FROM Resume r WHERE r.username = :username"),
    @NamedQuery(name = "Resume.findByJobId", query = "SELECT r FROM Resume r WHERE r.jobId = :jobId"),
    @NamedQuery(name = "Resume.findByResumeFile", query = "SELECT r FROM Resume r WHERE r.resumeFile = :resumeFile")})
public class Resume implements Serializable {
 private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ResumeFile")
    private String resumeFile;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Register username;
    @JoinColumn(name = "JobId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Jobdetails jobId;

    public Resume() {
    }

    public Resume(Integer id) {
        this.id = id;
    }

    public Resume(String resumeFile) {        
        this.resumeFile = resumeFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(String resumeFile) {
        this.resumeFile = resumeFile;
    }

    public Register getUsername() {
        return username;
    }

    public void setUsername(Register username) {
        this.username = username;
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
        if (!(object instanceof Resume)) {
            return false;
        }
        Resume other = (Resume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Resume[ id=" + id + " ]";
    }
    
}
