package employeetool.model;

import java.util.Date;
import java.util.UUID;
/**
 *
 * @author DiegoWindows
 */

public class Employee {
    private int businessEntityID;
    private String nationalIDNumber;
    private String loginID;
    private String organizationNode;  
    private Short organizationLevel;  
    private String jobTitle;
    private Date birthDate;
    private char maritalStatus;
    private char gender;
    private Date hireDate;
    private boolean salariedFlag;
    private short vacationHours;
    private short sickLeaveHours;
    private boolean currentFlag;
    private UUID rowGuid;
    private Date modifiedDate;


    public Employee() {}


    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getOrganizationNode() {
        return organizationNode;
    }

    public void setOrganizationNode(String organizationNode) {
        this.organizationNode = organizationNode;
    }

    public Short getOrganizationLevel() {
        return organizationLevel;
    }

    public void setOrganizationLevel(Short organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isSalariedFlag() {
        return salariedFlag;
    }

    public void setSalariedFlag(boolean salariedFlag) {
        this.salariedFlag = salariedFlag;
    }

    public short getVacationHours() {
        return vacationHours;
    }

    public void setVacationHours(short vacationHours) {
        this.vacationHours = vacationHours;
    }

    public short getSickLeaveHours() {
        return sickLeaveHours;
    }

    public void setSickLeaveHours(short sickLeaveHours) {
        this.sickLeaveHours = sickLeaveHours;
    }

    public boolean isCurrentFlag() {
        return currentFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    public UUID getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(UUID rowGuid) {
        this.rowGuid = rowGuid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
