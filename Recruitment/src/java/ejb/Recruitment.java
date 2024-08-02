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
import entity.Stages;
import entity.State;
import entity.Telephonicinterview;
import entity.Testinstruction;
import entity.Unit;
import entity.Userskillset;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author admin
 */
@Stateless
public class Recruitment implements RecruitmentLocal {
 @PersistenceContext(unitName = "RecruitmentPU")
//    Pbkdf2PasswordHashImpl pb;
    EntityManager em;
    String uname;
    @Override
    public Collection<Register> getAllUser() {
        return em.createNamedQuery("Register.findAll").getResultList();
    }

    @Override
    public void addUser(String Username, String Password, String fname, String mname, String lname, Date dob, String gen, int phNumber, String clgName, String clgEmail, String hDegree, String email, String add, int pincode, String level, int coid, int stateid, int cid) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         pb = new Pbkdf2PasswordHashImpl();
//         Register reg = new Register(Username,pb.generate(Password.toCharArray()),fname,mname,lname,gen,phNumber,clgName,clgEmail,hDegree,email,add,pincode,level);
//        Country country = em.find(Country.class, coid);
//        Collection<Register> registercountry = country.getRegisterCollection();
//        State s = em.find(State.class, stateid);
//        Collection<Register> registerState = s.getRegisterCollection();
//        City c = em.find(City.class, cid);
//        Collection<Register> registerCity = c.getRegisterCollection();
//        
//        reg.setDob(dob);
//        reg.setCountryId(country);
//        reg.setStateId(s);
//        reg.setCityId(c);
//        
//        registercountry.add(reg);
//        country.setRegisterCollection(registercountry);
//        registerState.add(reg);
//        s.setRegisterCollection(registerState);
//        registerCity.add(reg);
//        c.setRegisterCollection(registerCity);
//        
//        em.persist(reg);
//        em.merge(country);
//        em.merge(s);
//        em.merge(c);
    }

    @Override
    public void updateUser(String Username, String fname, String mname, String lname, Date dob, String gen, int phNumber, String clgName, String clgEmail, String hDegree, String email, String add, int pincode, String level, int coid, int stateid, int cid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Register reg = (Register) em.find(Register.class, Username);        
        Country country = em.find(Country.class, coid);
        Collection<Register> registercountry = country.getRegisterCollection();
        State s = em.find(State.class, stateid);
        Collection<Register> registerState = s.getRegisterCollection();
        City c = em.find(City.class, cid);
        Collection<Register> registerCity = c.getRegisterCollection();
        
        reg.setUsername(Username);
        reg.setFirstname(fname);
        reg.setMiddlename(mname);
        reg.setLastname(lname);
        reg.setDob(dob);
        reg.setGender(gen);
        reg.setPhoneNumber(phNumber);
        reg.setCollegeName(clgName);
        reg.setCollegeEmail(clgEmail);
        reg.setHighestDegree(hDegree);
        reg.setEmailId(email);
        reg.setAddress(add);
        reg.setPincode(pincode);
        reg.setLevel(level);
        reg.setCountryId(country);
        reg.setStateId(s);
        reg.setCityId(c);
        
        registercountry.add(reg);
        country.setRegisterCollection(registercountry);
        registerState.add(reg);
        s.setRegisterCollection(registerState);
        registerCity.add(reg);
        c.setRegisterCollection(registerCity);
        
        em.merge(reg);
        em.merge(country);
        em.merge(s);
        em.merge(c);
    }

    @Override
    public void removeUser(String Username) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Register reg = (Register) em.find(Register.class, Username);
        em.remove(reg);
    }

    @Override
    public Collection<Jobdetails> getAllJob() {
         return em.createNamedQuery("Jobdetails.findAll").getResultList();
    }

    @Override
    public Jobdetails SearchByJobId(int id) {
        Jobdetails jobs = em.find(Jobdetails.class, id);
        return  jobs;
    }

    @Override
    public void addJob(String Title, String Details, Integer Vacancy, String Pack, Date lastDate, String jobType, Integer companyId, Integer bondYear) {
        //out.println("SessionBean");
        Jobdetails job = new Jobdetails(Title,Details,Vacancy,Pack,jobType,bondYear);
        Company c = em.find(Company.class,companyId );
        Collection<Jobdetails> jobs = c.getJobdetailsCollection();
        
        job.setCompanyId(c);
        job.setLastDate(lastDate);
        
        jobs.add(job);
        c.setJobdetailsCollection(jobs);
        em.persist(job);
        em.merge(c);
    }

    @Override
    public void updateJob(int Id, String Title, String Details, int Vacancy, String Pack, Date lastDate, String jobType, int companyId, int bondYear) {
          Jobdetails job = (Jobdetails) em.find(Jobdetails.class, Id);        
        Company c = em.find(Company.class,companyId );
        Collection<Jobdetails> jobs = c.getJobdetailsCollection();
        
        job.setTitle(Title);
        job.setDetails(Details);
        job.setNoOfVacancy(Vacancy);
        job.setPackage1(Pack);
        job.setLastDate(lastDate);
        job.setJobType(jobType);
        job.setCompanyId(c);
        job.setBondYear(bondYear);
        
        jobs.add(job);
        c.setJobdetailsCollection(jobs);
        em.merge(job);
        em.merge(c);
    }

    @Override
    public void removeJob(int Id) {
        Jobdetails job = (Jobdetails) em.find(Jobdetails.class, Id);        
        em.remove(job);
    }

    @Override
    public Collection<Company> getAllCompany() {
       return em.createNamedQuery("Company.findAll").getResultList();
    }

    @Override
    public Company SearchByCompanyId(int id) {
        Company company = em.find(Company.class, id);
        return company;
    }

    @Override
    public void addCompany(String Name, String Password, int UnitId, String Email, int ConatactNo, int NoofEmp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Company c = new Company(Name,Password,Email,ConatactNo,NoofEmp);
        Unit unit = em.find(Unit.class, UnitId);
        Collection<Company> companycoll = unit.getCompanyCollection();
        c.setUnitId(unit);
        
        companycoll.add(c);
        unit.setCompanyCollection(companycoll);
        em.persist(c);
        em.merge(unit);
    }

    @Override
    public void updateCompany(int Id, String Name, String Password, int UnitId, String Email, int ConatactNo, int NoofEmp) {
         Company com = (Company)em.find(Company.class,Id);
        Unit unit = (Unit)em.find(Unit.class,UnitId);
        Collection<Company> companycoll = unit.getCompanyCollection();        
        //out.println(com);
        com.setName(Name);
        com.setPassword(Password);
        com.setEmail(Email);
        com.setContactNumber(ConatactNo);
        com.setNoOfEmployee(NoofEmp);
        com.setUnitId(unit);
        
        
        companycoll.add(com);
        unit.setCompanyCollection(companycoll);
        em.merge(com);
        em.merge(unit);
    }

    @Override
    public void removeCompany(int Id) {
        Company com = (Company)em.find(Company.class,Id);
        em.remove(com);
    }

    @Override
    public Collection<Companyservices> getAllCompanySevices() {
        return em.createNamedQuery("Companyservices.findAll").getResultList();
    }

    @Override
    public void addCompanyService(int ComId, String STitle, String SDescription) {
         Companyservices cs = new Companyservices(STitle,SDescription);
        Company company = (Company)em.find(Company.class,ComId);
        Collection<Companyservices> ServiceColl = company.getCompanyservicesCollection();
        
        cs.setCompanyId(company);
        
        ServiceColl.add(cs);
        company.setCompanyservicesCollection(ServiceColl);
        em.persist(cs);
        em.merge(company);
    }

    @Override
    public void updateCompanyService(int Id, int ComId, String STitle, String SDescription) {
         Companyservices cs = (Companyservices)em.find(Companyservices.class,Id);
       Company com = (Company)em.find(Company.class,ComId);
       Collection<Companyservices> ServiceColl = com.getCompanyservicesCollection();
       cs.setCompanyId(com);
       cs.setServiceTitle(STitle);
       cs.setServiceDescription(SDescription);
       
       ServiceColl.add(cs);
       com.setCompanyservicesCollection(ServiceColl);
       
       em.merge(cs);
       em.merge(com);
    }

    @Override
    public void removeCompanyService(int Id) {
          Companyservices cs = (Companyservices)em.find(Companyservices.class,Id);
        em.remove(cs);
    }

    @Override
    public Collection<Companyphotos> getAllCompanyPhotos() {
        return em.createNamedQuery("Companyphotos.findAll").getResultList();
    }

    @Override
    public void addCompanyPhotos(int ComId, String Image) {
         Companyphotos cs = new Companyphotos(Image);
        Company company = (Company)em.find(Company.class,ComId);
        Collection<Companyphotos> photosColl  = company.getCompanyphotosCollection();
        cs.setCompanyId(company);
        
        photosColl.add(cs);
        company.setCompanyphotosCollection(photosColl);
        em.persist(cs);
        em.merge(company);
    }

    @Override
    public void updateCompanyPhotos(int Id, int ComId, String Image) {
         Companyphotos cp = (Companyphotos)em.find(Companyphotos.class,Id);
       Company com = (Company)em.find(Company.class,ComId);
       Collection<Companyphotos> photosColl  = com.getCompanyphotosCollection();
       cp.setCompanyId(com);
       cp.setImage(Image);       
       
        photosColl.add(cp);
        com.setCompanyphotosCollection(photosColl);
        em.merge(cp);
        em.merge(com);
    }

    @Override
    public void removeCompanyPhotos(int Id) {
          //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Companyphotos cp = (Companyphotos)em.find(Companyphotos.class,Id);
        em.remove(cp);
    }

    @Override
    public Collection<Document> getAllDocument() {
       return em.createNamedQuery("Document.findAll").getResultList();
    }

    @Override
    public void addDocuments(String username, int JobId, String File) {
        Document d = new Document(File);
        Register reg = (Register) em.find(Register.class, username);
        Collection<Document> docColl = reg.getDocumentCollection();
        
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        Collection<Document> jobColl = job.getDocumentCollection();
        
        d.setUsername(reg);
        d.setJobId(job);
        
        docColl.add(d);
        reg.setDocumentCollection(docColl);
        jobColl.add(d);
        job.setDocumentCollection(docColl);
        em.persist(d);
        em.merge(reg);
        em.merge(job);
    }

    @Override
    public void updateDocuments(int Id, String username, int JobId, String File) {
        Register reg = (Register) em.find(Register.class, username);
        Collection<Document> docColl = reg.getDocumentCollection();
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        
        Document docu = (Document) em.find(Document.class,Id);
        Collection<Document> jobColl = job.getDocumentCollection();
        docu.setUsername(reg);
        docu.setJobId(job);
        docu.setFiles(File);
        
        
        docColl.add(docu);
        reg.setDocumentCollection(docColl);
        jobColl.add(docu);
        job.setDocumentCollection(docColl);
        em.merge(docu);
        em.merge(reg);
        em.merge(job);
    }

    @Override
    public void removeDocuments(int Id) {
         Document docu = (Document) em.find(Document.class,Id);
        em.remove(docu);
    }

    @Override
    public Collection<Experience> getAllExperience() {
       return em.createNamedQuery("Experience.findAll").getResultList();
    }

    @Override
    public void addExperience(String Username, int NoofYr, String CompanyName, String Designation, int Salary, String ComAddress, String ExperienceLetter) {
        Experience exp = new Experience(NoofYr,CompanyName,Designation,Salary,ComAddress,ExperienceLetter);
        Register reg = (Register) em.find(Register.class, Username);
        Collection<Experience> expColl = reg.getExperienceCollection();
        
        exp.setUsername(reg);
        expColl.add(exp);
        reg.setExperienceCollection(expColl);
        
        em.persist(exp);
        em.merge(reg);
    }

    @Override
    public void updateExperience(int Id, String Username, int NoofYr, String CompanyName, String Designation, int Salary, String ComAddress, String ExperienceLetter) {
       Register reg = (Register) em.find(Register.class, Username);
        Experience exp = (Experience) em.find(Experience.class, Id);
        Collection<Experience> expColl = reg.getExperienceCollection();
        
        exp.setNoOfYears(NoofYr);
        exp.setCompanyName(CompanyName);
        exp.setCompanyAddress(ComAddress);
        exp.setDesignation(Designation);
        exp.setUsername(reg);
        exp.setSalary(Salary);
        exp.setExperienceLetter(ExperienceLetter);
        expColl.add(exp);
        reg.setExperienceCollection(expColl);
        em.merge(exp);
        em.merge(reg);
    }

    @Override
    public void removeExperience(int Id) {
        Experience exp = (Experience) em.find(Experience.class, Id);
        em.remove(exp);
    }

    @Override
    public Collection<Inquiry> getAllInquiry() {
       return em.createNamedQuery("Inquiry.findAll").getResultList();
    }

    @Override
    public void addInquiry(String Message, boolean IsRead, int JobId, String Username) {
         Inquiry ti = new Inquiry(Message,IsRead);
        Register reg = (Register) em.find(Register.class, Username);
        Collection<Inquiry> inquiryReg = reg.getInquiryCollection();
        
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        Collection<Inquiry> inquiryJob = job.getInquiryCollection();
        
        ti.setJobId(job);
        ti.setUserName(reg);
        
        inquiryReg.add(ti);
        reg.setInquiryCollection(inquiryReg);
        
        inquiryJob.add(ti);
        job.setInquiryCollection(inquiryJob);
        em.persist(ti);
        
        em.merge(reg);
        em.merge(job);
    }

    @Override
    public void updateInquiry(int Id, String Message, boolean IsRead, int JobId, String Username) {
          Inquiry inquiry = (Inquiry) em.find(Inquiry.class, Id);
        Register reg = (Register) em.find(Register.class, Username);
        Collection<Inquiry> inquiryReg = reg.getInquiryCollection();
        
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        Collection<Inquiry> inquiryJob = job.getInquiryCollection();
        
        inquiry.setJobId(job);
        inquiry.setUserName(reg);
        inquiry.setMessage(Message);
        inquiry.setIsRead(IsRead);
        
        inquiryReg.add(inquiry);
        reg.setInquiryCollection(inquiryReg);
        
        inquiryJob.add(inquiry);
        job.setInquiryCollection(inquiryJob);
        
        em.merge(inquiry);
        em.merge(reg);
        em.merge(job);
    }

    @Override
    public void removeInquiry(int Id) {
        Inquiry inquiry = (Inquiry) em.find(Inquiry.class, Id);
        em.remove(inquiry);
    }

    @Override
    public Collection<Jobskillset> getAllJobSkillset() {
        return em.createNamedQuery("Jobskillset.findAll").getResultList();
    }

    @Override
    public void addJobSkillset(String Name, int jobId) {
      Jobskillset jss = new Jobskillset(Name);
        Jobdetails j = em.find(Jobdetails.class, jobId);
        Collection<Jobskillset> jobSkillColl = j.getJobskillsetCollection();
        jss.setJobId(j);
        
        jobSkillColl.add(jss);
        j.setJobskillsetCollection(jobSkillColl);
        em.persist(jss);
        em.merge(j);
    }

    @Override
    public void updateJobSkillset(int Id, String Name, int jobId) {
         Jobskillset jss = em.find(Jobskillset.class, Id);
        Jobdetails j = em.find(Jobdetails.class, jobId);
        Collection<Jobskillset> jobSkillColl = j.getJobskillsetCollection();
        
        jss.setSkillname(Name);
        jss.setJobId(j);
        
        
        jobSkillColl.add(jss);
        j.setJobskillsetCollection(jobSkillColl);
        em.merge(jss);
        em.merge(j);
    }

    @Override
    public void removeJobSkillset(int Id) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Jobskillset jss = em.find(Jobskillset.class, Id);
        em.remove(jss);
    }

    @Override
    public Collection<Aptitudetest> getAllApptitudeTest() {
         return em.createNamedQuery("Aptitudetest.findAll").getResultList();
    }

    @Override
    public void addApptitudeTest(int jobId, String ExamName, String ExamDetails, int cutoff) {
        Aptitudetest at = new Aptitudetest(ExamName,ExamDetails,cutoff);
        Jobdetails jid = em.find(Jobdetails.class, jobId);
        Collection<Aptitudetest> aptitudeColl = jid.getAptitudetestCollection();
        
        at.setJobId(jid);
        aptitudeColl.add(at);
        jid.setAptitudetestCollection(aptitudeColl);
        em.persist(at);
        em.merge(jid);
    }

    @Override
    public void updateApptitudeTest(int Id, int jobId, String ExamName, String ExamDetails, int cutoff) {
        Aptitudetest at = em.find(Aptitudetest.class, Id);
        Jobdetails jid = em.find(Jobdetails.class, jobId);
        Collection<Aptitudetest> aptitudeColl = jid.getAptitudetestCollection();
        at.setJobId(jid);
        at.setExamName(ExamName);
        at.setExamDetails(ExamDetails);
        at.setCutOff(cutoff);
        aptitudeColl.add(at);
        jid.setAptitudetestCollection(aptitudeColl);
        
        em.merge(at);
        em.merge(jid);
    }

    @Override
    public void removeApptitudeTest(int Id) {
        Aptitudetest at = em.find(Aptitudetest.class, Id);
        em.remove(at);
    }

    @Override
    public Collection<Aptituderesult> getAllApptitudeResult() {
        return em.createNamedQuery("Aptituderesult.findAll").getResultList();
    }

    @Override
    public void addApptitudeResult(int ApptitudeTestId, String userName, int Marks, boolean IsSelected) {
        Aptituderesult ares = new Aptituderesult(Marks,IsSelected);
        Aptitudetest aTest = em.find(Aptitudetest.class, ApptitudeTestId);
        Collection<Aptituderesult> aptitudeTestColl = aTest.getAptituderesultCollection();
        Register reg = em.find(Register.class, userName);
        Collection<Aptituderesult> aptituderegColl = reg.getAptituderesultCollection();
        
        ares.setUsername(reg);
        ares.setAptitudeTestId(aTest);
        
        aptitudeTestColl.add(ares);
        aTest.setAptituderesultCollection(aptitudeTestColl);
        aptituderegColl.add(ares);
        reg.setAptituderesultCollection(aptituderegColl);
        em.persist(ares);
        em.merge(aTest);
        em.merge(reg);
    }

    @Override
    public void updateApptitudeResult(int Id, int ApptitudeTestId, String userName, int Marks, boolean IsSelected) {
        Aptituderesult ares = em.find(Aptituderesult.class, Id);
        Aptitudetest aTest = em.find(Aptitudetest.class, ApptitudeTestId);
        Collection<Aptituderesult> aptitudeTestColl = aTest.getAptituderesultCollection();
        Register reg = em.find(Register.class, userName);
        Collection<Aptituderesult> aptituderegColl = reg.getAptituderesultCollection();
        
        ares.setMarks(Marks);
        ares.setIsSelected(IsSelected);
        ares.setUsername(reg);
        ares.setAptitudeTestId(aTest);        
        
        aptitudeTestColl.add(ares);
        aTest.setAptituderesultCollection(aptitudeTestColl);
        aptituderegColl.add(ares);
        reg.setAptituderesultCollection(aptituderegColl);
        em.merge(ares);
        em.merge(aTest);
        em.merge(reg);
    }

    @Override
    public void removeApptitudeResult(int Id) {
        Aptituderesult ares = em.find(Aptituderesult.class, Id);
        em.remove(ares);
    }

    @Override
    public Collection<Telephonicinterview> getAllTelephonic() {
       return em.createNamedQuery("Telephonicinterview.findAll").getResultList();
    }

    @Override
    public void addTelephonic(int JobId, String Username, boolean IsSelected) {
        Telephonicinterview ti = new Telephonicinterview(IsSelected);
        Register reg = (Register) em.find(Register.class, Username);
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        ti.setJobId(job);
        ti.setUsername(reg);
        em.persist(ti);
    }

    @Override
    public void updateTelephonic(int Id, int JobId, String Username, boolean IsSelected) {
        Telephonicinterview ti = (Telephonicinterview) em.find(Telephonicinterview.class, Id);
        Register reg = (Register) em.find(Register.class, Username);
        Jobdetails job = (Jobdetails)em.find(Jobdetails.class, JobId);
        ti.setJobId(job);
        ti.setUsername(reg);
        ti.setIsSelected(IsSelected);
        em.merge(ti);
    }

    @Override
    public void removeTelephonic(int Id) {
         Telephonicinterview ti = (Telephonicinterview) em.find(Telephonicinterview.class, Id);
        em.remove(ti);
    }

    @Override
    public Collection<Personalinterview> getAllPersonalInterview() {
         return em.createNamedQuery("Personalinterview.findAll").getResultList();
    }

    @Override
    public void addPersonalInterview(int JobId, String Username, boolean IsSelected) {
        Personalinterview pi = new Personalinterview(IsSelected);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        pi.setJobId(job);
        pi.setUsername(reg);
        em.persist(pi);
    }

    @Override
    public void updatePersonalInterview(int Id, int JobId, String Username, boolean IsSelected) {
        Personalinterview pi = em.find(Personalinterview.class, Id);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        pi.setIsSelected(IsSelected);
        pi.setJobId(job);
        pi.setUsername(reg);
        em.merge(pi);
    }

    @Override
    public void removePersonalInterview(int Id) {
       Personalinterview pi = em.find(Personalinterview.class,Id);
       em.remove(pi);
    }

    @Override
    public Collection<Rejected> getAllRejectedUser() {
       return em.createNamedQuery("Rejected.findAll").getResultList();
    }

    @Override
    public void addRejectedUser(int JobId, String Username, int StageId) {
        Rejected reject = new Rejected();
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        Stages s = em.find(Stages.class, StageId);
        reject.setUsername(reg);
        reject.setJobId(job);
        reject.setStageId(s);
        em.persist(reject);
    }

    @Override
    public void updateRejectedUser(int Id, int JobId, String Username, int StageId) {
        Rejected reject = em.find(Rejected.class, Id);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        Stages s = em.find(Stages.class, StageId);
        reject.setUsername(reg);
        reject.setJobId(job);
        reject.setStageId(s);
        em.persist(reject);
    }

    @Override
    public void removeRejectedUser(int Id) {
        Rejected reject = em.find(Rejected.class, Id);
        em.remove(reject);
    }

    @Override
    public Collection<Resume> getAllResume() {
        return em.createNamedQuery("Resume.findAll").getResultList();
    }

    @Override
    public void addResume(int JobId, String Username, String ResumeFile) {
        Resume res = new Resume(ResumeFile);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        res.setJobId(job);
        res.setUsername(reg);
        em.persist(res);
    }

    @Override
    public void updateResume(int Id, int JobId, String Username, String ResumeFile) {
        Resume res = em.find(Resume.class, Id);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        res.setJobId(job);
        res.setUsername(reg);
        res.setResumeFile(ResumeFile);
        em.merge(res);
    }

    @Override
    public void removeResume(int Id) {
        Resume res = em.find(Resume.class, Id);
        em.remove(res);
    }

    @Override
    public Collection<Selectedcandidate> getAllSelectedCandidate() {
        return em.createNamedQuery("Selectedcandidate.findAll").getResultList();
    }

    @Override
    public void addSelectedCandidate(int JobId, String Username, int Salary, String Designation, boolean isConfirmed) {
        Selectedcandidate sc = new Selectedcandidate(Salary, Designation, isConfirmed);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        sc.setJobId(job);
        sc.setUsername(reg);
        em.persist(sc);
    }

    @Override
    public void updateSelectedCandidate(int Id, int JobId, String Username, int Salary, String Designation, boolean isConfirmed) {
        Selectedcandidate sc = em.find(Selectedcandidate.class, Id);
        Jobdetails job = em.find(Jobdetails.class, JobId);
        Register reg = em.find(Register.class, Username);
        sc.setJobId(job);
        sc.setUsername(reg);
        sc.setSalary(Salary);
        sc.setDesignation(Designation);
        sc.setIsConfirmed(isConfirmed);
        em.merge(sc);
    }

    @Override
    public void removeSelectedCandidate(int Id) {
         Selectedcandidate sc = em.find(Selectedcandidate.class, Id);
        em.remove(sc);
    }

    @Override
    public Collection<Testinstruction> getAllTestInstruction() {
        return em.createNamedQuery("Testinstruction.findAll").getResultList();
    }

    @Override
    public void addTestInstruction(int ApptitudeTestId, String Message) {
        Testinstruction ti = new Testinstruction(Message);
        Aptitudetest at = em.find(Aptitudetest.class, ApptitudeTestId);
        ti.setAptitudeTestId(at);
        em.persist(ti);
        
    }

    @Override
    public void updateTestInstruction(int Id, int ApptitudeTestId, String Message) {
        Testinstruction ti = em.find(Testinstruction.class, Id);
        Aptitudetest at = em.find(Aptitudetest.class, ApptitudeTestId);
        ti.setAptitudeTestId(at);
        ti.setMessage(Message);
        em.merge(ti);
    }

    @Override
    public void removeTestInstruction(int Id) {
         Testinstruction ti = em.find(Testinstruction.class, Id);
        em.remove(ti);
    }

    @Override
    public Collection<Unit> getAllUnit() {
        return em.createNamedQuery("Unit.findAll").getResultList();
    }

    @Override
    public void addUnit(String Name, String Address, int Zipcode, int CountryId, int StateId, int CityId) {
        Unit unit = new Unit(Name, Address, Zipcode);
        Country countr = em.find(Country.class, CountryId);
        State state = em.find(State.class, StateId);
        City city = em.find(City.class, CityId);
        unit.setCountryId(countr);
        unit.setStateId(state);
        unit.setCityId(city);
        em.persist(unit);
    }

    @Override
    public void updateUnit(int Id, String Name, String Address, int Zipcode, int CountryId, int StateId, int CityId) {
        Unit unit = em.find(Unit.class, Id);
        Country countr = em.find(Country.class, CountryId);
        State state = em.find(State.class, StateId);
        City city = em.find(City.class, CityId);
        unit.setCountryId(countr);
        unit.setStateId(state);
        unit.setCityId(city);
        unit.setName(Name);
        unit.setAddress(Address);
        unit.setZipCode(Zipcode);
        em.merge(unit);
    }

    @Override
    public void removeUnit(int Id) {
         Unit unit = em.find(Unit.class, Id);
        em.remove(unit);
    }

    @Override
    public Collection<Userskillset> getAllUserSkillSet() {
         return em.createNamedQuery("Userskillset.findAll").getResultList();
    }

    @Override
    public void addUserskillset(String SkillName, String Username) {
         Userskillset userskill = new Userskillset(SkillName);
        Register reg = em.find(Register.class, Username);
        userskill.setUsername(reg);
        em.persist(userskill);
    }

    @Override
    public void updateUserskillset(int Id, String SkillName, String UserName) {
        Userskillset userskill = em.find(Userskillset.class, Id);
        Register reg = em.find(Register.class, UserName);
        userskill.setUsername(reg);
        userskill.setSkillname(SkillName);
        em.merge(userskill);
    }

    @Override
    public void removeUserskillset(int Id) {
        Userskillset userskill = em.find(Userskillset.class, Id);
        em.remove(userskill);
    }

    @Override
    public void addStage(String Type) {
        Stages st = new Stages(Type);
        em.persist(st);
    }

    @Override
    public Collection<Register> SearchByUserName(String UserName) {
         return em.createNamedQuery("Register.findByUsername").setParameter("username", UserName).getResultList();
    }

    @Override
    public String getUsernamefromUser(String username) {
         Collection<Register> user = em.createNamedQuery("Register.findByUsername").setParameter("username", username).getResultList();
        for (Register users : user) {
            uname = users.getUsername();
            System.out.println("User Id is " + uname);
        }
        return uname;
    }

    @Override
    public Collection<Country> getAllCountries() {
         return em.createNamedQuery("Country.findAll").getResultList();
    }

    @Override
    public Collection<State> getAllStates(int cid) {
        return em.createNamedQuery("State.findByCountryId").setParameter("countryId", cid).getResultList();
    }

    @Override
    public Collection<City> getAllCities(int sid) {
        return em.createNamedQuery("City.findByStateId").setParameter("stateId", sid).getResultList();
    }
    
    @Override
    public Collection<Company> SearchByCompany(String name) {
         return em.createNamedQuery("Company.findByName").setParameter("name", name).getResultList();
    }

    @Override
    public Collection<Jobdetails> SearchByJobTitle(String Title) {
        return em.createNamedQuery("Jobdetails.findByTitle").setParameter("title", Title).getResultList();
    }

    @Override
    public Collection<Aptitudetest> SearchByApptitudeExamName(String name) {
        return em.createNamedQuery("Aptitudetest.findByExamName").setParameter("examName", name).getResultList();
    }

    @Override
    public Collection<Aptituderesult> SearchByApptitudeMarks(int marks) {
        return em.createNamedQuery("Aptituderesult.findByMarks").setParameter("marks", marks).getResultList();
    }

    @Override
    public Collection<Aptituderesult> SearchByApptitudeMarkRange(int smarks, int emarks) {
        return em.createNamedQuery("Aptituderesult.findByMarksRange").setParameter("smarks", smarks).setParameter("emarks", emarks).getResultList();
    }

    @Override
    public Collection<Aptituderesult> SearchByApptitudeResultSelected(boolean Isselected) {
       return em.createNamedQuery("Aptituderesult.findByIsSelected").setParameter("isSelected", Isselected).getResultList();
    }

    @Override
    public Collection<Jobdetails> SearchJobByAdress(String address) {
        return em.createQuery("SELECT j FROM Jobdetails j JOIN j.companyId co WHERE co.unitId.address = :address").setParameter("address", address).getResultList();
    }

    @Override
    public Unit SearchByUnitId(int id) {
        Unit unit = em.find(Unit.class, id);
        return unit;
    }
    
    @Override
    public Inquiry SearchByInquiryId(int id) {
        Inquiry inquiry = em.find(Inquiry.class, id);
        return inquiry;
    }
    
}
