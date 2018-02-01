/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
                "    \"patients\": [\n";
        
        // Intialisation
        //File f = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
        //File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //ALEXANDRE
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl"); // Pauline

        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
        
        
        String nom = request.getParameter("nom");
        
        /**
         * A list of all the patients
         */
        ArrayList<String> patienttList = onto.getPatientInOntology(reasoner, "Patient");
        /**
         * A list of all the information of a patient
         */
        HashMap<String, String> ind = new  HashMap<>();
        
        // Look for a patient begining by the same patern
        for (String pat : patienttList) {
            if (pat.contains(nom)) {
                
                if (cpt > 1) {
                    json += ",";
                }
                
                // Look for properties for an individual
                HashMap<String, String> propMap = onto.getIndividualProperties(reasoner, pat);
                // Create the object for an individual
		json += "{\"id\": \"" + cpt + "\",\n";
                // Number of properties for an individual
                int nb = 0;
                // Look for the individual properties
                for (Map.Entry<String, String> values:propMap.entrySet()) {
                    // add information to the json file
                    json +="        \""+ values.getKey() +"\": \"" + values.getValue() + "\"\n";
                    
                    nb++;
                    // Look if we are at the end of the list for the properties of an individual
                    if (!(propMap.size() == nb)) {
                        json += ",";
                    }
                }
                cpt++;
                // Close the current individual object
                if (!(cpt == pat.length()))
                json+="}";
                
            }
        }
        // Close the json file
        json += "      ]\n" +
                "}";
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InfoPatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InfoPatient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
