/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Aptituderesult;
import entity.Aptitudetest;
import entity.City;
import entity.Company;
import entity.Companyphotos;
import entity.Companyservices;
import entity.Country;
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
import entity.State;
import entity.Telephonicinterview;
import entity.Testinstruction;
import entity.Unit;
import entity.Userskillset;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface RecruitmentLocal {
     //User
    Collection<Register> getAllUser();
    void addUser(String Username,String Password,String fname,String mname,String lname,Date dob,String gen,int phNumber,String clgName,String clgEmail,String hDegree,String email,String add,int pincode,String level,int coid,int stateid,int cid);
    void updateUser(String Username,String fname,String mname,String lname,Date dob,String gen,int phNumber,String clgName,String clgEmail,String hDegree,String email,String add,int pincode,String level,int coid,int stateid,int cid);
    void removeUser(String Username);
    
    //Job
    Collection<Jobdetails> getAllJob();
    Jobdetails SearchByJobId(int id);
    void addJob(String Title,String Details,Integer Vacancy,String Pack,Date lastDate,String jobType,Integer companyId,Integer bondYear);
    void updateJob(int Id,String Title,String Details,int Vacancy,String Package,Date lastDate,String jobType,int companyId,int bondYear);
    void removeJob(int Id);
    
    //Company
    Collection<Company> getAllCompany();
    Company SearchByCompanyId(int id);
    void addCompany(String Name,String Password,int UnitId,String Email,int ConatactNo,int NoofEmp );
    void updateCompany(int Id,String Name,String Password,int UnitId,String Email,int ConatactNo,int NoofEmp );
    void removeCompany(int Id);

    //CompanyService
    Collection<Companyservices> getAllCompanySevices();
    void addCompanyService(int ComId,String STitle,String SDescription);
    void updateCompanyService(int Id,int ComId,String STitle,String SDescription);
    void removeCompanyService(int Id);
    
    //CompanyPhotos
    Collection<Companyphotos> getAllCompanyPhotos();    
    void addCompanyPhotos(int ComId,String Image);
    void updateCompanyPhotos(int Id,int ComId,String Image);
    void removeCompanyPhotos(int Id);
    
    //Document(After Candidate is Selected ,will have to upload documents)
    Collection<Document> getAllDocument();
    void addDocuments(String username,int JobId,String File);
    void updateDocuments(int Id,String username,int JobId,String File);
    void removeDocuments(int Id);
    
    //CompanyPhotos
    Collection<Experience> getAllExperience();
    void addExperience(String Username,int NoofYr,String CompanyName,String Designation,int Salary,String ComAddress,String  ExperienceLetter);
    void updateExperience(int Id,String Username,int NoofYr,String CompanyName,String Designation,int Salary,String ComAddress,String ExperienceLetter);
    void removeExperience(int Id);
    
    //new Start
    //Inquiry
    Collection<Inquiry> getAllInquiry();
    Inquiry SearchByInquiryId(int id);
    void addInquiry(String Message,boolean IsRead,int JobId,String Username);
    void updateInquiry(int Id,String Message,boolean IsRead,int JobId,String Username);
    void removeInquiry(int Id);
    
    Collection<Jobskillset> getAllJobSkillset();
    void addJobSkillset(String Name , int jobId);
    void updateJobSkillset(int Id ,String Name , int jobId);
    void removeJobSkillset(int Id);
    
    
    Collection<Aptitudetest> getAllApptitudeTest();
    void addApptitudeTest(int jobId,String ExamName,String ExamDetails,int cutoff);
    void updateApptitudeTest(int Id ,int jobId,String ExamName,String ExamDetails,int cutoff);
    void removeApptitudeTest(int Id);
    
    Collection<Aptituderesult> getAllApptitudeResult();
    void addApptitudeResult(int ApptitudeTestId,String userName,int Marks,boolean IsSelected);
    void updateApptitudeResult(int Id ,int ApptitudeTestId,String userName,int Marks,boolean IsSelected);
    void removeApptitudeResult(int Id);
    
    //New End
    //Telephonic Interview
    Collection<Telephonicinterview> getAllTelephonic();
    void addTelephonic(int JobId,String Username,boolean IsSelected);
    void updateTelephonic(int Id,int JobId,String Username,boolean IsSelected);
    void removeTelephonic(int Id);
    
     //Personal Interview
    Collection<Personalinterview> getAllPersonalInterview();
    void addPersonalInterview(int JobId,String Username,boolean IsSelected);
    void updatePersonalInterview(int Id,int JobId,String Username,boolean IsSelected);
    void removePersonalInterview(int Id);
    
    //Rejected
    Collection<Rejected> getAllRejectedUser();
    void addRejectedUser(int JobId,String Username,int StageId);
    void updateRejectedUser(int Id,int JobId,String Username,int StageId);
    void removeRejectedUser(int Id);
    
    //Resume
    Collection<Resume> getAllResume();
    void addResume(int JobId,String Username,String ResumeFile);
    void updateResume(int Id,int JobId,String Username,String ResumeFile);
    void removeResume(int Id);
    
    //Selected Candidate
    Collection<Selectedcandidate> getAllSelectedCandidate();
    void addSelectedCandidate(int JobId,String Username,int Salary,String Designation,boolean isConfirmed);
    void updateSelectedCandidate(int Id,int JobId,String Username,int Salary,String Designation,boolean isConfirmed);
    void removeSelectedCandidate(int Id);
    
    //Instruction of ApptitudeTest
    Collection<Testinstruction> getAllTestInstruction();
    void addTestInstruction(int ApptitudeTestId,String Message);
    void updateTestInstruction(int Id,int ApptitudeTestId,String Message);
    void removeTestInstruction(int Id);
    
    //Unit
    Collection<Unit> getAllUnit();
    Unit SearchByUnitId(int id);
    void addUnit(String Name,String Address , int Zipcode, int CountryId,int StateId , int CityId);
    void updateUnit(int Id,String Name,String Address , int Zipcode, int CountryId,int StateId , int CityId);
    void removeUnit(int Id);
    
    //UserSkillSet
    Collection<Userskillset> getAllUserSkillSet();
    void addUserskillset(String SkillName,String Username);
    void updateUserskillset(int Id,String SkillName,String UserName);
    void removeUserskillset(int Id);
    
    //country.state,city get
    Collection<Country> getAllCountries();
    Collection<State> getAllStates(int cid);
    Collection<City> getAllCities(int sid);
    
    //Stage
    void addStage(String Type);
    
    
    //search by experience
    //Collection<Register> getCandidateExperience(int noOfExperience);
    
    //search by username
    Collection<Register> SearchByUserName(String UserName);   
    String getUsernamefromUser(String username) ;
    //serach by companyname
    Collection<Company> SearchByCompany(String name);
    Collection<Jobdetails> SearchByJobTitle(String Title);
    Collection<Aptitudetest> SearchByApptitudeExamName(String name);
    Collection<Aptituderesult> SearchByApptitudeMarks(int marks);
    Collection<Aptituderesult> SearchByApptitudeMarkRange(int smarks,int emarks);
    Collection<Aptituderesult> SearchByApptitudeResultSelected(boolean Isselected);
    
    Collection<Jobdetails> SearchJobByAdress(String address);
    //search by company address
    //Collection<Company> SearchByCompanyAddress(String address);
}
