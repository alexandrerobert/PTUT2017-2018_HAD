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
class Disease {
    
    String hasDisease;
    int hasStade;
    ArrayList<Intervention> interventions;

    public String getHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(String hasDisease) {
        this.hasDisease = hasDisease;
    }

    public int getHasStade() {
        return hasStade;
    }

    public void setHasStade(int hasStade) {
        this.hasStade = hasStade;
    }


    public ArrayList<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<Intervention> interventions) {
        this.interventions = interventions;
    }
    
    
}
