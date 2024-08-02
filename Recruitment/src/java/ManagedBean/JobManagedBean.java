/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import client.RecruitmentClient;
import ejb.RecruitmentLocal;
import entity.Company;
import entity.Jobdetails;
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
@Named(value = "jobManagedBean")
@ApplicationScoped
public class JobManagedBean {
 @EJB RecruitmentLocal rl;
    int jobid;
    Integer vacancy,companyid,bondyear;
    String title,details,packages,jobtype;
    Jobdetails jobdetail;
    Date Lastdate;
    String AddressByJob;
    Collection<Company> companylist;
    
    Collection<Jobdetails> job;
    GenericType<Collection<Jobdetails>> gjobs = new GenericType<Collection<Jobdetails>>(){};
    Response res;
    RecruitmentClient rcl;
    /**
     * Creates a new instance of JobManagedBean
     */
    public JobManagedBean() {
    }

    public RecruitmentLocal getRl() {
        return rl;
    }

    public void setRl(RecruitmentLocal rl) {
        this.rl = rl;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getBondyear() {
        return bondyear;
    }

    public void setBondyear(Integer bondyear) {
        this.bondyear = bondyear;
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

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public Jobdetails getJobdetail() {
        return jobdetail;
    }

    public void setJobdetail(Jobdetails jobdetail) {
        this.jobdetail = jobdetail;
    }

    public Date getLastdate() {
        return Lastdate;
    }

    public void setLastdate(Date Lastdate) {
        this.Lastdate = Lastdate;
    }

    public String getAddressByJob() {
        return AddressByJob;
    }

    public void setAddressByJob(String AddressByJob) {
        this.AddressByJob = AddressByJob;
    }

    public Collection<Company> getCompanylist() {
        return companylist;
    }

    public void setCompanylist(Collection<Company> companylist) {
        this.companylist = companylist;
    }

    public Collection<Jobdetails> getJob() {
        return job;
    }

    public void setJob(Collection<Jobdetails> job) {
        this.job = job;
    }

    public GenericType<Collection<Jobdetails>> getGjobs() {
        return gjobs;
    }

    public void setGjobs(GenericType<Collection<Jobdetails>> gjobs) {
        this.gjobs = gjobs;
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
        companylist = rl.getAllCompany();
    }
    
    public String InsertJob()
    {
        return "/AdminSide/AddJob.xhtml?faces-redirect=true";
    }
    public String addJob()
    {
        rl.addJob(title, details, vacancy, packages, Lastdate, jobtype, companyid, bondyear);
        //rl.addCompany(name, password, unitid, email, contactnum, num_Employee);
        title = "";
        details = "";
        vacancy = 0;
        packages="";
        //Lastdate = "";
        jobtype = "";
        companyid =0;
        bondyear = 0;
        return "/AdminSide/ListJob.xhtml?faces-redirect=true";        
        //cbl.addProjOfEmployee(id, projsId);
    }
    
    public void ResetData()
    {
        title = "";
        details = "";
        vacancy = 0;
        packages="";
        //Lastdate = "";
        jobtype = "";
        companyid =0;
        bondyear = 0;
    }
    
    public Collection<Jobdetails> ListJob()
    {
//        gcompany = new GenericType<Collection<Company>>() {};
//        res = rcl.getAllCompany(Response.class);
//        Collection<Company> gprodList = res.readEntity(gcompany);
//        return gprodList;
        return rl.getAllJob();
    }
    
    public String EditJob(int id)
    {              
        Jobdetails jd = rl.SearchByJobId(id);
        jobid = jd.getId();
        title = jd.getTitle();
        details = jd.getDetails();
        vacancy = jd.getNoOfVacancy();
        packages= jd.getPackage1();
        Lastdate = jd.getLastDate();
        jobtype = jd.getJobType();
        companyid = jd.getCompanyId().getId();
        bondyear = jd.getBondYear();
        return "/AdminSide/EditJob.xhtml?faces-redirect=true";
    }
    
    public String updateJob()
    {
        rl.updateJob(jobid, title, details, vacancy, packages, Lastdate, jobtype, companyid, bondyear);
        return "/AdminSide/ListJob.xhtml?faces-redirect=true";        
    }
    
    public String deleteJob(int id)
    {
        rl.removeJob(id);
        //rcl.removeCompany(Integer.toString(id));
        return "/AdminSide/ListJob.xhtml?faces-redirect=true";        
    }
    
     public String serching(String address)
    {
        rl.SearchJobByAdress(address);
        return "/AdminSide/SearchJob.xhtml?faces-redirect=true";        
    }
    
    public Collection<Jobdetails> searchListProduct()
    {
        return rl.SearchJobByAdress(AddressByJob);
    }  
    
}
