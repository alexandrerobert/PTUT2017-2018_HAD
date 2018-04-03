/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Intervention;
import model.Ontology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author lexr
 */
public class GetDisease extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        // JSON File Creation     
        int cpt = 1;
        //String diseases = "{";
        String json = "{";

        // Intialisation
        //File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //Alexandre
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");

        Ontology onto = new Ontology(file);
        List<String> diseases = onto.getListofDisease();
        

        // Pattern of the patient name
        //String nom = request.getParameter("nom");
        PrintWriter out = response.getWriter();
        
        json += "\n\t\t\t\"diseases\": [\n";

        // Retrieve all the informations about a disease
        ArrayList<Intervention> interventions;
        for (String d : diseases) {
                if (cpt == 1) {
                    json += "\t\t\t{\"name\" : \"" + d + "\"},";
                } else {
                    json += "\n\t\t\t{\"name\" : \"" + d + "\"},";
                }
                cpt++;
            }
            // Delete the last coma for the diseases
            json = json.substring(0, json.length() - 1);
            json += "\n\t]\n}";
            
        try {
            out.println(json);
        } catch (Exception ex) {
            Logger.getLogger(InfoDisease.class.getName()).log(Level.SEVERE, null, ex);
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
