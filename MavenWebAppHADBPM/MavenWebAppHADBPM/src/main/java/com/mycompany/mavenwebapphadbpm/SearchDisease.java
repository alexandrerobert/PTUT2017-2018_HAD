/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import model.Ontology;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * List of the Disease for the autocomplete of searchDisease.jsp
 * @author lexr
 */
public class SearchDisease extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        
        // JSON File Creation     
        int cpt = 1;
        //String diseases = "{";
        String json = "{";  
        
        // Intialisation
        File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //Alexandre
        //File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");

        Ontology onto = new Ontology(file);
        OWLReasoner reasoner = onto.useReasoner(onto.getOntology());
        
        
        ArrayList<String> diseases = onto.searchDisease(reasoner, "Disease");
        int liste = 0;
        
        PrintWriter out = response.getWriter();
        for (String d:diseases) {
            
            if (liste == 0) {
                json += "\n\t\"disease\": [" + 
                        "\n\t\t{\"name\" : \"" + d + "\"},";
                
            } else {
                json += "\n\t\t{\"name\" : \"" + d + "\"},";
            }
            liste++;

        }
        // Delete the last coma for the diseases
        json = json.substring(0, json.length()-1);
        json += "\n\t]\n}";
        out.println(json);
      
        
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
