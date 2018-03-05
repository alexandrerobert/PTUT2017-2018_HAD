package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Patient {

    private String id;
    private String hasName;
    private String hasFirstName;
    private Sexe hasSex;
    private Date hasDateOfBirth;
    private String hasPlaceOfBirth;
    private int hasSocialSecurityNumberID;
    private String hasBMI;
    private String hasAdress;
    private int hasPhoneNumber;
    private String hasEmail;
    private MaritalStatus hasMaritalStatus;
    private Boolean isInternet;
    private float hasWeight;
    private float hasSize;
    private Boolean isValide;
    private Boolean isValideFamily;
    private String hasAllergies;
    private ArrayList<Disease> hasDiseases;
    private String hasPrevious;
    private Boolean isAccessiblePlace;
    private String hasNotes;
    private Boolean isSport;
    private Boolean isSmoking;


    public Patient(String id, String hasName, String hasFirstName, Sexe hasSex, Date hasDateOfBirth, String hasPlaceOfBirth, int hasSocialSecurityNumberID, String hasBMI, String hasAdress, int hasPhoneNumber, String hasEmail, MaritalStatus hasMaritalStatus, Boolean isInternet, float hasWeight, float hasSize, Boolean isValide, Boolean isValideFamily, String hasAllergies, ArrayList<Disease> hasDiseases, String hasPrevious, Boolean isAccessiblePlace, String hasNotes) {
        this.id = id;
        this.hasName = hasName;
        this.hasFirstName = hasFirstName;
        this.hasSex = hasSex;
        this.hasDateOfBirth = hasDateOfBirth;
        this.hasPlaceOfBirth = hasPlaceOfBirth;
        this.hasSocialSecurityNumberID = hasSocialSecurityNumberID;
        this.hasBMI = hasBMI;
        this.hasAdress = hasAdress;
        this.hasPhoneNumber = hasPhoneNumber;
        this.hasEmail = hasEmail;
        this.hasMaritalStatus = hasMaritalStatus;
        this.isInternet = isInternet;
        this.hasWeight = hasWeight;
        this.hasSize = hasSize;
        this.isValide = isValide;
        this.isValideFamily = isValideFamily;
        this.hasAllergies = hasAllergies;
        this.hasDiseases = hasDiseases;
        this.hasPrevious = hasPrevious;
        this.isAccessiblePlace = isAccessiblePlace;
        this.hasNotes = hasNotes;
        this.isSmoking = isSmoking;
        this.isSport = isSport;
    }
    
    public Date getHasDateOfBirth() {
        return hasDateOfBirth;
    }

    public void setHasDateOfBirth(Date hasDateOfBirth) {
        this.hasDateOfBirth = hasDateOfBirth;
    }

    public Boolean getIsSport() {
        return isSport;
    }

    public void setIsSport(Boolean isSport) {
        this.isSport = isSport;
    }

    public Boolean getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(Boolean isSmoking) {
        this.isSmoking = isSmoking;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHasName() {
        return hasName;
    }

    public void setHasName(String hasName) {
        this.hasName = hasName;
    }

    public String getHasFirstName() {
        return hasFirstName;
    }

    public void setHasFirstName(String hasFirstName) {
        this.hasFirstName = hasFirstName;
    }

    public Sexe getHasSex() {
        return hasSex;
    }

    public void setHasSex(Sexe hasSex) {
        this.hasSex = hasSex;
    }

    public String getHasPlaceOfBirth() {
        return hasPlaceOfBirth;
    }

    public void setHasPlaceOfBirth(String hasPlaceOfBirth) {
        this.hasPlaceOfBirth = hasPlaceOfBirth;
    }

    public int getHasSocialSecurityNumberID() {
        return hasSocialSecurityNumberID;
    }

    public void setHasSocialSecurityNumberID(int hasSocialSecurityNumberID) {
        this.hasSocialSecurityNumberID = hasSocialSecurityNumberID;
    }

    public String getHasBMI() {
        return hasBMI;
    }

    public void setHasBMI(String hasBMI) {
        this.hasBMI = hasBMI;
    }

    public String getHasAdress() {
        return hasAdress;
    }

    public void setHasAdress(String hasAdress) {
        this.hasAdress = hasAdress;
    }

    public int getHasPhoneNumber() {
        return hasPhoneNumber;
    }

    public void setHasPhoneNumber(int hasPhoneNumber) {
        this.hasPhoneNumber = hasPhoneNumber;
    }

    public String getHasEmail() {
        return hasEmail;
    }

    public void setHasEmail(String hasEmail) {
        this.hasEmail = hasEmail;
    }

    public MaritalStatus getHasMaritalStatus() {
        return hasMaritalStatus;
    }

    public void setHasMaritalStatus(MaritalStatus hasMaritalStatus) {
        this.hasMaritalStatus = hasMaritalStatus;
    }

    public Boolean getIsInternet() {
        return isInternet;
    }

    public void setIsInternet(Boolean isInternet) {
        this.isInternet = isInternet;
    }

    public float getHasWeight() {
        return hasWeight;
    }

    public void setHasWeight(float hasWeight) {
        this.hasWeight = hasWeight;
    }

    public float getHasSize() {
        return hasSize;
    }

    public void setHasSize(float hasSize) {
        this.hasSize = hasSize;
    }

    public Boolean getIsValide() {
        return isValide;
    }

    public void setIsValide(Boolean isValide) {
        this.isValide = isValide;
    }

    public Boolean getIsValideFamily() {
        return isValideFamily;
    }

    public void setIsValideFamily(Boolean isValideFamily) {
        this.isValideFamily = isValideFamily;
    }

    public String getHasAllergies() {
        return hasAllergies;
    }

    public void setHasAllergies(String hasAllergies) {
        this.hasAllergies = hasAllergies;
    }

    public ArrayList<Disease> getHasDiseases() {
        return hasDiseases;
    }

    public void setHasDiseases(ArrayList<Disease> hasDiseases) {
        this.hasDiseases = hasDiseases;
    }

    public String getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(String hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public Boolean getIsAccessiblePlace() {
        return isAccessiblePlace;
    }

    public void setIsAccessiblePlace(Boolean isAccessiblePlace) {
        this.isAccessiblePlace = isAccessiblePlace;
    }

    public String getHasNotes() {
        return hasNotes;
    }

    public void setHasNotes(String hasNotes) {
        this.hasNotes = hasNotes;
    }
    

    @Override
    public String toString() {
        return "Patient{" + "adress=" + hasAdress + ", allergies=" + hasAllergies + ", BMI=" + hasBMI + ", dateOfBirth=" + hasDateOfBirth + ", email=" + hasEmail + ", firstName=" + hasFirstName + ", maritalStatus=" + hasMaritalStatus + ", hasName=" + hasName + ", hasNotes=" + hasNotes + ", phoneNumber=" + hasPhoneNumber + ", placeOfBirth=" + hasPlaceOfBirth + ", previous=" + hasPrevious + ", sex=" + hasSex + ", size=" + hasSize + ", socialSecurityNumberID=" + hasSocialSecurityNumberID + ", weight=" + hasWeight + ", accessiblePlace=" + isAccessiblePlace + ", internet=" + isInternet + ", valide=" + isValide + ", valideFamily=" + isValideFamily + ", sport=" + isSport + ", smoking=" + isSmoking + '}';
    }

}
