package models;

import enums.BiomeEnum;

import java.util.ArrayList;

public class Land {
    // Balance of the land
    private int humanBalance;
    private int vegetationBalance;
    private int waterBalance;
    private int animalBalance;
    private Integer Lignes;
    private Integer Colonnes;

    // Lists
    private ArrayList<Animal> animal;

    // Attributs
    private int nbHuman;
    private int nbAnimal;
    private ArrayList<ArrayList<Biome>> land;

    // Constructor with parameters
    public Land(int ligne, int colonne) {
        this.land = new ArrayList<ArrayList<Biome>>();
        for (int i = 0; i < ligne; i++) {
            ArrayList<Biome> TableauPro = new ArrayList<Biome>();
            for (int j = 0; j < colonne; j++) {
                TableauPro.add(new Wasteland());
            }
            this.land.add(TableauPro);
        }
        this.Lignes=ligne;
        this.Colonnes=colonne;
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

    public int[] getLandSize(){;
        return new int[]{this.Lignes,this.Colonnes};
    }
    public int getLandSizeTotal(){;
        return this.Lignes*this.Colonnes;
    }
    public int getOccupiedPlot(){
        int ctr = 0;
        for (int i = 0; i < this.land.get(1).size(); i++) {
            for (int j = 0; j < this.land.get(1).size(); j++) {
                if (this.land.get(i).get(j).getType() != BiomeEnum.WASTELAND) {
                    ctr = ctr + 1;
                }
            }
        }
        return ctr;
    }
}
