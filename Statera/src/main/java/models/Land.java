package models;

import java.util.ArrayList;

public class Land {
    // Balance of the land
    private int humanBalance;
    private int vegetationBalance;
    private int waterBalance;
    private int animalBalance;

    // Lists
    private ArrayList<Animal> animal;

    // Attributs
    private int nbHuman;
    private int nbAnimal;

    // Constructor with parameters
    public Land(int humanBalance, int vegetationBalance, int waterBalance, int animalBalance, ArrayList<Animal> animal, int nbHuman, int nbAnimal) {
        this.humanBalance = humanBalance;
        this.vegetationBalance = vegetationBalance;
        this.waterBalance = waterBalance;
        this.animalBalance = animalBalance;
        this.animal = animal;
        this.nbHuman = nbHuman;
        this.nbAnimal = nbAnimal;
    }

    // Methods
    // Balance global du jeu -> 50% biosphere 50% environnement
    public void globalBalance(){
        // TODO

    }
    // Balance des êtres vivants -> 10 humans pour 100 animals pour 1 plot
    public void biosphereBalance(){
        // TODO
        // get les proportions des animals et humans par plot dans tout le land

    }
    // Balance des environments -> 40% de vegetation 40% de water 20% d'infrastructures pour tout le land
    public void environmentBalance(){
        // TODO
        // get les proportions de chaque biome dans tout le land
    }

    public void getBiomeType(){
        // TODO


    }
    public void getLandSize(){
        // TODO
    }
    public void getOccupiedPlot(){


    }
}
