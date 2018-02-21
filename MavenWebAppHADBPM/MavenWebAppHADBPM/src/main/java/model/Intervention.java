package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Intervention {

    private String name;
    private String typeActor;
    private int duration;
    private UnityTime unityDuration;
    private String frequency;
    private UnityTime unityFrequency;
    private ArrayList<TimeDay> timeDay;
    private HomeCareStructure homeCareStructure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeActor() {
        return typeActor;
    }

    public void setTypeActor(String typeActor) {
        this.typeActor = typeActor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public UnityTime getUnityDuration() {
        return unityDuration;
    }

    public void setUnityDuration(UnityTime unityDuration) {
        this.unityDuration = unityDuration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public UnityTime getUnityFrequency() {
        return unityFrequency;
    }

    public void setUnityFrequency(UnityTime unityFrequency) {
        this.unityFrequency = unityFrequency;
    }



    public HomeCareStructure getHomeCareStructure() {
        return homeCareStructure;
    }

    public void setHomeCareStructure(HomeCareStructure homeCareStructure) {
        this.homeCareStructure = homeCareStructure;
    }


    public Intervention(String name) {
        this.name = name;
    }
    
    public Intervention(String name, String typeActor, int duration, UnityTime unityDuration, String frequency, UnityTime unityFrequency, ArrayList<TimeDay> timeDay, HomeCareStructure homeCareStructure, ArrayList<String> moment) {
        this.name = name;
        this.typeActor = typeActor;
        this.duration = duration;
        this.unityDuration = unityDuration;
        this.frequency = frequency;
        this.unityFrequency = unityFrequency;
        this.timeDay = timeDay;
        this.homeCareStructure = homeCareStructure;
    }

    public ArrayList<TimeDay> getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(ArrayList<TimeDay> timeDay) {
        this.timeDay = timeDay;
    }

    @Override
    public String toString() {
        return "Intervention{" + "name=" + name + ", typeActor=" + typeActor + ", duration=" + duration + ", unityDuration=" + unityDuration + ", frequency=" + frequency + ", unityFrequency=" + unityFrequency + ", timeDay=" + timeDay + ", homeCareStructure=" + homeCareStructure + '}';
    }
    
    
    
    
}
