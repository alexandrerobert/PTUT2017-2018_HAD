/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ontology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author lexr
 */
public class AddPatient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        // recover patient's informations with name in addPatient.jsp
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String sex = request.getParameter("sexe");
        String dobS = request.getParameter("dob");
        String pob = request.getParameter("pob");
        String socialSecurityNumber = request.getParameter("socialSecurityNumber");     //better    // int socialSecurityNumber = Integer.parseInt(request.getParameter("socialSecurityNumber"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");                       //better    //int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String marital = request.getParameter("marital");
        String internet = request.getParameter("internet");                             //better    //boolean internet = Boolean.parseBoolean(request.getParameter("internet"));
        String size = request.getParameter("size");                                     //better   // float size = Float.parseFloat(request.getParameter("size"));
        String weight = request.getParameter("weight");                                 //better    //  float weight = Float.parseFloat(request.getParameter("weight"));
        String allergies = request.getParameter("allergies");
        String disease = request.getParameter("disease");
        String previous = request.getParameter("previous");
        String entourage = request.getParameter("entourage");                           //better    // boolean entourage = Boolean.parseBoolean(request.getParameter("entourage"));
        String place = request.getParameter("place");                                   //better    //boolean entourage = Boolean.parseBoolean(request.getParameter("entourage"));
        String note = request.getParameter("note");
        
        //redirection if add valid or not 
        String vu_connValide = "/addPatient.jsp";
        String vu_connInvalide = "/searhPatient.jsp"; // to verify if add is invalid to modify after

        // Intialisation
        File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //ALEXANDRE
        //File file = new File("//home//lexr//Dropbox//Ontoflow//CodeSabrina//Ontologies//HCBPMNOntology//HCO.owl");
        //File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");
        //File file = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
       
        
        // Insert patient in ontology
        Info LastName = new Info("hasName", lastName, "String"); // hasName
        Info FirstName = new Info("hasFirstName", firstName, "String");// hasFirstName
        Info Sex = new Info("hasSex", sex, "String");// hasSex
        Info Dob = new Info("hasDateOfBirth", dobS, "Date");// hasDateOfBirth
        Info Pob = new Info("hasPlaceOfBirth", pob, "String"); // hasPlaceOfBirth
	Info SocialSecurityNumber = new Info("hasSocialSecurityNumber", socialSecurityNumber, "int"); // hasSocialSecurityNumber
        Info Address = new Info("hasAddress", address, "String");// hasAddress
	Info PhoneNumber = new Info("hasPhoneNumber", phoneNumber, "int");// hasPhoneNumber
        Info Email = new Info("hasEmail", email, "String"); // hasEmail
        Info Marital = new Info("hasMaritalStatus",marital,"String");// hasMaritalStatus
        Info Internet = new Info("hasInternetAccess", internet, "boolean");
        Info Size = new Info("hasSize", size, "float");         // hasSize
        Info Weight = new Info("hasWeight", weight, "float"); // hasWeight
        Info Allergies = new Info("hasAllergies", allergies, "String"); //hasAllergies
        Info Disease = new Info("hasDisease", disease, "String");// hasDisease
	Info Previous = new Info("hasPrevious", previous, "String");// hasPrevious
        Info Entourage = new Info("hasValidEntourage", entourage, "boolean");// hasValidEntourage
        Info Place = new Info("hasAccessiblePlace", place, "boolean");// hasAccessiblePlace
        Info Note = new Info("hasNotes", note, "String");// hasNotes
        //Info Note2 = new Info("Disease", note, "String");// hasNotes        //test à enlever

        
        //Create ArrayList to insert in the file ontology
	ArrayList<Info> infos = new ArrayList<>();
	infos.add(Disease);	
        infos.add(LastName);
	infos.add(FirstName);
	infos.add(Sex);
	infos.add(Dob);
	infos.add(Pob);
	infos.add(SocialSecurityNumber);
	infos.add(Address);
	infos.add(PhoneNumber);
	infos.add(Email);
	infos.add(Marital);
	infos.add(Internet);
	infos.add(Size);
	infos.add(Weight);
	infos.add(Allergies);
	infos.add(Previous);
	infos.add(Entourage);
	infos.add(Place);
        infos.add(Note);
		
	

        // Add the patient to the ontology
        String id = new SimpleDateFormat("ddMMyyyyhhMMss").format(Calendar.getInstance().getTime());
        onto.addPatientIndividual(infos, id);
        
        
        
//        
//        String disease = request.getParameter("disease").toString();
//        
//            System.out.println(disease);
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
