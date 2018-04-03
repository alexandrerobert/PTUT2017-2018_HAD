/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenwebapphadbpm;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disease;
import model.Intervention;
import model.Ontology;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import com.google.gson.Gson;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import model.HomeCareStructure;
import model.TimeDay;
import model.UnityTime;

/**
 *
 * @author lexr
 */
public class AddDisease extends HttpServlet {

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
            throws ServletException, IOException, ParseException, JSONException {
        response.setContentType("text/html;charset=UTF-8");      

        // Intialisation
        //File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl"); //ALEXANDRE
        File file = new File("C:\\Users\\Pauline\\Dropbox\\Ontoflow\\CodeSabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");
        //File file = new File("C:\\Users\\chaum\\Documents\\Castres\\ISIS\\S8\\PTUT\\Ontoflow\\Ontoflow\\codesabrina\\Ontologies\\HCBPMNOntology\\HCO.owl");//Anais
        Ontology onto = new Ontology(file);
        String nameDisease = request.getParameter("name");
//        try {
//            JSONObject jsonObj = new JSONObject(request.getParameter("interventions"));
//            System.out.println(jsonObj);
//        } catch (JSONException ex) {
//            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try (JsonReader reader = Json.createReader(new StringReader(request.getParameter("interventions")))) {
            JsonObject obj = reader.readObject();
            JsonArray interventions = (JsonArray) obj.get("interventions");
            ArrayList<Intervention> interventionsList = new ArrayList();
            for(int i = 0; i < interventions.size(); i++){        
                JsonArray inter = (JsonArray) interventions.getJsonArray(i);               
                String actor = inter.getJsonObject(0).values().toArray()[0].toString();
                HomeCareStructure homeCareStructure = null;
                switch(inter.getJsonObject(1).values().toArray()[0].toString()){
                    case "AtHome" :
                        homeCareStructure = HomeCareStructure.AtHome;
                    case "HomeCare" :
                        homeCareStructure = HomeCareStructure.HomeCare;
                    case "MedicalAnalysisLaboratory" :
                        homeCareStructure = HomeCareStructure.MedicalAnalysisLaboratory;
                }                            
                String action = inter.getJsonObject(2).values().toArray()[0].toString();
                String frequence = inter.getJsonObject(3).values().toArray()[0].toString();
                UnityTime frequenceUnit = null;
                switch(inter.getJsonObject(4).values().toArray()[0].toString()){
                    case "day" :
                        frequenceUnit = UnityTime.day;
                    case "week" :
                        frequenceUnit = UnityTime.week;
                    case "month" :
                        frequenceUnit = UnityTime.month;
                }
                TimeDay frequenceMoment = null;
                switch(inter.getJsonObject(5).values().toArray()[0].toString()){
                    case "afternoon" :
                        frequenceMoment = TimeDay.afternoon;
                    case "evening" :
                        frequenceMoment = TimeDay.evening;
                    case "morning" :
                        frequenceMoment = TimeDay.morning;
                    case "night" :
                        frequenceMoment = TimeDay.night;
                }
                String durationstring = inter.getJsonObject(6).values().toArray()[0].toString();
                int duration = Integer.parseInt(durationstring);               
                UnityTime durationUnit = null;
                switch(inter.getJsonObject(7).values().toArray()[0].toString()){
                    case "day" :
                        durationUnit = UnityTime.day;
                    case "week" :
                        durationUnit = UnityTime.week;
                    case "month" :
                        durationUnit = UnityTime.month;
                    case "year" :
                        durationUnit = UnityTime.year;
                }
                Intervention newInter = new Intervention(action,actor,duration,durationUnit,frequence,frequenceUnit,frequenceMoment,homeCareStructure);
                interventionsList.add(newInter);                       
            }
            Disease newDisease = new Disease (nameDisease, interventionsList);
            onto.addDisease(newDisease, nameDisease);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (JSONException ex) {
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
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
