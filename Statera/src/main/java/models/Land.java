package models;

import enums.BiomeEnum;

import java.util.ArrayList;
import java.util.Random;

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
  private ArrayList<ArrayList<Biome>> land;

  // Constructor with parameters
  public Land(int ligne, int colonne) {
    this.land = new ArrayList<ArrayList<Biome>>();
    Random random = new Random();
    for (int i = 0; i < ligne; i++) {
      ArrayList<Biome> lines = new ArrayList<Biome>();
      for (int j = 0; j < colonne; j++) {
        int randomValue = random.nextInt(6);
        if (randomValue == 0) {
          lines.add(new FreeWasteland());
        } else {
          lines.add(new BlockedWasteland());
        }
      }
      this.land.add(lines);
    }
  }

  // Methods
  // Balance global du jeu -> 50% biosphere 50% environnement
  public void globalBalance() {
    // TODO

  }

  // Balance des êtres vivants -> 10 humans pour 100 animals pour 1 plot
  public void biosphereBalance() {
    // TODO
    // get les proportions des animals et humans par plot dans tout le land
  }

  // Balance des environments -> 40% de vegetation 40% de water 20% d'infrastructures pour tout le land
  public void environmentBalance() {
    // TODO
    // get les proportions de chaque biome dans tout le land
  }

  public Biome getBiome(int ligne, int colonne) {
    return land.get(ligne).get(colonne);
  }

  public void setBiome(int ligne, int colonne, BiomeEnum type) {
    if (type == BiomeEnum.GRASS) {
      land.get(ligne).set(colonne, new Grass());
    } else if (type == BiomeEnum.WATER) {
      land.get(ligne).set(colonne, new Water());
    } else if (type == BiomeEnum.DESERT) {
      land.get(ligne).set(colonne, new Desert());
    } else if (type == BiomeEnum.MOUNTAIN) {
      land.get(ligne).set(colonne, new Mountain());
    } else if (type == BiomeEnum.BUILDING) {
      land.get(ligne).set(colonne, new Building());
    } else if (type == BiomeEnum.FOREST) {
      land.get(ligne).set(colonne, new Forest());
    } else if (type == BiomeEnum.JUNGLE) {
      land.get(ligne).set(colonne, new Jungle());
    } else if (type == BiomeEnum.BLOCKEDWASTELAND) {
      land.get(ligne).set(colonne, new BlockedWasteland());
    } else if (type == BiomeEnum.FREEWASTELAND) {
      land.get(ligne).set(colonne, new FreeWasteland());
    }

  }

  public BiomeEnum getBiomeType(int ligne, int colonne) {
    return land.get(ligne).get(colonne).getType();
  }

  public int getNumberAnimal() {
    return animal.size();
  }

  public int[] getLandSize() {
    ;
    return new int[]{this.land.size(), this.land.get(0).size()};
  }

  public int getLandSizeTotal() {
    ;
    return this.land.size() * this.land.get(0).size();
  }

  public int getOccupiedPlot() {
    int ctr = 0;
    for (int i = 0; i < this.land.get(1).size(); i++) {
      for (int j = 0; j < this.land.get(1).size(); j++) {
        if (this.land.get(i).get(j).getType() != BiomeEnum.BLOCKEDWASTELAND) {
          ctr = ctr + 1;
        }
      }
    }
    return ctr;
  }
}
