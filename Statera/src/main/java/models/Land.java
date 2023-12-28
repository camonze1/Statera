package models;

import enums.BiomeEnum;
import java.util.*;

public class Land {
  private int humanBalance;
  private int animalBalance;
  private int naturalBiomeBalance;
  private int waterBalance;
  private int buildingBalance;
  private int nbHuman;
  private int nbAnimal;
  private ArrayList<Animal> animal;
  private ArrayList<ArrayList<Biome>> land;

  public Land(int line, int column) {
    this.land = new ArrayList<ArrayList<Biome>>();
    Random random = new Random();
    for (int i = 0; i < line; i++) {
      ArrayList<Biome> lines = new ArrayList<Biome>();
      for (int j = 0; j < column; j++) {
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

  public Biome getBiome(int line, int column) {
    return this.land.get(line).get(column);
  }

  public void setBiome(int line, int column, BiomeEnum type) {
    if (type == BiomeEnum.GRASS) {
      this.land.get(line).set(column, new Grass());
    } else if (type == BiomeEnum.WATER) {
      this.land.get(line).set(column, new Water());
    } else if (type == BiomeEnum.DESERT) {
      this.land.get(line).set(column, new Desert());
    } else if (type == BiomeEnum.MOUNTAIN) {
      this.land.get(line).set(column, new Mountain());
    } else if (type == BiomeEnum.BUILDING) {
      this.land.get(line).set(column, new Building());
    } else if (type == BiomeEnum.FOREST) {
      this.land.get(line).set(column, new Forest());
    } else if (type == BiomeEnum.JUNGLE) {
      this.land.get(line).set(column, new Jungle());
    } else if (type == BiomeEnum.BLOCKEDWASTELAND) {
      this.land.get(line).set(column, new BlockedWasteland());
    } else if (type == BiomeEnum.FREEWASTELAND) {
      this.land.get(line).set(column, new FreeWasteland());
    }
  }

  // This function gives the number of plots whose type is a natural biome.
  public int getNumberOfNaturalBiome() {
    return getNumberOfOccupiedPlotByType(BiomeEnum.GRASS) + getNumberOfOccupiedPlotByType(BiomeEnum.FOREST) + getNumberOfOccupiedPlotByType(BiomeEnum.JUNGLE) + getNumberOfOccupiedPlotByType(BiomeEnum.DESERT) + getNumberOfOccupiedPlotByType(BiomeEnum.MOUNTAIN);
  }

  public double getBalanceOfNaturalBiome() {
    int totalPlot = getTotalOfNonBlockedWastelandPlot();
    double targetNaturalBiomePercentage = 0.4;
    int targetNumberOfNaturalBiomes = (int) (targetNaturalBiomePercentage * totalPlot);
    System.out.println("targetNumberOfNaturalBiomes : " + targetNumberOfNaturalBiomes);
    double currentNaturalBiomePercentage = (double) getNumberOfNaturalBiome() / totalPlot;
    double naturalBiomeBalance = (Math.abs(currentNaturalBiomePercentage - targetNaturalBiomePercentage) / targetNaturalBiomePercentage) * 100;
    return 100 - naturalBiomeBalance;
  }

  public double getBalanceOfWaterBiome() {
    int totalPlot = getTotalOfNonBlockedWastelandPlot();
    double targetWaterPercentage = 0.4;
    int targetNumberOfWaterBiomes = (int) (targetWaterPercentage * totalPlot);
    System.out.println("targetNumberOfWaterBiomes : " + targetNumberOfWaterBiomes);
    double currentWaterPercentage = (double) getNumberOfOccupiedPlotByType(BiomeEnum.WATER) / totalPlot;
    double waterBalance = (Math.abs(currentWaterPercentage - targetWaterPercentage) / targetWaterPercentage) * 100;
    return 100 - waterBalance;
  }

  public double getBalanceOfBuildingBiome() {
    int totalPlot = getTotalOfNonBlockedWastelandPlot();
    double targetBuildingPercentage = 0.2;
    int targetNumberOfBuildingBiomes = (int) (targetBuildingPercentage * totalPlot);
    System.out.println("targetNumberOfBuildingBiomes : " + targetNumberOfBuildingBiomes);
    double currentBuildingPercentage = (double) getNumberOfOccupiedPlotByType(BiomeEnum.BUILDING) / totalPlot;
    double buildingBalance = (Math.abs(currentBuildingPercentage - targetBuildingPercentage) / targetBuildingPercentage) * 100;
    return 100 - buildingBalance;
  }

  public double environmentBalance() {
    return ((getBalanceOfNaturalBiome() + getBalanceOfBuildingBiome() + getBalanceOfWaterBiome()) / 3);
  }

  // This function gives the number of occupied plots.
  public HashMap<BiomeEnum, Integer> getCostOfPlot(int line, int column) {
    HashMap<BiomeEnum, Integer> cost = new HashMap<BiomeEnum, Integer>();
    HashMap<BiomeEnum, Integer> temp = this.land.get(line).get(column).getCost();
    for (BiomeEnum key : temp.keySet()) {
      if (temp.get(key) != 0) {
        cost.put(key, temp.get(key));
      }
    }
    return cost;
  }

  public BiomeEnum getTypeOfBiomeByCoordinatesOnClick(int line, int column) {
    return this.land.get(line).get(column).getType();
  }
  public List<int[]> getCoordinatesByBiomeType(BiomeEnum biomeType) {
    List<int[]> coordinatesList = new ArrayList<>();
    for (int i = 0; i < this.land.size(); i++) {
      for (int j = 0; j < this.land.get(0).size(); j++) {
        if (this.land.get(i).get(j).getType() == biomeType) {
          int[] coordinates = {i, j};
          coordinatesList.add(coordinates);
        }
      }
    }
    return coordinatesList;
  }

  public void setFreeWasteland(int line, int column) {
    this.land.get(line).set(column, new FreeWasteland());
  }

  public int getNumberOfOccupiedPlot() {
    int numberOccupiedPlot = 0;
    for (int i = 0; i < this.land.get(1).size(); i++) {
      for (int j = 0; j < this.land.get(1).size(); j++) {
        if (this.land.get(i).get(j).getType() != BiomeEnum.BLOCKEDWASTELAND && this.land.get(i).get(j).getType() != BiomeEnum.FREEWASTELAND) {
          numberOccupiedPlot = numberOccupiedPlot + 1;
        }
      }
    }
    return numberOccupiedPlot;
  }

  // This function displays the number of occupied plots of the type entered.
  public int getNumberOfOccupiedPlotByType(BiomeEnum type) {
    int numberOccupiedPlot = 0;
    for (int i = 0; i < this.land.get(1).size(); i++) {
      for (int j = 0; j < this.land.get(1).size(); j++) {
        if (this.land.get(i).get(j).getType() == type) {
          numberOccupiedPlot = numberOccupiedPlot + 1;
        }
      }
    }
    return numberOccupiedPlot;
  }

  // This function gives the number of unblocked plots.
  public int getTotalOfNonBlockedWastelandPlot() {
    int totalNumberOfAvailablePlot = 0;
    for (int i = 0; i < this.land.get(1).size(); i++) {
      for (int j = 0; j < this.land.get(1).size(); j++) {
        if (this.land.get(i).get(j).getType() != BiomeEnum.BLOCKEDWASTELAND) {
          totalNumberOfAvailablePlot = totalNumberOfAvailablePlot + 1;
        }
      }
    }
    return totalNumberOfAvailablePlot;
  }

  // This function gives the number of unoccupied plots. Wasteland biomes are considered unoccupied.
  public int getNumberOfNonOccupiedPlot() {
    int numberNonOccupiedPlot = 0;
    for (int i = 0; i < this.land.get(1).size(); i++) {
      for (int j = 0; j < this.land.get(1).size(); j++) {
        if (this.land.get(i).get(j).getType() == BiomeEnum.BLOCKEDWASTELAND || this.land.get(i).get(j).getType() == BiomeEnum.FREEWASTELAND) {
          numberNonOccupiedPlot = numberNonOccupiedPlot + 1;
        }
      }
    }
    return numberNonOccupiedPlot;
  }

  public int[] getLandSize() {
    return new int[]{this.land.size(), this.land.get(0).size()};
  }

  public int getLandSizeTotal() {
    return this.land.size() * this.land.get(0).size();
  }

  public void globalBalance() {
    // TODO
    // Balance global du jeu -> 50% biosphere 50% environnement
  }

  public void biosphereBalance() {
    // TODO
    // Balance des êtres vivants -> 10 humans pour 100 animals pour 1 plot
    // get les proportions des animals et humans par plot dans tout le land
  }

}
