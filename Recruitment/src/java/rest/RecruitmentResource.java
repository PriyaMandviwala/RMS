/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.RecruitmentLocal;
import entity.Aptituderesult;
import entity.Aptitudetest;
import entity.Company;
import entity.Companyphotos;
import entity.Companyservices;
import entity.Document;
import entity.Experience;
import entity.Inquiry;
import entity.Jobdetails;
import entity.Jobskillset;
import entity.Personalinterview;
import entity.Register;
import entity.Rejected;
import entity.Resume;
import entity.Selectedcandidate;
import entity.Telephonicinterview;
import entity.Testinstruction;
import entity.Unit;
import entity.Userskillset;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("recruitmentRes")
public class RecruitmentResource {
 @EJB RecruitmentLocal rl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecruitmentResource
     */
    public RecruitmentResource() {}
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Collection<Jobdetails> getAllJob() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return em.createNamedQuery("Register.findAll").getResultList();
        return rl.getAllJob();
    }
       
    @Path("addjobofCompany/{title}/{details}/{noofvacancy}/{pack}/{lastdate}/{jobtype}/{comid}/{bondyear}")
    @POST    
    public void addjobofCompany(@PathParam("title") String Title, @PathParam("details") String Det, @PathParam("noofvacancy") Integer NOfVA, @PathParam("pack") String Packa, @PathParam("lastdate") Date lDate, @PathParam("jobtype") String jType, @PathParam("comid") Integer comId, @PathParam("bondyear") Integer byear)
    {
        //out.println("ResIn");
        rl.addJob(Title, Det, NOfVA, Packa, lDate, jType, comId, byear);
    }
    
    @Path("editjobofCompany/{id}/{title}/{details}/{noofvacancy}/{pack}/{lastdate}/{jobtype}/{comid}/{bondyear}")
    @PUT 
    public void editJobOfCompany(@PathParam("id") Integer id,@PathParam("title") String Title, @PathParam("details") String Det, @PathParam("noofvacancy") Integer NOfVA, @PathParam("pack") String Packa, @PathParam("lastdate") Date lDate, @PathParam("jobtype") String jType, @PathParam("comid") Integer comId, @PathParam("bondyear") Integer byear)
    {
        //out.println("ResIn");
        rl.updateJob(id,Title, Det, NOfVA, Packa, lDate, jType, comId, byear);
    }
   
    @Path("removeJob/{id}")
    @DELETE
    public void removeJob(@PathParam("id")int Id) {
        rl.removeJob(Id);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllCompany")
    public Collection<Company> getAllCompany() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return em.createNamedQuery("Register.findAll").getResultList();
        return rl.getAllCompany();
    }
    
    @POST
    @Path("addCompany/{name}/{passowrd}/{unitid}/{email}/{chno}/{numEmployee}")    
    public void addCompany(@PathParam("name")String Name,@PathParam("passowrd") String Password,@PathParam("unitid")int UnitId,@PathParam("email") String Email,@PathParam("chno") int ConatactNo,@PathParam("numEmployee") int NoofEmp) {
        rl.addCompany(Name, Password, UnitId, Email, ConatactNo, NoofEmp);
    }
    
    @PUT
    @Path("updateCompany/{id}/{name}/{passowrd}/{unitid}/{email}/{chno}/{numEmployee}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateCompany(@PathParam("id")int id,@PathParam("name")String Name,@PathParam("passowrd") String Password,@PathParam("unitid")int UnitId,@PathParam("email") String Email,@PathParam("chno") int ConatactNo,@PathParam("numEmployee") int NoofEmp) {
        rl.updateCompany(id, Name, Password, UnitId, Email, ConatactNo, NoofEmp);
    }
    
    @Path("removeCompany/{id}")
    @DELETE
    public void removeCompany(@PathParam("id")int Id) {
        rl.removeCompany(Id);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllCompanyServices")
    public Collection<Companyservices> getAllCompanyServices() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return em.createNamedQuery("Register.findAll").getResultList();
        return rl.getAllCompanySevices();
    }
    
    @POST
    @Path("addCompanyServices/{cid}/{stitle}/{sdesc}")    
    public void addCompanyServices(@PathParam("cid")int ComId,@PathParam("stitle") String STitle,@PathParam("sdesc") String SDescription) {
        rl.addCompanyService(ComId, STitle, SDescription);
    }
    
    @PUT
    @Path("updateCompanyServices/{csid}/{cid}/{stitle}/{sdesc}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateCompanyServices(@PathParam("csid")int CsId,@PathParam("cid")int ComId,@PathParam("stitle") String STitle,@PathParam("sdesc") String SDescription) {
        rl.updateCompanyService(CsId, ComId, STitle, SDescription);
    }
    
    @Path("removeCompanyServices/{id}")
    @DELETE
    public void removeCompanyServices(@PathParam("id")int Id) {
        rl.removeCompanyService(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllCompanyPhotos")
    public Collection<Companyphotos> getAllCompanyPhotos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return em.createNamedQuery("Register.findAll").getResultList();
        return rl.getAllCompanyPhotos();
    }
    
    @POST
    @Path("addCompanyPhotos/{cid}/{image}")    
    public void addCompanyPhotos(@PathParam("cid")int ComId,@PathParam("image") String Image) {
        rl.addCompanyPhotos(ComId, Image);
    }
    
    @PUT
    @Path("updateCompanyPhotos/{cpid}/{cid}/{image}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateCompanyPhotos(@PathParam("cpid")int CpId,@PathParam("cid")int ComId,@PathParam("image") String Image) {
        rl.updateCompanyPhotos(CpId, ComId, Image);
    }
    
    @Path("removeCompanyPhotos/{id}")
    @DELETE
    public void removeCompanyPhotos(@PathParam("id")int Id) {
        rl.removeCompanyPhotos(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllDocument")
    public Collection<Document> getAllDocument() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return em.createNamedQuery("Register.findAll").getResultList();
        return rl.getAllDocument();
    }
    
    @POST
    @Path("addDocument/{username}/{jobId}/{file}")    
    public void addDocument(@PathParam("username")String username,@PathParam("jobId") int jobid,@PathParam("file") String file) {
        rl.addDocuments(username, jobid, file);
    }
    
    @PUT
    @Path("updateDocument/{id}/{username}/{jobId}/{file}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateDocument(@PathParam("id")int docId,@PathParam("username")String username,@PathParam("jobId") int jobid,@PathParam("file") String file) {
        rl.updateDocuments(docId, username, jobid, file);
    }
    
    @Path("removeDocument/{id}")
    @DELETE
    public void removeDocument(@PathParam("id")int Id) {
        rl.removeDocuments(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllExperience")
    public Collection<Experience> getAllExperience() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rl.getAllExperience();
    }
    
    @POST
    @Path("addExperience/{username}/{NoofYr}/{CompanyName}/{Designation}/{Salary}/{ComAddress}/{ExperienceLetter}")    
    public void addExperience(@PathParam("username")String Username,@PathParam("NoofYr")int NoofYr,@PathParam("CompanyName") String CompanyName,@PathParam("Designation") String Designation,@PathParam("Salary") int Salary,@PathParam("ComAddress") String ComAddress,@PathParam("ExperienceLetter") String ExperienceLetter) {
        rl.addExperience(Username, NoofYr, CompanyName, Designation, Salary, ComAddress, ExperienceLetter);
    }
    
    @PUT
    @Path("updateExperience/{id}/{username}/{NoofYr}/{CompanyName}/{Designation}/{Salary}/{ComAddress}/{ExperienceLetter}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateExperience(@PathParam("id")int expId,@PathParam("username")String Username,@PathParam("NoofYr")int NoofYr,@PathParam("CompanyName") String CompanyName,@PathParam("Designation") String Designation,@PathParam("Salary") int Salary,@PathParam("ComAddress") String ComAddress,@PathParam("ExperienceLetter") String ExperienceLetter) {
        rl.updateExperience(expId, Username, NoofYr, CompanyName, Designation, Salary, ComAddress, ExperienceLetter);
    }
    
    @Path("removeExperience/{id}")
    @DELETE
    public void removeExperience(@PathParam("id")int Id) {
        rl.removeExperience(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllInquiry")
    public Collection<Inquiry> getAllInquiry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rl.getAllInquiry();
    }
    
    @POST
    @Path("addInquiry/{msg}/{isread}/{jobid}/{username}")    
    public void addInquiry(@PathParam("msg")String Message,@PathParam("isread") boolean IsRead,@PathParam("jobid") int JobId,@PathParam("username") String Username) {
        rl.addInquiry(Message, IsRead, JobId, Username);
    }
    
    @PUT
    @Path("updateInquiry/{id}/{msg}/{isread}/{jobid}/{username}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateInquiry(@PathParam("id")int inquiryId,@PathParam("msg")String Message,@PathParam("isread") boolean IsRead,@PathParam("jobid") int JobId,@PathParam("username") String Username) {
        rl.updateInquiry(inquiryId, Message, IsRead, JobId, Username);
    }
    
    @Path("removeInquiry/{id}")
    @DELETE
    public void removeInquiry(@PathParam("id")int Id) {
        rl.removeInquiry(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllJobSkillSet")
    public Collection<Jobskillset> GetAllJobSkillSet() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rl.getAllJobSkillset();
    }
    
    @POST
    @Path("addJobskillset/{name}/{jobid}")    
    public void addJobskillset(@PathParam("name")String Name,@PathParam("jobid") int jobId) {
        rl.addJobSkillset(Name, jobId);
    }
    
    @PUT
    @Path("updateJobskillset/{id}/{name}/{jobid}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateJobskillset(@PathParam("id")int id,@PathParam("name")String Name,@PathParam("jobid") int jobId) {
        rl.updateJobSkillset(id, Name, jobId);
    }
    
    @Path("removeJobskillset/{id}")
    @DELETE
    public void removeJobskillset(@PathParam("id")int Id) {
        rl.removeJobSkillset(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllAptitudeTest")
    public Collection<Aptitudetest> GetAllAptitudeTest() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rl.getAllApptitudeTest();
    }
    
    @POST
    @Path("addAptitudeTest/{jobid}/{examname}/{examdetail}/{cutoff}")    
    public void addAptitudeTest(@PathParam("jobid")int jobId,@PathParam("examname") String ExamName,@PathParam("examdetail") String ExamDetails,@PathParam("cutoff") int cutoff) {
        rl.addApptitudeTest(jobId, ExamName, ExamDetails, cutoff);
    }
    
    @PUT
    @Path("updateAptitudeTest/{id}/{jobid}/{examname}/{examdetail}/{cutoff}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateAptitudeTest(@PathParam("id")int id,@PathParam("jobid")int jobId,@PathParam("examname") String ExamName,@PathParam("examdetail") String ExamDetails,@PathParam("cutoff") int cutoff) {
        rl.updateApptitudeTest(id, jobId, ExamName, ExamDetails, cutoff);
    }
    
    @Path("removeAptitudeTest/{id}")
    @DELETE
    public void removeAptitudeTest(@PathParam("id")int Id) {
        rl.removeApptitudeTest(Id);
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAllAptitudeResult")
    public Collection<Aptituderesult> GetAllAptitudeResult() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rl.getAllApptitudeResult();
    }
    
    @POST
    @Path("addAptitudeResult/{ApptitudeTestId}/{userName}/{Marks}/{IsSelected}")    
    public void addAptitudeResult(@PathParam("ApptitudeTestId")int ApptitudeTestId,@PathParam("userName") String userName,@PathParam("Marks") int Marks,@PathParam("IsSelected") boolean IsSelected) {
        rl.addApptitudeResult(ApptitudeTestId, userName, Marks, IsSelected);
    }
    
    @PUT
    @Path("updateAptitudeResult/{id}/{ApptitudeTestId}/{userName}/{Marks}/{IsSelected}")    
    @Produces(MediaType.APPLICATION_JSON)   
    public void updateAptitudeResult(@PathParam("id")int id,@PathParam("ApptitudeTestId")int ApptitudeTestId,@PathParam("userName") String userName,@PathParam("Marks") int Marks,@PathParam("IsSelected") boolean IsSelected) {
        rl.updateApptitudeResult(id, ApptitudeTestId, userName, Marks, IsSelected);
    }
    
    @Path("removeAptitudeResult/{id}")
    @DELETE
    public void removeAptitudeResult(@PathParam("id")int Id) {
        rl.removeApptitudeResult(Id);
    }
    
    @Path("addStage/{type}")
    @POST
    public void addStages(@PathParam("type") String stype){
        rl.addStage(stype);
    }
      
    @GET
    @Path("allpersonalinterview")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Personalinterview> getAllPersonalinterview() {
        return rl.getAllPersonalInterview();
    }
    
    @POST  
    @Path("addPersonalInterview/{jobId}/{userName}/{isSelected}")
    public void addPersonalInterview(@PathParam("jobId") Integer JobId, @PathParam("userName") String UserName, @PathParam("isSelected") Boolean IsSelected)
    {
        rl.addPersonalInterview(JobId, UserName,IsSelected);
    }
    
      
    @Path("editPersonalInterview/{id}/{jobId}/{userName}/{isSelected}")
    @PUT
    public void editPersonalInterview(@PathParam("id")Integer id,@PathParam("jobId") Integer jobId, @PathParam("userName")String userName,@PathParam("isSelected")Boolean isSelected) {
        rl.updatePersonalInterview(id,jobId, userName, isSelected);
    }
    
    @Path("rempersonalinterview/{id}")
    @DELETE    
    public void removePersonalInterview(@PathParam("id") Integer personalInterviewId) {
    rl.removePersonalInterview(personalInterviewId);
    }
    
    @GET
    @Path("alluser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Register> getAllUser() {
       return rl.getAllUser();
    }
    
    @GET
    @Path("searchbyusername/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Register> SerachByUserName(@PathParam("username") String UserName) {
       return rl.SearchByUserName(UserName);
    }
    
    @GET
    @Path("searchbycompany/{companyname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Company> SearchByCompanyName(@PathParam("companyname") String CompanyName) {
       return rl.SearchByCompany(CompanyName);
    }
    
    @GET
    @Path("searchbyjobtitle/{jobtitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Jobdetails> SearchByJobTitle(@PathParam("jobtitle") String JobTitle) {
       return rl.SearchByJobTitle(JobTitle);
    }
    
    @GET
    @Path("searchbyjobid/{jobid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Jobdetails SearchByJobId(@PathParam("jobid") Integer JobId) {
       return rl.SearchByJobId(JobId);
    }
    
    @GET
    @Path("searchbyunitid/{unitid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Unit SearchByUnitId(@PathParam("unitid") Integer unitId) {
       return rl.SearchByUnitId(unitId);
    }
    
    @GET
    @Path("searchbyaptitudeexamname/{examname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Aptitudetest> SearchByApptitudeExamName(@PathParam("examname") String examName) {
       return rl.SearchByApptitudeExamName(examName);
    }
    
    @GET
    @Path("searchbyaptitudemarks/{marks}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Aptituderesult> SearchByApptitudeMarks(@PathParam("marks") Integer marks) {
       return rl.SearchByApptitudeMarks(marks);
    }
    
    @GET
    @Path("searchbyaptitudemarkrange/{smarks}/{emarks}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Aptituderesult> SearchByApptitudeMarkRange(@PathParam("smarks") Integer smarks,@PathParam("emarks") Integer emarks) {
       return rl.SearchByApptitudeMarkRange(smarks,emarks);
    }
    
    @GET
    @Path("searchbyaptituderesultselected/{isselected}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Aptituderesult> SearchByApptitudeResultSelected(@PathParam("isselected") Boolean isSelected) {
       return rl.SearchByApptitudeResultSelected(isSelected);
    }
    
    @GET
    @Path("searchjobbyaddress/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Jobdetails> SearchJobByAddress(@PathParam("address") String address) {
       return rl.SearchJobByAdress(address);
    }
    
    @POST  
    @Path("addUser/{username}/{password}/{firstname}/{middlename}/{lastname}/{dob}/{gender}/{phoneno}/{collegename}/{collegeemail}/{highestdegree}/{emailid}/{address}/{pincode}/{level}/{countryid}/{stateid}/{cityid}")
    public void addUser(@PathParam("username") String UserName, @PathParam("password") String Password, @PathParam("firstname") String firstName,@PathParam("middlename") String middleName,@PathParam("lastname") String lastName,@PathParam("dob") Date dob,@PathParam("gender") String gender,@PathParam("phoneno") Integer phno,@PathParam("collegename") String clgname,@PathParam("collegeemail") String clgemail,@PathParam("highestdegree") String highestDegree,@PathParam("emailid") String email,@PathParam("address") String address,@PathParam("pincode") Integer pincode,@PathParam("level")String level,@PathParam("countryid") Integer country,@PathParam("stateid") Integer state,@PathParam("cityid") Integer city)
    {
        rl.addUser(UserName, Password, clgname, clgname, clgname, dob, gender, phno, clgname, clgemail, level, email, address, pincode, level, country, state, city);
    }
    
    @Path("editUser/{username}/{password}/{firstname}/{middlename}/{lastname}/{dob}/{gender}/{phoneno}/{collegename}/{collegeemail}/{highestdegree}/{emailid}/{address}/{pincode}/{level}/{countryid}/{stateid}/{cityid}")
    @PUT
    public void editUser(@PathParam("username") String UserName, @PathParam("password") String Password, @PathParam("firstname") String firstName,@PathParam("middlename") String middleName,@PathParam("lastname") String lastName,@PathParam("dob") Date dob,@PathParam("gender") String gender,@PathParam("phoneno") Integer phno,@PathParam("collegename") String clgname,@PathParam("collegeemail") String clgemail,@PathParam("highestdegree") String highestDegree,@PathParam("emailid") String email,@PathParam("address") String address,@PathParam("pincode") Integer pincode,@PathParam("level")String level,@PathParam("countryid") Integer country,@PathParam("stateid") Integer state,@PathParam("cityid") Integer city) {
        rl.updateUser(UserName, clgname, clgname, clgname, dob, gender, phno, clgname, clgemail, level, email, address, pincode, level, country, state, city);
    }
    
    @Path("remuser/{id}")
    @DELETE    
    public void removeUser(@PathParam("id") String userName) {
    rl.removeUser(userName);
    }
    
    @GET
    @Path("allrejecteduser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Rejected> getAllRejectedUser() {
       return rl.getAllRejectedUser();
    }
    
    @POST  
    @Path("addrejecteduser/{jobid}/{username}/{stageid}")
    public void addRejectedUser(@PathParam("jobid") Integer jobId, @PathParam("username") String userName, @PathParam("stageid") Integer stageId)
    {
        rl.addRejectedUser(jobId, userName, stageId);
    }
    
    @PUT  
    @Path("editrejecteduser/{id}/{jobid}/{username}/{stageid}")
    public void updateRejectedUser(@PathParam("id") Integer id,@PathParam("jobid") Integer jobId, @PathParam("username") String userName, @PathParam("stageid") Integer stageId)
    {
        rl.updateRejectedUser(id, jobId, userName, stageId);
    }
   
     
    @Path("remejecteduser/{id}")
    @DELETE    
    public void removeRejectedUser(@PathParam("id") Integer id) {
    rl.removeRejectedUser(id);
    }
    
    @GET
    @Path("allresume")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Resume> getAllResume() {
       return rl.getAllResume();
    }
    
    @POST  
    @Path("addresume/{jobid}/{username}/{resumefile}")
    public void addResume(@PathParam("jobid") Integer jobId, @PathParam("username") String userName, @PathParam("resumefile") String resumeFile)
    {
        rl.addResume(jobId, userName, resumeFile);
    }
    
    @PUT  
    @Path("editresume/{id}/{jobid}/{username}/{resumefile}")
    public void updateResume(@PathParam("id") Integer id,@PathParam("jobid") Integer jobId, @PathParam("username") String userName, @PathParam("resumefile") String resumeFile)
    {
        rl.updateResume(id,jobId, userName, resumeFile);
    }
    
    @Path("removeresume/{id}")
    @DELETE    
    public void removeResume(@PathParam("id") Integer id) {
    rl.removeResume(id);
    }
    
    @GET
    @Path("allselectedcandidate")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Selectedcandidate> getAllSelectedCandidate() {
       return rl.getAllSelectedCandidate();
    }
    
    @POST  
    @Path("addselectedcandidate/{jobid}/{username}/{salary}/{designation}/{isconfirmed}")
    public void addSelectedCandidate(@PathParam("jobid") Integer jobId, @PathParam("username") String userName,@PathParam("salary") Integer Salary,  @PathParam("designation") String Designation,@PathParam("isconfirmed")Boolean isConfirmed)
    {
        rl.addSelectedCandidate(jobId, userName, Salary, Designation, isConfirmed);
    }
    
    @PUT  
    @Path("editselectedcandidate/{id}/{jobid}/{username}/{salary}/{designation}/{isconfirmed}")
    public void editSelectedCandidate(@PathParam("id") Integer id,@PathParam("jobid") Integer jobId, @PathParam("username") String userName,@PathParam("salary") Integer Salary,  @PathParam("designation") String Designation,@PathParam("isconfirmed")Boolean isConfirmed)
    {
        rl.updateSelectedCandidate(id,jobId, userName, Salary, Designation, isConfirmed);
    }
      
    @Path("remselectedcandidate/{id}")
    @DELETE    
    public void removeSelectedCandidate(@PathParam("id") Integer id) {
    rl.removeSelectedCandidate(id);
    }
    
    @GET
    @Path("alltelephonic")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Telephonicinterview> getAllTelephonic() {
       return rl.getAllTelephonic();
    }
    
    @POST  
    @Path("addtelephonic/{jobid}/{username}/{isselected}")
    public void addTelephonic(@PathParam("jobid") Integer jobId, @PathParam("username") String userName,@PathParam("isselected")Boolean isSelected)
    {
        rl.addTelephonic(jobId, userName, isSelected);
    }
    
    @PUT  
    @Path("edittelephonic/{id}/{jobid}/{username}/{isselected}")
    public void updateTelephonic(@PathParam("id") Integer id,@PathParam("jobid") Integer jobId, @PathParam("username") String userName,@PathParam("isselected")Boolean isSelected)
    {
        rl.updateTelephonic(id,jobId, userName, isSelected);
    }
    
    @Path("remtelephonic/{id}")
    @DELETE    
    public void removeTelephonic(@PathParam("id") Integer id) {
    rl.removeTelephonic(id);
    }
    
    @GET
    @Path("alltestinstruction")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Testinstruction> getAllTestInstruction() {
       return rl.getAllTestInstruction();
    }
    
    @POST  
    @Path("addtestinstruction/{apttestid}/{message}")
    public void addTestInstruction(@PathParam("apttestid") Integer aptitudeTestId, @PathParam("message") String message)
    {
        rl.addTestInstruction(aptitudeTestId, message);
    }
    
    @PUT  
    @Path("edittestinstruction/{id}/{apttestid}/{message}")
    public void updateTestInstruction(@PathParam("id") Integer id,@PathParam("apttestid") Integer aptitudeTestId, @PathParam("message") String message)
    {
        rl.updateTestInstruction(id,aptitudeTestId, message);
    }
    
    @Path("remtestinstruction/{id}")
    @DELETE    
    public void removeTestInstruction(@PathParam("id") Integer id) {
    rl.removeTestInstruction(id);
    }
    
    
    @GET
    @Path("allunit")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Unit> getAllUnit() {
       return rl.getAllUnit();
    }
    
    @POST  
    @Path("addunit/{name}/{address}/{zipcode}/{countryid}/{stateid}/{cityid}")
    public void addUnit(@PathParam("name") String unitName, @PathParam("address") String address,@PathParam("zipcode") Integer zipCode,@PathParam("countryid") Integer countryId,@PathParam("stateid") Integer stateId,@PathParam("cityid") Integer cityId)
    {
        rl.addUnit(unitName, address, zipCode, countryId, stateId, cityId);
    }
    
    @PUT 
    @Path("editunit/{id}/{name}/{address}/{zipcode}/{countryid}/{stateid}/{cityid}")
    public void updateUnit(@PathParam("id") Integer id,@PathParam("name") String unitName, @PathParam("address") String address,@PathParam("zipcode") Integer zipCode,@PathParam("countryid") Integer countryId,@PathParam("stateid") Integer stateId,@PathParam("cityid") Integer cityId)
    {
        rl.updateUnit(id,unitName, address, zipCode, countryId, stateId, cityId);
    }
    
    @Path("remunit/{id}")
    @DELETE    
    public void removeUnit(@PathParam("id") Integer id) {
    rl.removeUnit(id);
    }
    
      
    @GET
    @Path("alluserskillset")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Userskillset> getAllUserSkillSet() {
       return rl.getAllUserSkillSet();
    }
    
    @POST  
    @Path("adduserskillset/{skillname}/{username}")
    public void addUserSkillSet(@PathParam("skillname") String skillName, @PathParam("username") String userName)
    {
        rl.addUserskillset(skillName, userName);
    }
    
    @PUT  
    @Path("edituserskillset/{skillname}/{username}")
    public void updateUserSkillSet(@PathParam("id") Integer id,@PathParam("skillname") String skillName, @PathParam("username") String userName)
    {
        rl.updateUserskillset(id,skillName, userName);
    }
    
    @Path("remuserskillset/{id}")
    @DELETE    
    public void removeUserSkillSet(@PathParam("id") Integer id) {
    rl.removeUserskillset(id);
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getallcountry")
//    public Collection<Country> getAllCountries() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return rl.getAllCountries();
//    }
//    
//      
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getallstate")
//    public Collection<State> getAllStates() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        //return rl.getAllStates();
//    }
//      
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getallcity")
//    public Collection<City> getAllCities() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return rl.getAllCities();
//    }
}
