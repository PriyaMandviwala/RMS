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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "register", catalog = "recruitementdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r"),
    @NamedQuery(name = "Register.findByUsername", query = "SELECT r FROM Register r WHERE r.username = :username"),
    @NamedQuery(name = "Register.findByPassword", query = "SELECT r FROM Register r WHERE r.password = :password"),
    @NamedQuery(name = "Register.findByFirstname", query = "SELECT r FROM Register r WHERE r.firstname = :firstname"),
    @NamedQuery(name = "Register.findByMiddlename", query = "SELECT r FROM Register r WHERE r.middlename = :middlename"),
    @NamedQuery(name = "Register.findByLastname", query = "SELECT r FROM Register r WHERE r.lastname = :lastname"),
    @NamedQuery(name = "Register.findByDob", query = "SELECT r FROM Register r WHERE r.dob = :dob"),
    @NamedQuery(name = "Register.findByGender", query = "SELECT r FROM Register r WHERE r.gender = :gender"),
    @NamedQuery(name = "Register.findByPhoneNumber", query = "SELECT r FROM Register r WHERE r.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Register.findByCollegeName", query = "SELECT r FROM Register r WHERE r.collegeName = :collegeName"),
    @NamedQuery(name = "Register.findByCollegeEmail", query = "SELECT r FROM Register r WHERE r.collegeEmail = :collegeEmail"),
    @NamedQuery(name = "Register.findByHighestDegree", query = "SELECT r FROM Register r WHERE r.highestDegree = :highestDegree"),
    @NamedQuery(name = "Register.findByEmailId", query = "SELECT r FROM Register r WHERE r.emailId = :emailId"),
    @NamedQuery(name = "Register.findByAddress", query = "SELECT r FROM Register r WHERE r.address = :address"),
    @NamedQuery(name = "Register.findByCountryId", query = "SELECT r FROM Register r WHERE r.countryId = :countryId"),
    @NamedQuery(name = "Register.findByStateId", query = "SELECT r FROM Register r WHERE r.stateId = :stateId"),
    @NamedQuery(name = "Register.findByCityId", query = "SELECT r FROM Register r WHERE r.cityId = :cityId"),
    @NamedQuery(name = "Register.findByPincode", query = "SELECT r FROM Register r WHERE r.pincode = :pincode"),
    @NamedQuery(name = "Register.findByLevel", query = "SELECT r FROM Register r WHERE r.level = :level")})
public class Register implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65535)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Middlename")
    private String middlename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PhoneNumber")
    private int phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CollegeName")
    private String collegeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CollegeEmail")
    private String collegeEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HighestDegree")
    private String highestDegree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "EmailId")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Address")
    private String address;
     @JoinColumn(name = "countryId", referencedColumnName = "Id")
    @ManyToOne
    private Country countryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Level")
    private String level;
    @JoinTable(name = "userstage", joinColumns = {
        @JoinColumn(name = "UserName", referencedColumnName = "Username")}, inverseJoinColumns = {
        @JoinColumn(name = "StageId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Stages> stagesCollection;
    @JoinTable(name = "userjob", joinColumns = {
        @JoinColumn(name = "UserName", referencedColumnName = "Username")}, inverseJoinColumns = {
        @JoinColumn(name = "JobId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Jobdetails> jobdetailsCollection;
    @JoinTable(name = "userrole", joinColumns = {
        @JoinColumn(name = "UserName", referencedColumnName = "Username")}, inverseJoinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Role> roleCollection;
    @JoinTable(name = "application", joinColumns = {
        @JoinColumn(name = "UserName", referencedColumnName = "Username")}, inverseJoinColumns = {
        @JoinColumn(name = "JobId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Jobdetails> jobdetailsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Rejected> rejectedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Aptituderesult> aptituderesultCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Experience> experienceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<Inquiry> inquiryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Selectedcandidate> selectedcandidateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Resume> resumeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Telephonicinterview> telephonicinterviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Userskillset> userskillsetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Personalinterview> personalinterviewCollection;
    @JoinColumn(name = "StateId", referencedColumnName = "Id")
    @ManyToOne
    private State stateId;
    @JoinColumn(name = "CityId", referencedColumnName = "Id")
    @ManyToOne
    private City cityId;

    public Register() {
    }

    public Register(String username) {
        this.username = username;
    }

    public Register(String username, String password, String firstname, String middlename, String lastname, String gender, int phoneNumber, String collegeName, String collegeEmail, String highestDegree, String emailId, String address, int pincode, String level) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.collegeName = collegeName;
        this.collegeEmail = collegeEmail;
        this.highestDegree = highestDegree;
        this.emailId = emailId;
        this.address = address;
        this.pincode = pincode;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Stages> getStagesCollection() {
        return stagesCollection;
    }

    public void setStagesCollection(Collection<Stages> stagesCollection) {
        this.stagesCollection = stagesCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Jobdetails> getJobdetailsCollection() {
        return jobdetailsCollection;
    }

    public void setJobdetailsCollection(Collection<Jobdetails> jobdetailsCollection) {
        this.jobdetailsCollection = jobdetailsCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Jobdetails> getJobdetailsCollection1() {
        return jobdetailsCollection1;
    }

    public void setJobdetailsCollection1(Collection<Jobdetails> jobdetailsCollection1) {
        this.jobdetailsCollection1 = jobdetailsCollection1;
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
    public Collection<Aptituderesult> getAptituderesultCollection() {
        return aptituderesultCollection;
    }

    public void setAptituderesultCollection(Collection<Aptituderesult> aptituderesultCollection) {
        this.aptituderesultCollection = aptituderesultCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Experience> getExperienceCollection() {
        return experienceCollection;
    }

    public void setExperienceCollection(Collection<Experience> experienceCollection) {
        this.experienceCollection = experienceCollection;
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
    public Collection<Selectedcandidate> getSelectedcandidateCollection() {
        return selectedcandidateCollection;
    }

    public void setSelectedcandidateCollection(Collection<Selectedcandidate> selectedcandidateCollection) {
        this.selectedcandidateCollection = selectedcandidateCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Resume> getResumeCollection() {
        return resumeCollection;
    }

    public void setResumeCollection(Collection<Resume> resumeCollection) {
        this.resumeCollection = resumeCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Telephonicinterview> getTelephonicinterviewCollection() {
        return telephonicinterviewCollection;
    }

    public void setTelephonicinterviewCollection(Collection<Telephonicinterview> telephonicinterviewCollection) {
        this.telephonicinterviewCollection = telephonicinterviewCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Userskillset> getUserskillsetCollection() {
        return userskillsetCollection;
    }

    public void setUserskillsetCollection(Collection<Userskillset> userskillsetCollection) {
        this.userskillsetCollection = userskillsetCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Personalinterview> getPersonalinterviewCollection() {
        return personalinterviewCollection;
    }

    public void setPersonalinterviewCollection(Collection<Personalinterview> personalinterviewCollection) {
        this.personalinterviewCollection = personalinterviewCollection;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Register[ username=" + username + " ]";
    }
    
}
