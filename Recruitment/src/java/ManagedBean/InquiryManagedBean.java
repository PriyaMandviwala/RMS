/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import client.RecruitmentClient;
import ejb.RecruitmentLocal;
import entity.Inquiry;
import entity.Jobdetails;
import entity.Register;
import java.util.Collection;
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
@Named(value = "imb")
@ApplicationScoped
public class InquiryManagedBean {
    @EJB RecruitmentLocal rl;

    int inquiryid;
    Integer jobid;
    String username,message;
    Boolean isread;
    Inquiry inquiry;
    
    //String AddressByJob;
    Collection<Inquiry> inquirylist;
    
    Collection<Jobdetails> jobList;
    Collection<Register> userList;
    GenericType<Collection<Inquiry>> ginqs = new GenericType<Collection<Inquiry>>(){};
    Response res;
    RecruitmentClient rcl;
    /**
     * Creates a new instance of InquiryManagedBean
     */
    public InquiryManagedBean() {
    }

    public RecruitmentLocal getRl() {
        return rl;
    }

    public void setRl(RecruitmentLocal rl) {
        this.rl = rl;
    }

    public int getInquiryid() {
        return inquiryid;
    }

    public void setInquiryid(int inquiryid) {
        this.inquiryid = inquiryid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public Collection<Inquiry> getInquirylist() {
        return inquirylist;
    }

    public void setInquirylist(Collection<Inquiry> inquirylist) {
        this.inquirylist = inquirylist;
    }

    public Collection<Jobdetails> getJobList() {
        return jobList;
    }

    public void setJobList(Collection<Jobdetails> jobList) {
        this.jobList = jobList;
    }

    public Collection<Register> getUserList() {
        return userList;
    }

    public void setUserList(Collection<Register> userList) {
        this.userList = userList;
    }

    public GenericType<Collection<Inquiry>> getGinqs() {
        return ginqs;
    }

    public void setGinqs(GenericType<Collection<Inquiry>> ginqs) {
        this.ginqs = ginqs;
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

    public void setRcl(RecruitmentClient rcl) {
        this.rcl = rcl;
    }
    
    @PostConstruct
    public void init()
    {
        jobList = rl.getAllJob();
        userList= rl.getAllUser();
    }
    
    public String InsertInquiry()
    {
        return "/UserSide/AddInquiry.xhtml?faces-redirect=true";
    }
    public String addInquiry()
    {
        rl.addInquiry(message, isread, jobid, username);
        //rl.addCompany(name, password, unitid, email, contactnum, num_Employee);
        message = "";
        isread = false;
        jobid = 0;
        username="";
       
        return "/UserSide/ListInquiry.xhtml?faces-redirect=true";        
        //cbl.addProjOfEmployee(id, projsId);
    }
    
//    public void ResetData()
//    {
//        title = "";
//        details = "";
//        vacancy = 0;
//        packages="";
//        //Lastdate = "";
//        jobtype = "";
//        companyid =0;
//        bondyear = 0;
//    }
//    
    public Collection<Inquiry> ListInquiry()
    {
//        gcompany = new GenericType<Collection<Company>>() {};
//        res = rcl.getAllCompany(Response.class);
//        Collection<Company> gprodList = res.readEntity(gcompany);
//        return gprodList;
        return rl.getAllInquiry();
    }
    
    public String EditInquiry(int id)
    {              
        Inquiry iq = rl.SearchByInquiryId(id);
        this.inquiryid = iq.getId();
        jobid = iq.getJobId().getId();
        username = iq.getUserName().getUsername();
        message = iq.getMessage();
        isread = iq.getIsRead();
        
        return "/UserSide/EditInquiry.xhtml?faces-redirect=true";
    }
    
    public String updateInquiry()
    {
        rl.updateInquiry(inquiryid, message, isread, jobid, username);
        return "/UserSide/ListInquiry.xhtml?faces-redirect=true";        
    }
    
    public String deleteInquiry(int id)
    {
        rl.removeInquiry(id);
        //rcl.removeCompany(Integer.toString(id));
        return "/UserSide/ListInquiry.xhtml?faces-redirect=true";        
    }
   
}
