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
@Table(name = "document", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByFiles", query = "SELECT d FROM Document d WHERE d.files = :files")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Files", nullable = false, length = 30)
    private String files;
    @JoinColumn(name = "JobId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Jobdetails jobId;
    @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false)
    @ManyToOne(optional = false)
    private Register username;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(String files) {
        this.files = files;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Jobdetails getJobId() {
        return jobId;
    }

    public void setJobId(Jobdetails jobId) {
        this.jobId = jobId;
    }

    public Register getUsername() {
        return username;
    }

    public void setUsername(Register username) {
        this.username = username;
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Document[ id=" + id + " ]";
    }
    
}
