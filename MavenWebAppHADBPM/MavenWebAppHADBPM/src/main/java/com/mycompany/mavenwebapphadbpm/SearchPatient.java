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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * Class That will handle the request when a user is looking for a patient The
 * main goal is to take the information about all the patient in the ontology
 * folowwing the pattern given by the user of the web application.
 *
 * @author lexr
 */
public class SearchPatient extends HttpServlet {

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
        String json = "{\"patients\": [\n";
        int cpt = 1 ;

        // Intialisation
        //File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //Alexandre
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO1.owl"); //Pauline
        //File file = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());

        /**
         * A list of all the patients
         */
        ArrayList<Patient> patientList = onto.getPatientInOntology(reasoner, "Patient");
        for (Patient patient : patientList) {
            if (cpt > 1) {
                json += ",";
            }
            // Create the object for an individual
            json += "{\"id\": \"" + patient.getId() + "\",\n";
            json += "\"name\": \"" + patient.getFirstName() + "\",\n";
            json += "\"lastName\": \"" + patient.getName() + "\"}\n";
            cpt++;
        }
        
        // Close the json file
        json += "      ]\n}";
        System.out.println(json);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
