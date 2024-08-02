/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import client.RecruitmentClient;
import ejb.RecruitmentLocal;
import entity.City;
import entity.Country;
import entity.Jobdetails;
import entity.Register;
import entity.State;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "rmb")
@ApplicationScoped
public class RegisterManagedBean {
 @EJB RecruitmentLocal rl;
// int jobid;
//    Integer vacancy,companyid,bondyear;
//    String title,details,packages,jobtype;
//    Jobdetails jobdetail;
//    Date Lastdate;
//    String AddressByJob;
//    Collection<Company> companylist;
//    
//    Collection<Jobdetails> job;
//    GenericType<Collection<Jobdetails>> gjobs = new GenericType<Collection<Jobdetails>>(){};
//    Response res;
//    RecruitmentClient rcl;
    
    
    String username,Password,FirstName,Middlename,Lastname,Gender,CollegeName,CollegeEmail,HighestDegree,EmailId,Address,Level;
    Date DOB;
    Integer PhoneNumber,Pincode,CountryId,StateId,CityId;
    Register user;
    Collection<Country> countryList;
    Collection<State> stateList;
    Collection<City> cityList;
    Collection<Register> users;
    GenericType<Collection<Register>> gusers = new GenericType<Collection<Register>>(){};
    Response res;
    RecruitmentClient rcl;
    
   
    public RecruitmentLocal getRl()
    {
        return rl;
    }

    public void setRl(RecruitmentLocal rl) {
        this.rl = rl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddlename() {
        return Middlename;
    }

    public void setMiddlename(String Middlename) {
        this.Middlename = Middlename;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String CollegeName) {
        this.CollegeName = CollegeName;
    }

    public String getCollegeEmail() {
        return CollegeEmail;
    }

    public void setCollegeEmail(String CollegeEmail) {
        this.CollegeEmail = CollegeEmail;
    }

    public String getHighestDegree() {
        return HighestDegree;
    }

    public void setHighestDegree(String HighestDegree) {
        this.HighestDegree = HighestDegree;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Integer PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public Integer getPincode() {
        return Pincode;
    }

    public void setPincode(Integer Pincode) {
        this.Pincode = Pincode;
    }

    public Integer getCountryId() {
        return CountryId;
    }

    public void setCountryId(Integer CountryId) {
        this.CountryId = CountryId;
    }

    public Integer getStateId() {
        return StateId;
    }

    public void setStateId(Integer StateId) {
        this.StateId = StateId;
    }

    public Integer getCityId() {
        return CityId;
    }

    public void setCityId(Integer CityId) {
        this.CityId = CityId;
    }

    public Register getUser() {
        return user;
    }

    public void setUser(Register user) {
        this.user = user;
    }

    public Collection<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(Collection<Country> countryList) {
        this.countryList = countryList;
    }

    public Collection<State> getStateList() {
        return stateList;
    }

    public void setStateList(Collection<State> stateList) {
        this.stateList = stateList;
    }

    public Collection<City> getCityList() {
        return cityList;
    }

    public void setCityList(Collection<City> cityList) {
        this.cityList = cityList;
    }

    public Collection<Register> getUsers() {
        return users;
    }

    public void setUsers(Collection<Register> users) {
        this.users = users;
    }

    public GenericType<Collection<Register>> getGusers() {
        return gusers;
    }

    public void setGusers(GenericType<Collection<Register>> gusers) {
        this.gusers = gusers;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public RecruitmentClient getRcl() {
        return rcl;
    }

    /**
     * Creates a new instance of RegisterManagedBean
     */
    public void setRcl(RecruitmentClient rcl) {   
        this.rcl = rcl;
    }

    @PostConstruct
    public void init() {
        countryList = rl.getAllCountries();
        //stateList = rl.getAllStates();
        //cityList = rl.getAllCities();
    }
    
    public String InsertUser()
    {
        return "/AdminSide/AddUser.xhtml?faces-redirect=true";
    }
    public String addUser()
    {
        //rcl.addUser(username, Password, FirstName, Middlename, Lastname, String.valueOf(DOB), Gender,String.valueOf(PhoneNumber), CollegeName, CollegeEmail, Gender, EmailId, Address, String.valueOf(Pincode), Gender, String.valueOf(CountryId), String.valueOf(StateId), String.valueOf(CityId));
        rl.addUser(username, Password, FirstName, Middlename, Lastname, DOB, Gender, PhoneNumber, CollegeName, CollegeEmail, HighestDegree, EmailId, Address, Pincode, Level, CountryId, StateId, CityId);
        username = "";
        Password = "";
        FirstName ="";
        Middlename = "";
        Lastname = "";
        //DOB = "";
        Gender = "";
        PhoneNumber = 0;
        CollegeName = "";
        CollegeEmail = "";
        Gender = "";
        EmailId = "";
        Address = "";
        Pincode = 0;
        Level = "";
        CountryId = 0;
        StateId = 0;
        CityId = 0;
        
        return "/UserSide/ListUsers.xhtml?faces-redirect=true";        

    }
    
    public void ResetData()
    {
        username = "";
        Password = "";
        FirstName ="";
        Middlename = "";
        Lastname = "";
        //DOB = "";
        Gender = "";
        PhoneNumber = 0;
        CollegeName = "";
        CollegeEmail = "";
        Gender = "";
        EmailId = "";
        Address = "";
        Pincode = 0;
        Level = "";
        CountryId = 0;
        StateId = 0;
       
    }
    
    public Collection<Jobdetails> ListJob()
    {
//        gcompany = new GenericType<Collection<Company>>() {};
//        res = rcl.getAllCompany(Response.class);
//        Collection<Company> gprodList = res.readEntity(gcompany);
//        return gprodList;
        return rl.getAllJob();
    }
    
   
}
