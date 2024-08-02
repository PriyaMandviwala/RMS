/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import client.RecruitmentClient;
import ejb.RecruitmentLocal;
import entity.Company;
import entity.Unit;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "cmb")
@Dependent
public class CompanyManagedBean {
 @EJB RecruitmentLocal rl;
    int companyid;
    String name,password,email;
    int unitid,contactnum,num_Employee;
    Collection<Unit> unitList;
    String companyname;
    
    Collection<Company> companyList;
    GenericType<Collection<Company>> gcompany;
    Response res;
    RecruitmentClient rcl = new RecruitmentClient();;
    Company company;
    /**
     * Creates a new instance of CompanyManagedBean
     */
    public CompanyManagedBean() {
    }

    public RecruitmentLocal getRl() {
        return rl;
    }

    public void setRl(RecruitmentLocal rl) {
        this.rl = rl;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public int getContactnum() {
        return contactnum;
    }

    public void setContactnum(int contactnum) {
        this.contactnum = contactnum;
    }

    public int getNum_Employee() {
        return num_Employee;
    }

    public void setNum_Employee(int num_Employee) {
        this.num_Employee = num_Employee;
    }

    public Collection<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(Collection<Unit> unitList) {
        this.unitList = unitList;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Collection<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(Collection<Company> companyList) {
        this.companyList = companyList;
    }

    public GenericType<Collection<Company>> getGcompany() {
        return gcompany;
    }

    public void setGcompany(GenericType<Collection<Company>> gcompany) {
        this.gcompany = gcompany;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
      
    @PostConstruct
    public void init()
    {
        unitList = rl.getAllUnit();
    }
    
    public String InsertCompany()
    {
        return "/AdminSide/AddCompanu.xhtml?faces-redirect=true";
    }
    public String addCompany()
    {
        rcl.addCompany(name, password, String.valueOf(unitid), email, String.valueOf(contactnum), String.valueOf(num_Employee));
        //rl.addCompany(name, password, unitid, email, contactnum, num_Employee);
        name="";
        password = "";
        email="";
        contactnum=0;
        num_Employee=0;
        return "/AdminSide/ListCompany.xhtml?faces-redirect=true";        
        //cbl.addProjOfEmployee(id, projsId);
    }
    
    public void ResetData()
    {
        name="";
        password = "";
        email="";
        contactnum=0;
        num_Employee=0;
    }
    
    public Collection<Company> ListCompany()
    {
        gcompany = new GenericType<Collection<Company>>() {};
        res = rcl.getAllCompany(Response.class);
        Collection<Company> gprodList = res.readEntity(gcompany);
        return gprodList;
//        return rl.getAllCompany();
    }
    
    public String EditCompany(int id)
    {              
        Company com = rl.SearchByCompanyId(id);
        companyid = com.getId();
        
        name = com.getName();
        password = com.getPassword();
        unitid = com.getUnitId().getId();
        email = com.getEmail();
        contactnum = com.getContactNumber();
        num_Employee = com.getNoOfEmployee();
        return "/AdminSide/EditCompany.xhtml?faces-redirect=true";
    }
    
    public String updateCompany()
    {
        rl.updateCompany(companyid, name, password, unitid, email, contactnum, num_Employee);
        return "/AdminSide/ListCompany.xhtml?faces-redirect=true";
    }
    
    public String deleteCompany(int id)
    {
        rl.removeCompany(id);
        //rcl.removeCompany(Integer.toString(id));
        return "/AdminSide/ListCompany.xhtml?faces-redirect=true";
    }    
    public String serching(String name)
    {
        rl.SearchByCompany(name);
        return "/AdminSide/SearchCompany.xhtml?faces-redirect=true";        
    }
    
    public Collection<Company> searchListCompany()
    {
        return rl.SearchByCompany(companyname);
    }  
}
