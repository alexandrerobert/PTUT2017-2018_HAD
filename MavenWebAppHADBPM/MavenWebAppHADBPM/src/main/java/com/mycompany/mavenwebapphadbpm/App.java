package com.mycompany.mavenwebapphadbpm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * Hello world!
 *
 */
public class App {

	OWLNamedIndividual i = null;

	/**
	 * @param args
	 * @throws OWLOntologyStorageException
	 * @throws OWLOntologyCreationException
	 * @throws IOException
	 */
	public static void main(String[] args)
			throws OWLOntologyStorageException, OWLOntologyCreationException, IOException {
		//OWLOntologyManager man = OWLManager.createOWLOntologyManager();

		// File file = new File("d:\\Users\\admin\\Desktop\\cours\\ptut\\HCO.owl");
		// File file = new
		// File("//home//lexr//Dropbox//Ontoflow//CodeSabrina//Ontologies//HCBPMNOntology//HCO.owl");
		File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //Alexandre
                //File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");


		System.out.println("\t\t\tAffiche les classes du document");

		//OWLClass acteur = null;	
		
		Ontology onto = new Ontology(file);
         
		OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
			
		// WORKING !!!!
		
		// Retrieve all the classes of the ontology
		System.out.println("\t\t\tToutes les classes de l'ontologie");
		for (OWLClass cls : onto.getAllClasses() ){
			//System.out.println(cls.getIRI().getFragment());
			System.out.println(cls.getIRI().getRemainder().get());
		}
		
		//ArrayList<String> liste = onto.getPatientInOntology(reasoner, "Patient");
		// Affiche toutes les propriétés d'un patient
		System.out.println("\t\t\tListes des propriétés d'un patient (Joelle)");
		/*
                for (String patient : liste) {
			System.out.println(patient);
			//if (patient) {
				HashMap<String, String> propMap = onto.getIndividualProperties(reasoner, patient);
				//ArrayList<String> prop = onto.getIndividualProperties(reasoner, patient);
//				for(String p : prop) {
//					System.out.println(p);
//				}
				
				for (Entry<String, String> values:propMap.entrySet()) {
					System.out.println("Clé : " + values.getKey() + " valeur :" + values.getValue());
				}
			//}
			
		}*/
		
		// WORKING !!!! Insert a new patient in the ontology
		Info disease = new Info("Disease", "Undernutrition", "");
		// hasAdress
		Info address = new Info("hasAdress", "9 Downing Street", "String");
		// hasAllergies
		Info allergies = new Info("hasAllergies", "Gluten", "String");
		// hasBMI
		Info bmi = new Info("hasBMI", "60", "String");
		// hasDateOfBirth
		Info dateOfBirth = new Info("hasDateOfBirth", "25/10/1985", "Date");
		// hasDateOfAdmission
		Info dateOfAd = new Info("hasDateOfAdmission", "12/10/2011", "Date");
		// hasDateofDischarge
		Info dateOfDischarge = new Info("dateOfDischarge", "05/07/2017", "Date");
		// hasEmail
		Info email = new Info("hasEmail", "remi.gaillard@lol.com", "String");
		// hasFirstName
		Info firstName = new Info("hasFirstName", "Rémi", "String");
		// hasName
		Info name = new Info("hasName", "Gaillard", "String");
		// hasPhoneNumber
		//Info phoneNumber = new Info("hasPhoneNumber", "071231212", "String");
		// hasPlaceOfBirth
		Info placeOfBirth = new Info("hasPlaceOfBirth", "Lodon", "String");
		// hasSex
		Info sex = new Info("hasSex", "Male", "String");
		// hasSize
		Info size = new Info("hasSize", "160.0", "float");
		// hasSocialSecurityNumber
		Info socialSecurityNumber = new Info("hasSocialSecurityNumber", "12345678", "int");
		// hasWeight
		Info weight = new Info("hasWeight", "85.0", "String");
		// hasReferenceNumberID
		//Info numberId = new Info("hasReferenceNumberID", "", "");
		// hasMaritalStatus
		Info maritalStatus = new Info("hasMaritalStatus","Married","String");
		
		ArrayList<Info> infos = new ArrayList<>();
		infos.add(disease);
		infos.add(address);
		infos.add(allergies);
		infos.add(bmi);
		infos.add(dateOfBirth);
		infos.add(dateOfAd);
		infos.add(dateOfDischarge);
		infos.add(email);
		infos.add(firstName);
		infos.add(name);
		//infos.add(phoneNumber);
		infos.add(placeOfBirth);
		infos.add(sex);
		infos.add(size);
		infos.add(socialSecurityNumber);	
		infos.add(weight);
		//infos.add(numberId);
		infos.add(maritalStatus);
		
		// Add the patient to the ontology
		onto.addPatientIndividual(infos, "Remi");
                
                /*
                HashMap<String, String> actionData = onto.getIndividualProperties(reasoner, "VesicularPeritonitis");
                System.out.println("liste des dataproperties de vesicular peritonitis");
                for (Map.Entry<String, String> values:actionData.entrySet()) {    
                    System.out.println("Clé : " + values.getKey() + " valeur :" + values.getValue());
                }
                // Test de l'application pour 
                System.out.println("Affichage des dataproperties pour vesicular avec la fonction test");
                onto.test(reasoner, "VesicularPeritonitis");
                */
                
                System.out.println("Essai de la nouvelle fonction pour l'interface searchPatient.jsp");
                onto.getPatientInOntology(reasoner, "Patient");
                
        }	

	

}