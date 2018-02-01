package Model;

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
private int weight;
private int size;
private Boolean isValide;
private String allergies;
private String pathology;
private String antecedents;
private Boolean validEntourage;
private Boolean placeAccesible;
private String notes;
private String id;

public Patient(){}
 
public Patient(String id, String name, String firstName, Sexe sexe, Date birth, String placeBirth, int socialSecurityNumber, String ipp, String adress, int phoneNumber, MaritalStatus maritalStatus, String email, Boolean isInternet, int weight, int size, Boolean isValide, String allergies, String pathology, String antecedents, Boolean validEntourage, Boolean placeAccesible, String notes) {
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
         this.pathology = pathology;
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
 
     public int getWeight() {
         return weight;
     }
 
     public void setWeight(int weight) {
         this.weight = weight;
     }
 
     public int getSize() {
         return size;
     }
 
     public void setSize(int size) {
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
 
     public String getPathology() {
         return pathology;
     }
 
     public void setPathology(String pathology) {
         this.pathology = pathology;
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
     
 }