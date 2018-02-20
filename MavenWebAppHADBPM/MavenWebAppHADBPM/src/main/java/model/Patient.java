package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
    
private String name;
private String firstName;
private Sexe sexe;
private Date birth;
private String placeBirth;
private int socialSecurityNumber;
private String ipp;
 private String adress;
private int phoneNumber;
private String email;
private MaritalStatus maritalStatus; 
private Boolean isInternet;
private float weight;
private float size;
private Boolean isValide;
private String allergies;
private ArrayList<Disease> diseases;
private String antecedents;
private Boolean validEntourage;
private Boolean placeAccesible;
private String notes;
private String id;

public Patient(){}
 
public Patient(String id, String name, String firstName, Sexe sexe, Date birth, String placeBirth, int socialSecurityNumber, String ipp, String adress, int phoneNumber, MaritalStatus maritalStatus, String email, Boolean isInternet, float weight, float size, Boolean isValide, String allergies, ArrayList<Disease> diseases, String antecedents, Boolean validEntourage, Boolean placeAccesible, String notes) {
         this.name = name;
        this.firstName = firstName;
         this.sexe = sexe;
         this.birth = birth;
         this.placeBirth = placeBirth;
         this.socialSecurityNumber = socialSecurityNumber;
         this.ipp = ipp;
         this.adress = adress;
         this.phoneNumber = phoneNumber;
         this.email = email;
         this.isInternet = isInternet;
         this.weight = weight;
         this.size = size;
         this.isValide = isValide;
         this.allergies = allergies;
         this.diseases = diseases;
         this.antecedents = antecedents;
         this.validEntourage = validEntourage;
         this.placeAccesible = placeAccesible;
         this.notes = notes;
         this.id = id;
     }
 
     public String getId() {
         return this.id;
     }
     
     public void setId(String id) {
         this.id = id;
     }
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public String getFirstName() {
         return firstName;
     }
 
     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }
     
     public Sexe getSexe() {
         return sexe;
     }
 
     public void setSexe(Sexe sexe) {
         this.sexe = sexe;
     }
 
     public Date getBirth() {
         return birth;
     }
 
     public void setBirth(Date birth) {
         this.birth = birth;
     }
 
     public String getPlaceBirth() {
         return placeBirth;
     }
 
     public void setPlaceBirth(String placeBirth) {
         this.placeBirth = placeBirth;
     }
 
     public int getSocialSecurityNumber() {
         return socialSecurityNumber;
     }
 
     public void setSocialSecurityNumber(int socialSecurityNumber) {
         this.socialSecurityNumber = socialSecurityNumber;
     }
 
     public String getIpp() {
         return ipp;
     }
 
     public void setIpp(String ipp) {
         this.ipp = ipp;
     }
 
     public String getAdress() {
         return adress;
     }
 
     public void setAdress(String adress) {
         this.adress = adress;
     }
 
     public int getPhoneNumber() {
         return phoneNumber;
     }
 
     public void setPhoneNumber(int phoneNumber) {
         this.phoneNumber = phoneNumber;
     }
     
     
     public MaritalStatus getMaritalStatus() {
         return maritalStatus;
     }
 
     public void setMaritalStatus(MaritalStatus maritalStatus) {
         this.maritalStatus = maritalStatus;
     }
 
     public String getEmail() {
         return email;
     }
 
     public void setEmail(String email) {
         this.email = email;
     }
 
     public Boolean getIsInternet() {
         return isInternet;
     }
 
     public void setIsInternet(Boolean isInternet) {
         this.isInternet = isInternet;
     }
 
     public float getWeight() {
         return weight;
     }
 
     public void setWeight(float weight) {
         this.weight = weight;
     }
 
     public float getSize() {
         return size;
     }
 
     public void setSize(float size) {
         this.size = size;
     }
 
     public Boolean getIsValide() {
         return isValide;
     }
 
     public void setIsValide(Boolean isValide) {
         this.isValide = isValide;
     }
 
     public String getAllergies() {
         return allergies;
     }
 
     public void setAllergies(String allergies) {
         this.allergies = allergies;
     }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<Disease> diseases) {
        this.diseases = diseases;
    }
 
     public String getAntecedents() {
         return antecedents;
     }
 
     public void setAntecedents(String antecedents) {
         this.antecedents = antecedents;
     }
 
     public Boolean getValidEntourage() {
         return validEntourage;
     }
 
     public void setValidEntourage(Boolean validEntourage) {
         this.validEntourage = validEntourage;
     }
 
     public Boolean getPlaceAccesible() {
         return placeAccesible;
     }
 
     public void setPlaceAccesible(Boolean placeAccesible) {
         this.placeAccesible = placeAccesible;
     }
 
     public String getNotes() {
         return notes;
     }
 
     public void setNotes(String notes) {
         this.notes = notes;
     }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", firstName=" + firstName + ", sexe=" + sexe + ", birth=" + birth + ", placeBirth=" + placeBirth + ", socialSecurityNumber=" + socialSecurityNumber + ", ipp=" + ipp + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", email=" + email + ", maritalStatus=" + maritalStatus + ", isInternet=" + isInternet + ", weight=" + weight + ", size=" + size + ", isValide=" + isValide + ", allergies=" + allergies + ", diseases=" + diseases + ", antecedents=" + antecedents + ", validEntourage=" + validEntourage + ", placeAccesible=" + placeAccesible + ", notes=" + notes + ", id=" + id + '}';
    }
     
 }