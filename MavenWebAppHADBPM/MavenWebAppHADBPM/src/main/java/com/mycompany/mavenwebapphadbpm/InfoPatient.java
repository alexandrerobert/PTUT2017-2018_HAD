/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import model.Ontology;
import model.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author lexr
 */
public class InfoPatient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.FileNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        
        
         // JSON File Creation      
        int cpt = 1;
        String json = "{\n" +
                "    \"info\": [\n";
        
        // Intialisation
        //File f = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
//        File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //ALEXANDRE
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl"); // Pauline
        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
        String id = request.getParameter("id");
        Patient patient = onto.getIndividualProperties(reasoner,id);
        
        json += "{\"hasName\": \"" + patient.getHasName() + "\"},\n";
        json += "{\"hasFirstName\": \"" + patient.getHasFirstName() + "\"},\n";
        json += "{\"hasSex\": \"" + patient.getHasSex() + "\"},\n";
        json += "{\"hasDateOfBirth\": \"" + patient.getHasDateOfBirth() + "\"},\n";
        json += "{\"hasPlaceOfBirth\": \"" + patient.getHasPlaceOfBirth() + "\"},\n";
        json += "{\"hasSocialSecurityNumberID\": \"" + patient.getHasSocialSecurityNumberID() + "\"},\n";
        json += "{\"hasAdress\": \"" + patient.getHasAdress() + "\"},\n";
        json += "{\"hasPhoneNumber\": \"" + patient.getHasPhoneNumber() + "\"},\n";
        json += "{\"hasEmail\": \"" + patient.getHasEmail() + "\"},\n";
        json += "{\"hasMaritalStatus\": \"" + patient.getHasMaritalStatus() + "\"},\n";
        json += "{\"isInternet\": \"" + patient.getIsInternet() + "\"},\n";
        json += "{\"hasWeight\": \"" + patient.getHasWeight() + "\"},\n";
        json += "{\"hasSize\": \"" + patient.getHasSize() + "\"},\n";
        json += "{\"isValide\": \"" + patient.getIsValide() + "\"},\n";
        json += "{\"hasAllergies\": \"" + patient.getHasAllergies() + "\"},\n";
        json += "{\"hasPrevious\": \"" + patient.getHasPrevious() + "\"},\n";
        json += "{\"isValideFamily\": \"" + patient.getIsValideFamily() + "\"},\n";
        json += "{\"isAccessiblePlace\": \"" + patient.getIsAccessiblePlace() + "\"},\n";
        json += "{\"hasNotes\": \"" + patient.getHasNotes() + "\"},\n";
        json += "{\"hasDiseases\": \"" + patient.getHasDiseases() + "\"},\n";
        json += "{\"isSmoking\": \"" + patient.getIsSmoking() + "\"},\n";
        json += "{\"isSport\": \"" + patient.getIsSport() + "\"}\n";
        json += "]}";
        System.out.println(json);
        
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(json);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
