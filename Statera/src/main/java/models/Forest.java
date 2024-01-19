package models;

import enums.BiomeEnum;

public class Forest extends Biome {

  //  Constructor  //

  public Forest() {
    this.type = BiomeEnum.FOREST;
    this.description = "This plot is a forest.";
    this.cost.replace(BiomeEnum.GRASS, 1);
    this.cost.replace(BiomeEnum.WATER, 1);
    this.img = getClass().getResource("/ive/statera/img/tiles/forest.png");
    this.animalProportion = 18;
  }

  //  Methods  //
  
  public boolean isOccupied() {
    return true;
  }

}
