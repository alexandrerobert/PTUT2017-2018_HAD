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
    
    String name;
    ArrayList<Intervention> interventions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(ArrayList<Intervention> interventions) {
        this.interventions = interventions;
    }
    
    
}
