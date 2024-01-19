package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Water extends Biome {

  // Constructor //

  public Water() {
    this.type = BiomeEnum.WATER;
    this.description = "This plot is a water.";
    this.img = getClass().getResource("/ive/statera/img/tiles/water.png");
    this.animalProportion = 10;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }

}
