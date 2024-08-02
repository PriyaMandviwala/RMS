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
import entity.State;
import entity.Unit;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "umb")
@ApplicationScoped
public class UnitManagedBean {
     @EJB RecruitmentLocal rl;

    int unitid,countryid,stateid,cityid,zipcode;
    String name,address;
    Unit unit;
//    Country country;
//    State state;
//    City city;
    Collection<Country> countryList;
    Collection<State> stateList;
    Collection<City> cityList;
    Collection<Unit> units;
    GenericType<Collection<Unit>> gunits = new GenericType<Collection<Unit>>(){};
    GenericType<Collection<Country>> gcountries = new GenericType<Collection<Country>>(){};
    GenericType<Collection<State>> gstates = new GenericType<Collection<State>>(){};
    GenericType<Collection<City>> gcities = new GenericType<Collection<City>>(){};

    Response res;
    RecruitmentClient rcl;
    /**
     * Creates a new instance of UnitManagedBean
     */
    public UnitManagedBean() {
        rcl = new RecruitmentClient();
    }

    public RecruitmentLocal getRl() {
        return rl;
    }

    public void setRl(RecruitmentLocal rl) {
        this.rl = rl;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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

    public Collection<Unit> getUnits() {
        return units;
    }

    public void setUnits(Collection<Unit> units) {
        this.units = units;
    }

    public GenericType<Collection<Unit>> getGunits() {
        return gunits;
    }

    public void setGunits(GenericType<Collection<Unit>> gunits) {
        this.gunits = gunits;
    }

    public GenericType<Collection<Country>> getGcountries() {
        return gcountries;
    }

    public void setGcountries(GenericType<Collection<Country>> gcountries) {
        this.gcountries = gcountries;
    }

    public GenericType<Collection<State>> getGstates() {
        return gstates;
    }

    public void setGstates(GenericType<Collection<State>> gstates) {
        this.gstates = gstates;
    }

    public GenericType<Collection<City>> getGcities() {
        return gcities;
    }

    public void setGcities(GenericType<Collection<City>> gcities) {
        this.gcities = gcities;
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
//        gcountries = new GenericType<Collection<Country>>() {};
//        res = rcl.getAllCountries(Response.class);
//        countryList = res.readEntity(gcountries);
//        
//        gstates = new GenericType<Collection<State>>() {};
//        res = rcl.getAllStates(Response.class);
//        stateList = res.readEntity(gstates);
//        
//        gcities = new GenericType<Collection<City>>() {};
//        res = rcl.getAllCities(Response.class);
//        cityList = res.readEntity(gcities);
//         
        countryList = rl.getAllCountries();
    }
    
     public void changeCountry(AjaxBehaviorEvent event) {
        stateList = rl.getAllStates(countryid);
        //stateid = cityid = 0;
        cityList = null;
    }
    public void changeState(AjaxBehaviorEvent event) {
        cityList = rl.getAllCities(stateid);
        //stateid = cityid = 0;
       
    }
     
    public String InsertUnit()
    {
        return "/AdminSide/AddUnit.xhtml?faces-redirect=true";
    }
    public String addUnit()
    {
        rcl.addUnit(name, address, String.valueOf(zipcode), String.valueOf(countryid), String.valueOf(stateid), String.valueOf(cityid));
        //rl.addCompany(name, password, unitid, email, contactnum, num_Employee);
        name = "";
        address = "";
        zipcode = 0;
        countryid =0;
        stateid = 0;
        cityid = 0;
        return "/AdminSide/ListUnit.xhtml?faces-redirect=true";        
        //cbl.addProjOfEmployee(id, projsId);
    }
//    
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
    public Collection<Unit> ListUnit()
    {
       gunits = new GenericType<Collection<Unit>>() {};
       res = rcl.getAllUnit(Response.class);
       Collection<Unit> gunitList = res.readEntity(gunits);
       return gunitList;
        
    }
   
    public String EditUnit(int id)
    {              
        Unit uu = rl.SearchByUnitId(id);
        this.unitid = uu.getId();
        name = uu.getName();
        address = uu.getAddress();
        countryid = uu.getCountryId().getId();
        stateid = uu.getStateId().getId();
        cityid = uu.getCityId().getId();
        zipcode = uu.getZipCode();
        return "/AdminSide/EditUnit.xhtml?faces-redirect=true";
    }
    
    public String updateUnit()
    {
        rl.updateUnit(unitid, name, address, countryid, stateid, cityid, zipcode);
        return "/AdminSide/ListUnit.xhtml?faces-redirect=true";        
    }
    
    public String deleteUnit(int id)
    {
        rl.removeUnit(id);
        //rcl.removeCompany(Integer.toString(id));
        return "/AdminSide/ListUnit.xhtml?faces-redirect=true";        
    }
//    
//     public String serching(String address)
//    {
//        rl.unit(address);
//        return "/AdminSide/SearchJob.xhtml?faces-redirect=true";        
//    }
//    
//    public Collection<Jobdetails> searchListProduct()
//    {
//        return rl.SearchJobByAdress(AddressByJob);
//    }  
//    
}
