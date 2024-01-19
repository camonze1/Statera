package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Mountain extends Biome {

  //  Constructor  //

  public Mountain() {
    this.type = BiomeEnum.MOUNTAIN;
    this.description = "This plot is a mountain.";
    this.cost.replace(BiomeEnum.FOREST, 1);
    this.cost.replace(BiomeEnum.GRASS, 2);
    this.cost.replace(BiomeEnum.WATER, 1);
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/mountain.png").toExternalForm());
    this.animalProportion = 8;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }

}
