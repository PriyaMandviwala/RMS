/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RecruitmentResource
 * [recruitmentRes]<br>
 * USAGE:
 * <pre>
 *        RecruitmentClient client = new RecruitmentClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class RecruitmentClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Recruitment/webresources";

    public RecruitmentClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("recruitmentRes");
    }

    public <T> T SearchByCompanyName(Class<T> responseType, String companyname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbycompany/{0}", new Object[]{companyname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCompanyServices(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCompanyServices/{0}", new Object[]{id})).request().delete();
    }

    public void addTelephonic(String jobid, String username, String isselected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addtelephonic/{0}/{1}/{2}", new Object[]{jobid, username, isselected})).request().post(null);
    }

    public <T> T SearchJobByAddress(Class<T> responseType, String address) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchjobbyaddress/{0}", new Object[]{address}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String username, String password, String firstname, String middlename, String lastname, String dob, String gender, String phoneno, String collegename, String collegeemail, String highestdegree, String emailid, String address, String pincode, String level, String countryid, String stateid, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}", new Object[]{username, password, firstname, middlename, lastname, dob, gender, phoneno, collegename, collegeemail, highestdegree, emailid, address, pincode, level, countryid, stateid, cityid})).request().post(null);
    }

    public void updateCompany(String id, String name, String passowrd, String unitid, String email, String chno, String numEmployee) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{id, name, passowrd, unitid, email, chno, numEmployee})).request().put(null);
    }

    public void editUser(String username, String password, String firstname, String middlename, String lastname, String dob, String gender, String phoneno, String collegename, String collegeemail, String highestdegree, String emailid, String address, String pincode, String level, String countryid, String stateid, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}", new Object[]{username, password, firstname, middlename, lastname, dob, gender, phoneno, collegename, collegeemail, highestdegree, emailid, address, pincode, level, countryid, stateid, cityid})).request().put(null);
    }

    public void addAptitudeTest(String jobid, String examname, String examdetail, String cutoff) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAptitudeTest/{0}/{1}/{2}/{3}", new Object[]{jobid, examname, examdetail, cutoff})).request().post(null);
    }

    public void editPersonalInterview(String id, String jobId, String userName, String isSelected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editPersonalInterview/{0}/{1}/{2}/{3}", new Object[]{id, jobId, userName, isSelected})).request().put(null);
    }

    public void addPersonalInterview(String jobId, String userName, String isSelected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPersonalInterview/{0}/{1}/{2}", new Object[]{jobId, userName, isSelected})).request().post(null);
    }

    public void removePersonalInterview(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("rempersonalinterview/{0}", new Object[]{id})).request().delete();
    }

    public void updateRejectedUser(String id, String jobid, String username, String stageid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editrejecteduser/{0}/{1}/{2}/{3}", new Object[]{id, jobid, username, stageid})).request().put(null);
    }

    public <T> T getAllJob(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T SearchByApptitudeExamName(Class<T> responseType, String examname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyaptitudeexamname/{0}", new Object[]{examname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeUser(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remuser/{0}", new Object[]{id})).request().delete();
    }

    public void updateCompanyPhotos(String cpid, String cid, String image) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCompanyPhotos/{0}/{1}/{2}", new Object[]{cpid, cid, image})).request().put(null);
    }

    public void addDocument(String username, String jobId, String file) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addDocument/{0}/{1}/{2}", new Object[]{username, jobId, file})).request().post(null);
    }

    public void removeExperience(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeExperience/{0}", new Object[]{id})).request().delete();
    }

    public void removeJobskillset(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeJobskillset/{0}", new Object[]{id})).request().delete();
    }

    public void removeRejectedUser(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remejecteduser/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllCompanyServices(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllExperience(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllExperience");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTelephonic(String id, String jobid, String username, String isselected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("edittelephonic/{0}/{1}/{2}/{3}", new Object[]{id, jobid, username, isselected})).request().put(null);
    }

    public void updateUserSkillSet(String skillname, String username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("edituserskillset/{0}/{1}", new Object[]{skillname, username})).request().put(null);
    }

    public void removeTestInstruction(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remtestinstruction/{0}", new Object[]{id})).request().delete();
    }

    public <T> T GetAllAptitudeResult(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllAptitudeResult");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTestInstruction(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alltestinstruction");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateJobskillset(String id, String name, String jobid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateJobskillset/{0}/{1}/{2}", new Object[]{id, name, jobid})).request().put(null);
    }

    public <T> T SearchByApptitudeMarkRange(Class<T> responseType, String smarks, String emarks) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyaptitudemarkrange/{0}/{1}", new Object[]{smarks, emarks}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRejectedUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allrejecteduser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeTelephonic(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remtelephonic/{0}", new Object[]{id})).request().delete();
    }

    public void addjobofCompany(String title, String details, String noofvacancy, String pack, String lastdate, String jobtype, String comid, String bondyear) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addjobofCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{title, details, noofvacancy, pack, lastdate, jobtype, comid, bondyear})).request().post(null);
    }

    public void editSelectedCandidate(String id, String jobid, String username, String salary, String designation, String isconfirmed) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editselectedcandidate/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{id, jobid, username, salary, designation, isconfirmed})).request().put(null);
    }

    public <T> T getAllDocument(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllDocument");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addInquiry(String msg, String isread, String jobid, String username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addInquiry/{0}/{1}/{2}/{3}", new Object[]{msg, isread, jobid, username})).request().post(null);
    }

    public void updateAptitudeTest(String id, String jobid, String examname, String examdetail, String cutoff) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAptitudeTest/{0}/{1}/{2}/{3}/{4}", new Object[]{id, jobid, examname, examdetail, cutoff})).request().put(null);
    }

    public void addResume(String jobid, String username, String resumefile) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addresume/{0}/{1}/{2}", new Object[]{jobid, username, resumefile})).request().post(null);
    }

    public void removeCompany(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCompany/{0}", new Object[]{id})).request().delete();
    }

    public void updateUnit(String id, String name, String address, String zipcode, String countryid, String stateid, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editunit/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{id, name, address, zipcode, countryid, stateid, cityid})).request().put(null);
    }

    public void addStages(String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addStage/{0}", new Object[]{type})).request().post(null);
    }

    public void updateCompanyServices(String csid, String cid, String stitle, String sdesc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCompanyServices/{0}/{1}/{2}/{3}", new Object[]{csid, cid, stitle, sdesc})).request().put(null);
    }

    public <T> T getAllCompanyPhotos(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyPhotos");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeAptitudeTest(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAptitudeTest/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alluser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addJobskillset(String name, String jobid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addJobskillset/{0}/{1}", new Object[]{name, jobid})).request().post(null);
    }

    public void updateResume(String id, String jobid, String username, String resumefile) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editresume/{0}/{1}/{2}/{3}", new Object[]{id, jobid, username, resumefile})).request().put(null);
    }

    public <T> T GetAllAptitudeTest(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllAptitudeTest");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateDocument(String id, String username, String jobId, String file) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDocument/{0}/{1}/{2}/{3}", new Object[]{id, username, jobId, file})).request().put(null);
    }

    public void removeUserSkillSet(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remuserskillset/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllCompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T SearchByJobId(Class<T> responseType, String jobid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyjobid/{0}", new Object[]{jobid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRejectedUser(String jobid, String username, String stageid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addrejecteduser/{0}/{1}/{2}", new Object[]{jobid, username, stageid})).request().post(null);
    }

    public void removeSelectedCandidate(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remselectedcandidate/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllCountries(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallcountry");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCompanyServices(String cid, String stitle, String sdesc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompanyServices/{0}/{1}/{2}", new Object[]{cid, stitle, sdesc})).request().post(null);
    }

    public <T> T getAllTelephonic(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alltelephonic");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeResume(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeresume/{0}", new Object[]{id})).request().delete();
    }

    public <T> T SerachByUserName(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyusername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUnit(String name, String address, String zipcode, String countryid, String stateid, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addunit/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{name, address, zipcode, countryid, stateid, cityid})).request().post(null);
    }

    public void addUserSkillSet(String skillname, String username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduserskillset/{0}/{1}", new Object[]{skillname, username})).request().post(null);
    }

    public void removeAptitudeResult(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAptitudeResult/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllUserSkillSet(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alluserskillset");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCompanyPhotos(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCompanyPhotos/{0}", new Object[]{id})).request().delete();
    }

    public void removeUnit(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remunit/{0}", new Object[]{id})).request().delete();
    }

    public void updateInquiry(String id, String msg, String isread, String jobid, String username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateInquiry/{0}/{1}/{2}/{3}/{4}", new Object[]{id, msg, isread, jobid, username})).request().put(null);
    }

    public <T> T getAllResume(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allresume");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCities(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallcity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCompanyPhotos(String cid, String image) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompanyPhotos/{0}/{1}", new Object[]{cid, image})).request().post(null);
    }

    public <T> T getAllPersonalinterview(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allpersonalinterview");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTestInstruction(String id, String apttestid, String message) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("edittestinstruction/{0}/{1}/{2}", new Object[]{id, apttestid, message})).request().put(null);
    }

    public <T> T getAllUnit(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allunit");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllInquiry(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllInquiry");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addSelectedCandidate(String jobid, String username, String salary, String designation, String isconfirmed) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addselectedcandidate/{0}/{1}/{2}/{3}/{4}", new Object[]{jobid, username, salary, designation, isconfirmed})).request().post(null);
    }

    public <T> T SearchByJobTitle(Class<T> responseType, String jobtitle) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyjobtitle/{0}", new Object[]{jobtitle}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTestInstruction(String apttestid, String message) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addtestinstruction/{0}/{1}", new Object[]{apttestid, message})).request().post(null);
    }

    public <T> T getAllStates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallstate");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T SearchByApptitudeResultSelected(Class<T> responseType, String isselected) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyaptituderesultselected/{0}", new Object[]{isselected}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllSelectedCandidate(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allselectedcandidate");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeDocument(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeDocument/{0}", new Object[]{id})).request().delete();
    }

    public void addAptitudeResult(String ApptitudeTestId, String userName, String Marks, String IsSelected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAptitudeResult/{0}/{1}/{2}/{3}", new Object[]{ApptitudeTestId, userName, Marks, IsSelected})).request().post(null);
    }

    public void updateExperience(String id, String username, String NoofYr, String CompanyName, String Designation, String Salary, String ComAddress, String ExperienceLetter) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateExperience/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{id, username, NoofYr, CompanyName, Designation, Salary, ComAddress, ExperienceLetter})).request().put(null);
    }

    public <T> T GetAllJobSkillSet(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllJobSkillSet");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addExperience(String username, String NoofYr, String CompanyName, String Designation, String Salary, String ComAddress, String ExperienceLetter) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addExperience/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{username, NoofYr, CompanyName, Designation, Salary, ComAddress, ExperienceLetter})).request().post(null);
    }

    public void updateAptitudeResult(String id, String ApptitudeTestId, String userName, String Marks, String IsSelected) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAptitudeResult/{0}/{1}/{2}/{3}/{4}", new Object[]{id, ApptitudeTestId, userName, Marks, IsSelected})).request().put(null);
    }

    public <T> T SearchByApptitudeMarks(Class<T> responseType, String marks) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyaptitudemarks/{0}", new Object[]{marks}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeJob(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeJob/{0}", new Object[]{id})).request().delete();
    }

    public void removeInquiry(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeInquiry/{0}", new Object[]{id})).request().delete();
    }

    public void addCompany(String name, String passowrd, String unitid, String email, String chno, String numEmployee) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompany/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{name, passowrd, unitid, email, chno, numEmployee})).request().post(null);
    }

    public void editJobOfCompany(String id, String title, String details, String noofvacancy, String pack, String lastdate, String jobtype, String comid, String bondyear) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editjobofCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{id, title, details, noofvacancy, pack, lastdate, jobtype, comid, bondyear})).request().put(null);
    }

    public <T> T SearchByUnitId(Class<T> responseType, String unitid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbyunitid/{0}", new Object[]{unitid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
