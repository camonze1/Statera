package models;

import enums.BiomeEnum;

public class Desert extends Biome {

  //  Constructor  //

  public Desert() {
    this.type = BiomeEnum.DESERT;
    this.description = "This plot is a desert.";
    this.cost.replace(BiomeEnum.GRASS, 3);
    this.cost.replace(BiomeEnum.WATER, 2);
    this.img = getClass().getResource("/ive/statera/img/tiles/desert.png");
    this.animalProportion = 8;
  }

  //  Methods  //
  
  public boolean isOccupied() {
    return true;
  }

}
