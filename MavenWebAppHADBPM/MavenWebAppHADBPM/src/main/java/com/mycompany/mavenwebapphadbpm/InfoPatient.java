/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import model.Patient;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         // JSON File Creation      
        int cpt = 1;
        String json = "{\n" +
                "    \"info\": [\n";
        
        // Intialisation
        //File f = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
        //File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //ALEXANDRE
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl"); // Pauline
        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
        String id = request.getParameter("id");
        Patient patient = onto.searchPatient("p123456789", reasoner);
        System.out.println(patient.getFirstName());
        
        json += "{\"name\": \"" + patient.getName() + "\"},\n";
        json += "{\"firstName\": \"" + patient.getFirstName() + "\"},\n";
        json += "{\"sexe\": \"" + patient.getSexe() + "\"},\n";
        json += "{\"birth\": \"" + patient.getBirth() + "\"},\n";
        json += "{\"placeBirth\": \"" + patient.getPlaceBirth() + "\"},\n";
        json += "{\"socialSecurityNumber\": \"" + patient.getSocialSecurityNumber() + "\"},\n";
        json += "{\"ipp\": \"" + patient.getIpp() + "\"},\n";
        json += "{\"adress\": \"" + patient.getAdress() + "\"},\n";
        json += "{\"phoneNumber\": \"" + patient.getPhoneNumber() + "\"},\n";
        json += "{\"email\": \"" + patient.getEmail() + "\"},\n";
        json += "{\"maritalStatus\": \"" + patient.getMaritalStatus() + "\"},\n";
        json += "{\"isInternet\": \"" + patient.getIsInternet() + "\"},\n";
        json += "{\"weight\": \"" + patient.getWeight() + "\"},\n";
        json += "{\"size\": \"" + patient.getSize() + "\"},\n";
        json += "{\"isValide\": \"" + patient.getIsValide() + "\"},\n";
        json += "{\"allergies\": \"" + patient.getAllergies() + "\"},\n";
        json += "{\"antecedents\": \"" + patient.getAntecedents() + "\"},\n";
        json += "{\"validEntourage\": \"" + patient.getValidEntourage() + "\"},\n";
        json += "{\"placeAccesible\": \"" + patient.getPlaceAccesible() + "\"},\n";
        json += "{\"notes\": \"" + patient.getNotes() + "\"}\n";
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
