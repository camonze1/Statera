package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Building extends Biome {

  //  Constructor  //

  public Building() {
    this.type = BiomeEnum.BUILDING;
    this.description = "This plot is a building.";
    this.cost.replace(BiomeEnum.FOREST, 1);
    this.cost.replace(BiomeEnum.GRASS, 1);
    this.cost.replace(BiomeEnum.WATER, 1);
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/building.png").toExternalForm());
    this.animalProportion = 0;
    this.humanProportion = 6;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }
}