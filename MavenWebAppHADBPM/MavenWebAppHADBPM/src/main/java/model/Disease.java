/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Pauline
 */
public class Disease {

    public Disease(String hasDisease, ArrayList<Intervention> interventions) {
        this.hasDisease = hasDisease;
        this.interventions = interventions;
    }
    
    String hasDisease;
    /**
     * The list of activities for the disease
     */
    ArrayList<Intervention> interventions;

    public String getHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(String hasDisease) {
        this.hasDisease = hasDisease;
    }

    public ArrayList<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<Intervention> interventions) {
        this.interventions = interventions;
    }
    
    
}
